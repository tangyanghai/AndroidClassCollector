package com.tyh.java.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.tyh.java.base_lib.class_collector.ClassCollectorTag;
import com.tyh.java.base_lib.class_collector.ClassCollectorAnnotation;

/**
 * 创建人: tyh
 * 创建时间: 2019/3/12
 * 描述:
 */
@ClassCollectorAnnotation(ClassCollectorTag.KIND_CB)
public class CB extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = findViewById(R.id.tv);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Intent in = getIntent();
        String abc = in.getStringExtra("abc");
        String def = in.getStringExtra("def");
        tv.setText(String.format("abc = %s, def = %s",abc,def));
    }
}
