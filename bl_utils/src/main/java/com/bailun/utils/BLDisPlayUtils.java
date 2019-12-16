package com.bailun.utils;

import android.content.Context;

/**
 * create by ouyangjianfeng on 2019/12/16
 * description:dp,sp,px转换
 */
public class BLDisPlayUtils {

    /**
     * dp转px
     *
     * @param context
     * @param dipFloat
     * @return
     */
    public static int dip2px(Context context, float dipFloat) {
        float f = context.getResources().getDisplayMetrics().density;
        return (int) (dipFloat * f + 0.5F);
    }

    /**
     * px转dp
     *
     * @param context
     * @param pxFloat
     * @return
     */
    public static int px2dip(Context context, float pxFloat) {
        float f = context.getResources().getDisplayMetrics().density;
        return (int) (pxFloat / f + 0.5F);
    }

    /**
     * sp转px
     *
     * @param context
     * @param spFloat
     * @return
     */
    public static int sp2px(Context context, float spFloat) {
        float f = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spFloat * f + 0.5F);
    }

    /**
     * px转sp
     *
     * @param context
     * @param pxFloat
     * @return
     */
    public static int px2sp(Context context, float pxFloat) {
        float f = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxFloat / f + 0.5F);
    }
}
