package com.tyh.java.second_lib;

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
@ClassCollectorAnnotation(ClassCollectorTag.kIND_C_SECOND)
public class CSecond extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_second);
    }
}
