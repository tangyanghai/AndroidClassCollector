package com.tyh.java.myapplication;

import android.app.Application;

import com.tyh.java.base_lib.class_collector.ClassCollector;

/**
 * 创建人: tyh
 * 创建时间: 2019/3/12
 * 描述:
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ClassCollector.getInstance().init(this,"com.tyh");
    }
}
