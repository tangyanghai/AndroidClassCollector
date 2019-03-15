package com.tyh.java.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.tyh.java.base_lib.H5Helper;
import com.tyh.java.base_lib.class_collector.ClassCollector;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tv;
    TextView tv1;
    TextView tv2;
    TextView tv3;

    String paramString0 = "{\"tag\":\"KIND_CA\",\"params\":{\"abc\":\"123\",\"def\":\"456\"}}";
    String paramString1 = "{\"tag\":\"KIND_CB\",\"params\":{\"abc\":\"123\",\"def\":\"456\"}}";
    String paramString2 = "{\"tag\":\"KIND_C_FIRST\",\"params\":{\"abc\":\"123\",\"def\":\"456\"}}";
    String paramString3 = "{\"tag\":\"kIND_C_SECOND\",\"params\":{\"abc\":\"123\",\"def\":\"456\"}}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);
        tv1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String p = null;
        switch (v.getId()) {
            case R.id.tv:
                p = paramString0;
                break;
                 case R.id.tv1:
                p = paramString1;
                break;
                 case R.id.tv2:
                p = paramString2;
                break;
                 case R.id.tv3:
                p = paramString3;
                break;
        }

        H5Helper.openActivity(p, MainActivity.this);
    }
}
