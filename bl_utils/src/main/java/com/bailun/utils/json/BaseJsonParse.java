package com.bailun.utils.json;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * create by chl on 2019/12/6
 * description : 用于实现原生的json解析
 */
public abstract class BaseJsonParse implements IJsonParse {

    public static final String TAG = BaseJsonParse.class.getName();

    public boolean isLogEnable = false;

    @Override
    public void setLoggerEnable(boolean isEnable) {
        isLogEnable = isEnable;
    }

    @Override
    public String getValuefromJson(String json, String key) {
        if (TextUtils.isEmpty(json)) {
            return "";
        }
        if (json.contains(key)) {
            try {
                JSONObject jsonObject = new JSONObject(json);
                return jsonObject.optString(key);
            } catch (JSONException e) {
                e.printStackTrace();
                if (isLogEnable) {
                    Log.e(TAG, "getValuefromJson: " + e.getMessage());
                }
            }
        }
        return "";
    }

    @Override
    public List<String> getValuesfromJson(String json, String key) {
        List<String> results = new ArrayList<>();
        if (TextUtils.isEmpty(json)) {
            return results;
        }
        if (json.contains(key)) {
            try {
                JSONArray jsonArray = new JSONArray(json);
                if (jsonArray.length() == 0) {
                    return results;
                }
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = (JSONObject) (jsonArray.get(i));
                    String value = jsonObject.optString(key);
                    results.add(value);
                }
            } catch (JSONException e) {
                e.printStackTrace();
                if (isLogEnable) {
                    Log.e(TAG, "getValuesfromJson: " + e.getMessage());
                }
            }
        }
        return results;
    }
}
