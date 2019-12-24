package com.bailun.utils;

import android.util.DisplayMetrics;

/**
 * create by ouyangjianfeng on 2019/12/16
 * description:dp,sp,px转换
 */
public class BLDisPlayUtils {

    private BLDisPlayUtils() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * dp转px
     */
    public static int dip2px(float dipFloat) {
        float f = getDisplayMetrics().density;
        return (int) (dipFloat * f + 0.5F);
    }

    /**
     * px转dp
     */
    public static int px2dip(float pxFloat) {
        float f = getDisplayMetrics().density;
        return (int) (pxFloat / f + 0.5F);
    }

    /**
     * sp转px
     */
    public static int sp2px(float spFloat) {
        float f = getDisplayMetrics().scaledDensity;
        return (int) (spFloat * f + 0.5F);
    }

    /**
     * px转sp
     */
    public static int px2sp(float pxFloat) {
        float f = getDisplayMetrics().scaledDensity;
        return (int) (pxFloat / f + 0.5F);
    }


    private static DisplayMetrics getDisplayMetrics() {
        return BLAndroidUtils.app().getResources().getDisplayMetrics();
    }
}
