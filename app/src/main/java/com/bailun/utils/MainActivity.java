package com.bailun.utils;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.bailun.utils.fastcheck.BLFastClickLimit;
import com.bailun.utils.json.BLJsonUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BLFastClickLimit
    private Button mTest1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        testGson();
    }

    private void testGson() {
        TestBean testBean = new TestBean(20, "测试");
        String s1 = BLJsonUtils.toJson(testBean);
        Log.e("BLJsonUtils", "toJson s1 = " + s1);
        TestBean testBean1 = BLJsonUtils.fromJson(s1, TestBean.class);
        Log.e("BLJsonUtils", "fromJson " + testBean1.toString());
        String name = BLJsonUtils.getValuefromJson(s1, "name");
        Log.e("BLJsonUtils", "getValuefromJson name = " + name);
        List<TestBean> datas = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            datas.add(new TestBean(20 + i, "测试:" + i));
        }
        String s2 = BLJsonUtils.toJson(datas);
        Log.e("BLJsonUtils", "toJson s2 = " + s2);
        List<TestBean> testBeans = BLJsonUtils.fromJsonToList(s2, TestBean.class);
        Log.e("BLJsonUtils", "fromJsonToList " + testBeans.size());
        List<String> names = BLJsonUtils.getValuesfromJson(s2, "name");
        Log.e("BLJsonUtils", "getValuesfromJson names = " + Arrays.toString(names.toArray()));
    }

    private void initView() {
        mTest1 = findViewById(R.id.btn_test1);
        mTest1.setOnClickListener(this);
        findViewById(R.id.btn_test2).setOnClickListener(new View.OnClickListener() {

            @BLFastClickLimit(spaceTime = 1000)
            @Override
            public void onClick(View v) {
                Log.e("AopFastClickLimit", "onClick: 测试2 id = " + v.getId() + " ;; " + System.currentTimeMillis());
            }
        });
    }

    @Override
    public void onClick(View v) {
        Log.e("AopFastClickLimit", "onClick: 测试1 id = " + v.getId() + " ;; " + System.currentTimeMillis());
    }
}
