package com.tyh.java.first_lib;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.tyh.java.base_lib.class_collector.ClassCollectorTag;
import com.tyh.java.base_lib.class_collector.ClassCollectorAnnotation;

/**
 * 创建人: tyh
 * 创建时间: 2019/3/13
 * 描述:
 */
@ClassCollectorAnnotation(ClassCollectorTag.KIND_C_FIRST)
public class CFirst extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_first);
    }
}
