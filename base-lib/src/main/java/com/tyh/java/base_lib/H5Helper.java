package com.tyh.java.base_lib;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.text.TextUtils;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.tyh.java.base_lib.class_collector.ClassCollector;

import java.io.Serializable;
import java.util.HashMap;

/**
 * 创建人: tyh
 * 创建时间: 2019/3/14
 * 描述:
 */
public class H5Helper {

    private H5Helper() {
    }

    public static void openActivity(String src, Activity act) {

        if (TextUtils.isEmpty(src) || act == null) {
            //h5传递的参数为空,或者传递的Activity为空
            return;
        }

        H5Entity entity = null;
        try {
            entity = JSON.parseObject(src, H5Entity.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (entity == null) {
            //h5传的参数转换成H5Entity出错;
            return;
        }

        H5Helper helper = new H5Helper();
        helper.startActivity(entity, act);
    }

    /**
     * 打开activity
     */
    private void startActivity(@NonNull H5Entity entity, @NonNull Activity srcAct) {
        String actName = null;
        try {
            //找到类名
            if (TextUtils.isEmpty(entity.getTag())) {
                actName = entity.getName();
            } else {
                actName = ClassCollector.getInstance().getClassName(null, entity.getTag());
            }

            if (TextUtils.isEmpty(actName)) {
                Log.e("===", "can not openActivity because of actName is null or empty");
                return;
            }

            Class target = srcAct.getClassLoader().loadClass(actName);
            Intent in = new Intent(srcAct, target);

            //添加传递参数
            HashMap<String, String> params = entity.getParams();
            if (params != null) {
                for (String key : params.keySet()) {
                    in.putExtra(key, params.get(key));
                }
            }

            //打开activity
            if (entity.isForResult()) {
                ActivityCompat.startActivityForResult(
                        srcAct,
                        in,
                        0x111,
                        null);
            } else {
                ActivityCompat.startActivity(
                        srcAct,
                        in,
                        null);
            }
        } catch (ClassNotFoundException e) {
            Log.e("===", "can not openActivity because of not find the class : " + actName);
            e.printStackTrace();
        } catch (ActivityNotFoundException e) {
            Log.e("===", "activity not find in AndroidManifest.xml : " + actName);
            e.printStackTrace();
        }
    }

    private static class H5Entity implements Serializable {
        private String group;
        private String tag;
        private String name;
        private boolean forResult;
        private HashMap<String, String> params;

        public String getGroup() {
            return group;
        }

        public void setGroup(String group) {
            this.group = group;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public HashMap<String, String> getParams() {
            return params;
        }

        public boolean isForResult() {
            return forResult;
        }

        public void setForResult(boolean forResult) {
            this.forResult = forResult;
        }

        public void setParams(HashMap<String, String> params) {
            this.params = params;
        }
    }
}
