package com.bailun.utils.json;

import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.List;

/**
 * create by chl on 2019/12/6
 * description : 使用Gson库解析
 */
class GsonParse extends BaseJsonParse{

    private Gson mGson;

    @Override
    public String toJson(Object object) {
        checkGson();
        return mGson.toJson(object);
    }

    @Override
    public <T> T fromJson(String json, Class<T> clazz) {
        checkGson();
        return mGson.fromJson(json, clazz);
    }

    @Override
    public <T> List<T> fromJsonToList(String json, Class<T> clazz) {
        checkGson();
        /*//生成的类型为：LinkedTreeMap,造成类型转换异常
        List<T> results = mGson.fromJson(json, new TypeToken<List<T>>() {
        }.getType());
        -------------------------------------------------------------------
        List<T> results = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(json);
            if (jsonArray.length() == 0) {
                return results;
            }
            for (int i = 0; i < jsonArray.length(); i++) {
                results.add(mGson.fromJson(jsonArray.get(i).toString(), clazz));
            }
        } catch (JSONException e) {
            e.printStackTrace();
            if (isLogEnable) {
                Log.e(TAG, "fromJsonToList: " + e.getMessage());
            }
        }
        return results;*/
        return mGson.fromJson(json, new ImpParameterizedType(List.class, new Type[]{clazz}, null));
    }

    private void checkGson() {
        if (mGson == null) {
            mGson = new Gson();
        }
    }
}
