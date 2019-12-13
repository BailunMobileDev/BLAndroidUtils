package com.bailun.utils;

import android.app.Application;

/**
 * 全局的Application
 *
 * @author yh
 * @date 2019/12/13
 */
public class BLAndroidUtils {

    private BLAndroidUtils() {
        throw new IllegalStateException("Utility class");
    }

    private static Application globalApplication;


    public static void initBLAndroidUtils(Application application) {
        globalApplication = application;
    }

    public static Application app() {
        if (globalApplication == null) {
            throw new NullPointerException("BLAndroidUtils Not Initialized");
        }
        return globalApplication;
    }
}
