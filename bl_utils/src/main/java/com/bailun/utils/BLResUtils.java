package com.bailun.utils;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;

import androidx.annotation.ArrayRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;

/**
 * 获取Android相关资源
 *
 * @author yh
 * @date 2020/01/10
 */
public class BLResUtils {

    private BLResUtils() {
    }

    /**
     * Returns a drawable object associated with a particular resource ID.
     */
    public static Drawable getDrawable(@DrawableRes int id) {
        return ContextCompat.getDrawable(BLAndroidUtils.app(), id);
    }

    /**
     * Returns a color associated with a particular resource ID
     */
    @ColorInt
    public static int getColor(@ColorRes int id) {
        return ContextCompat.getColor(BLAndroidUtils.app(), id);
    }

    public static ColorStateList getColorStateList(@ColorRes int id){
        return ContextCompat.getColorStateList(BLAndroidUtils.app(),id);
    }


    public static float getDimension(int resId) {
        return BLAndroidUtils.app().getResources().getDimension(resId);
    }

    public static float getDimensionPixelSize(int resId) {
        return BLAndroidUtils.app().getResources().getDimensionPixelSize(resId);
    }


    public static String getString(@StringRes int resId) {
        return BLAndroidUtils.app().getString(resId);
    }

    public static String getString(@StringRes int resId, Object... formatArgs) {
        return BLAndroidUtils.app().getString(resId, formatArgs);
    }

    public static String[] getStringArray(@ArrayRes int id){
        return BLAndroidUtils.app().getResources().getStringArray(id);
    }
}
