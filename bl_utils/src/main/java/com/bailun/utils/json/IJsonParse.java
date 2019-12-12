package com.bailun.utils.json;

import java.util.List;

/**
 * create by chl on 2019/12/6
 * description : 定义解析的功能
 */
public interface IJsonParse {

    /**
     * @param isEnable : 设置日志是否开启
     */
    void setLoggerEnable(boolean isEnable);

    /**
     * @param object
     * @return ：将对象转换为json数据
     */
    String toJson(Object object);

    /**
     * @param json
     * @param clazz
     * @param <T>
     * @return : 将json数据转换为对象
     */
    <T> T fromJson(String json, Class<T> clazz);

    /**
     * @param json
     * @param clazz
     * @param <T>
     * @return : 将json对象转换为集合对象
     */
    <T> List<T> fromJsonToList(String json, Class<T> clazz);

    /**
     * @param json
     * @param key
     * @return : 获取json中指定key对应的值,针对{}类型并且单层的json
     */
    String getValuefromJson(String json, String key);

    /**
     * @param json
     * @param key
     * @return : 获取json中指定key对应的多个值，针对[]类型并且单层的json
     */
    List<String> getValuesfromJson(String json, String key);
}
