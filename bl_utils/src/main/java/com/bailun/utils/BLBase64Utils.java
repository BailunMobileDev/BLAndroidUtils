package com.bailun.utils;

import android.util.Base64;

/**
 * create by ouyangjianfeng on 2019/12/16
 * description:Base64加密
 */
public class BLBase64Utils {
    public static String getBase64(String str) {
        return Base64.encodeToString(str.getBytes(), Base64.NO_WRAP);
    }
}
