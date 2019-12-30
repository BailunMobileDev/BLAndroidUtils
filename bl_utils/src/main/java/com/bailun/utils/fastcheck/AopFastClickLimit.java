package com.bailun.utils.fastcheck;

import android.util.Log;
import android.view.View;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * create by chl on 2019/12/24
 * description
 */
@Aspect
public class AopFastClickLimit {

    private static final String TAG = AopFastClickLimit.class.getName();
    private static boolean isShowLogEnable = true;

    public static void setIsShowLog(boolean isShowLog) {
        isShowLogEnable = isShowLog;
    }

    /**
     * 上一次点击的时间与控件的id
     */
    private static long mLastTime;
    private static int mLastClickId;

    //定义切面的切入点
    private static final String FAST_CLICK_POINT = "execution(* onClick(..))";

    private static final String BUTTER_KNIFE_POINT = "execution(@butterknife.OnClick * *(..))";

    private static final String FAST_CLICK_METHOD_POINT = "execution(@com.bailun.utils.fastcheck.BLFastClickLimit * *(..))";

    @Pointcut(FAST_CLICK_POINT)
    public void fastClickLimitMethod() {
    }

    @Pointcut(BUTTER_KNIFE_POINT)
    public void butterKnifeMethod() {
    }

    @Pointcut(FAST_CLICK_METHOD_POINT + " && @annotation(blFastClickLimit)")
    public void fastClickMethod(BLFastClickLimit blFastClickLimit) {
    }

    //处理特定的打上切点的方法
    @Around("fastClickMethod(blFastClickLimit)")
    public void aroundJoinPointMethod(ProceedingJoinPoint joinPoint, BLFastClickLimit blFastClickLimit) throws Throwable {
        showLog("aroundJoinPointMethod: start = " + blFastClickLimit.spaceTime() + " ;; " + System.currentTimeMillis());
        if (System.currentTimeMillis() - mLastTime >= blFastClickLimit.spaceTime()) {
            mLastTime = System.currentTimeMillis();
            joinPoint.proceed();
        } else {
            showLog("aroundJoinPointMethod: 无法快速点击: method");
        }
    }

    //处理特定的打上切点的方法
    @Around("fastClickLimitMethod()||butterKnifeMethod()")
    public void aroundJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        showLog("aroundJoinPoint: start = " + System.currentTimeMillis());
        Class pointClass = joinPoint.getTarget().getClass();
        Field[] fields = pointClass.getDeclaredFields();
        List<Field> limitClickFields = getLimitClickField(fields);
        if (limitClickFields.size() == 0) {
            joinPoint.proceed();
            return;
        }
        List<Integer> limitClickIds = getLimitClickIds(limitClickFields, joinPoint.getTarget());
        if (limitClickIds.size() == 0) {
            joinPoint.proceed();
            return;
        }
        View view = getClickView(joinPoint);
        if (view == null) {
            joinPoint.proceed();
            return;
        }
        if (mLastClickId != view.getId()) {
            mLastClickId = view.getId();
            mLastTime = System.currentTimeMillis();
            joinPoint.proceed();
            return;
        }
        BLFastClickLimit blFastClickLimit = getBlFastClickLimit(mLastClickId, limitClickFields, joinPoint.getTarget());
        if (blFastClickLimit == null) {
            joinPoint.proceed();
            return;
        }
        long spaceTime = blFastClickLimit.spaceTime();
        showLog("aroundJoinPoint: spaceTime = " + spaceTime);
        if (System.currentTimeMillis() - mLastTime < spaceTime) {
            showLog("aroundJoinPoint: 无法快速点击");
        } else {
            mLastTime = System.currentTimeMillis();
            joinPoint.proceed();
        }
    }

    private void showLog(String msg) {
        if (isShowLogEnable) {
            Log.e(TAG, msg);
        }
    }

    //获取点击View上方的注解对象
    private BLFastClickLimit getBlFastClickLimit(int mLastClickId, List<Field> limitClickFields, Object target) {
        for (int i = 0; i < limitClickFields.size(); i++) {
            Field field = limitClickFields.get(i);
            field.setAccessible(true);
            try {
                Object object = field.get(target);
                if (object instanceof View) {
                    int id = ((View) object).getId();
                    if (id == mLastClickId) {
                        return field.getAnnotation(BLFastClickLimit.class);
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    //获取点击响应的控件
    private View getClickView(ProceedingJoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        if (args != null && args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                if (args[i] instanceof View) {
                    View view = (View) args[i];
                    if (view.getId() != View.NO_ID) {
                        return view;
                    }
                }
            }
        }
        return null;
    }

    //筛选出添加注解变量中的控件并返回id
    private List<Integer> getLimitClickIds(List<Field> limitClickFields, Object target) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < limitClickFields.size(); i++) {
            Field field = limitClickFields.get(i);
            field.setAccessible(true);
            try {
                Object object = field.get(target);
                if (object instanceof View) {
                    result.add(((View) object).getId());
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    //筛选出添加了BLFastClickLimit注解的变量
    private List<Field> getLimitClickField(Field[] fields) {
        List<Field> result = new ArrayList<>();
        if (fields != null && fields.length > 0) {
            for (int i = 0; i < fields.length; i++) {
                if (fields[i].isAnnotationPresent(BLFastClickLimit.class) ) {
                    result.add(fields[i]);
                }
            }
        }
        return result;
    }
}
