package com.tyh.java.base_lib.class_collector;

import android.support.annotation.StringDef;

/**
 * 创建人: tyh
 * 创建时间: 2019/3/12
 * 描述:
 */
public class ClassCollectorTag {
    public static final String KIND_CA = "KIND_CA";
    public static final String KIND_CB = "KIND_CB";
    public static final String KIND_C_FIRST = "KIND_C_FIRST";
    public static final String kIND_C_SECOND = "kIND_C_SECOND";

    @StringDef({KIND_CA, KIND_CB, KIND_C_FIRST, kIND_C_SECOND})
    public @interface TAG {

    }


    public static final String GROUP_DEF = "GROUP_DEF";

    @StringDef({GROUP_DEF})
    public @interface GROUP {

    }
}
