package com.tyh.java.base_lib.class_collector;

import android.app.Activity;
import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.text.TextUtils;
import android.util.Log;


import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;

import dalvik.system.DexFile;

/**
 * <P>创建人: tyh
 * <p>创建时间: 2019/3/12
 * <p>描述:h5打开原生页面入口
 * <p></p>
 * <p>******初始化*******</p>
 * 在{@link Application#onCreate()}调用{@link #init(Context, String...)}进行初始化
 * <p></p>
 * <p>******注册可以被h5打开的页面*******</p>
 * <p>1.在{@link ClassCollectorTag}中写一个值是唯一的静态变量,并添加到{@link ClassCollectorTag.TAG}中
 * <p>2.在需要被打开的Activity类上添加注解{@link ClassCollectorAnnotation}
 */
public class ClassCollector {
    private HashMap<String, HashMap<String, String>> groupMap;
    private static final ClassCollector instance = new ClassCollector();
    private boolean inited;
    private Context mAppContext;
    public static ClassCollector getInstance() {
        return instance;
    }

    private ClassCollector() {
        groupMap = new HashMap<>();
    }

    /**
     * 初始化
     * 找到含有{@link ClassCollectorAnnotation}的类,并保存
     *
     * @param context
     */
    public void init(Context context, String... packTag) {
        if (this.inited) {
            return;
        }
        this.mAppContext = context.getApplicationContext();
        DexFile df = null;
        try {
            df = new DexFile(this.mAppContext.getPackageCodePath());
            ClassLoader classLoader = context.getClassLoader();
            String s = null;
            for (Enumeration<String> it = df.entries(); it.hasMoreElements(); ) {
                s = it.nextElement();
                if (fitPackTag(s, packTag) && !s.contains("$")) {
                    try {
                        Class<?> cls = classLoader.loadClass(s);
                        ClassCollectorAnnotation ann = cls.getAnnotation(ClassCollectorAnnotation.class);
                        if (ann != null) {
                            put(ann.group(), ann.value(), s);
                        }
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
            this.inited = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (df != null) {
                try {
                    df.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * @param name          全类名
     * @param partPackNames 需要类的包名
     * @return true=全类名包含包名
     */
    private boolean fitPackTag(String name, String... partPackNames) {
        if (partPackNames == null || partPackNames.length == 0) {
            return true;
        }

        for (String s : partPackNames) {
            if (name.contains(s)) {
                return true;
            }
        }

        return false;
    }

    /**
     * @param group 分组
     * @param tag   标记
     * @return  全类名
     */
    public String getClassName(String group, String tag) {
        if (this.groupMap == null || this.groupMap.size() == 0 || tag == null) {
            return null;
        }
        if (group == null) {
            group = ClassCollectorTag.GROUP_DEF;
        }
        HashMap<String, String> names = this.groupMap.get(group);
        if (names == null || names.size() == 0) {
            return null;
        }
        return names.get(tag);
    }


    /**
     * @param tag   标记
     * @return  全类名
     */
    public String getClassName(String tag) {
        return getClassName(null,tag);
    }

    /**
     * 将全类名加入分组
     * @param group     分组
     * @param tag       标记
     * @param clsName   全类名
     */
    private void put(String group, String tag, String clsName) {
        if (tag == null || clsName == null) {
            return;
        }
        if (group == null) {
            group = ClassCollectorTag.GROUP_DEF;
        }
        HashMap<String, String> nameMap = this.groupMap.get(group);
        if (nameMap == null) {
            nameMap = new HashMap<>();
            this.groupMap.put(group, nameMap);
        }
        nameMap.put(tag, clsName);
    }


}
