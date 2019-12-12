package com.bailun.utils.json;

import java.util.List;

/**
 * create by chl on 2019/12/3
 * description : 功能调用入口
 */
public class BLJsonUtils{

    //默认使用Gson库进行解析
    private static IJsonParse mJsonParse = new GsonParse();

    /**
     * 设置日志是否开启
     * @param isEnable
     */
    public static void setLoggerEnable(boolean isEnable) {
        mJsonParse.setLoggerEnable(isEnable);
    }

    /**
     * 可以用于切换解析库
     * @param jsonParse
     */
    public static void setJsonParse(IJsonParse jsonParse) {
        mJsonParse = jsonParse;
    }

    public static String toJson(Object object) {
        return mJsonParse.toJson(object);
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        return mJsonParse.fromJson(json, clazz);
    }

    public static <T> List<T> fromJsonToList(String json, Class<T> clazz) {
        return mJsonParse.fromJsonToList(json, clazz);
    }

    public static String getValuefromJson(String json, String key) {
        return mJsonParse.getValuefromJson(json, key);
    }

    public static List<String> getValuesfromJson(String json, String key) {
        return mJsonParse.getValuesfromJson(json, key);
    }
}
