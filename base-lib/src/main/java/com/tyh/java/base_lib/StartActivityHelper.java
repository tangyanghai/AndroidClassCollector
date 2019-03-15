package com.tyh.java.base_lib;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.ActivityCompat;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 创建人: tyh
 * 创建时间: 2019/3/14
 * 描述:
 */
public class StartActivityHelper {

    private StartActivityHelper(Context context) {
        this.context = context;
        this.in = new Intent();
    }

    public static StartActivityHelper get(Context context) {
        return new StartActivityHelper(context);
    }


    Context context;
    Intent in;
    Integer codeRequest;
    Bundle options;
    ActHelperExpander expander;


    public StartActivityHelper put(String key, boolean o) {
        in.putExtra(key, o);
        return this;
    }

    public StartActivityHelper put(String key, byte o) {
        in.putExtra(key, o);
        return this;
    }

    public StartActivityHelper put(String key, char o) {
        in.putExtra(key, o);
        return this;
    }

    public StartActivityHelper put(String key, short o) {
        in.putExtra(key, o);
        return this;
    }

    public StartActivityHelper put(String key, int o) {
        in.putExtra(key, o);
        return this;
    }

    public StartActivityHelper put(String key, long o) {
        in.putExtra(key, o);
        return this;
    }

    public StartActivityHelper put(String key, float o) {
        in.putExtra(key, o);
        return this;
    }

    public StartActivityHelper put(String key, double o) {
        in.putExtra(key, o);
        return this;
    }

    public StartActivityHelper put(String key, String o) {
        in.putExtra(key, o);
        return this;
    }

    public StartActivityHelper put(String key, CharSequence o) {
        in.putExtra(key, o);
        return this;
    }

    public StartActivityHelper put(String key, Parcelable o) {
        in.putExtra(key, o);
        return this;
    }

    public StartActivityHelper put(String key, Parcelable[] o) {
        in.putExtra(key, o);
        return this;
    }

    public StartActivityHelper setOptions(Bundle options) {
        this.options = options;
        return this;
    }

    public StartActivityHelper setExpander(ActHelperExpander expander) {
        this.expander = expander;
        return this;
    }

    public StartActivityHelper putParcelableArrayListExtra(String key, ArrayList<? extends Parcelable> o) {
        in.putParcelableArrayListExtra(key, o);
        return this;
    }

    public StartActivityHelper putIntegerArrayListExtra(String key, ArrayList<Integer> o) {
        in.putIntegerArrayListExtra(key, o);
        return this;
    }

    public StartActivityHelper putStringArrayListExtra(String key, ArrayList<String> o) {
        in.putStringArrayListExtra(key, o);
        return this;
    }

    public StartActivityHelper putCharSequenceArrayListExtra(String key, ArrayList<CharSequence> o) {
        in.putCharSequenceArrayListExtra(key, o);
        return this;
    }


    public StartActivityHelper put(String key, Serializable o) {
        in.putExtra(key, o);
        return this;
    }

    public StartActivityHelper put(String key, boolean[] o) {
        in.putExtra(key, o);
        return this;
    }

    public StartActivityHelper put(String key, byte[] o) {
        in.putExtra(key, o);
        return this;
    }

    public StartActivityHelper put(String key, char[] o) {
        in.putExtra(key, o);
        return this;
    }

    public StartActivityHelper put(String key, short[] o) {
        in.putExtra(key, o);
        return this;
    }

    public StartActivityHelper put(String key, int[] o) {
        in.putExtra(key, o);
        return this;
    }

    public StartActivityHelper put(String key, long[] o) {
        in.putExtra(key, o);
        return this;
    }

    public StartActivityHelper put(String key, float[] o) {
        in.putExtra(key, o);
        return this;
    }

    public StartActivityHelper put(String key, double[] o) {
        in.putExtra(key, o);
        return this;
    }

    public StartActivityHelper put(String key, String[] o) {
        in.putExtra(key, o);
        return this;
    }

    public StartActivityHelper put(String key, CharSequence[] o) {
        in.putExtra(key, o);
        return this;
    }

    public StartActivityHelper put(String key, Bundle o) {
        in.putExtra(key, o);
        return this;
    }

    public StartActivityHelper put(Bundle o) {
        in.putExtras(o);
        return this;
    }

    public Intent getIntent() {
        return in;
    }

    public StartActivityHelper put(Intent o) {
        in.putExtras(o);
        return this;
    }

    public StartActivityHelper setRequestCode(int requestCode) {
        this.codeRequest = requestCode;
        return this;
    }

    public void startActivity(Class cls) {
        if (this.expander != null) {
            expander.expandIntent(in);
        }
        in.setClass(this.context, cls);
        try {
            if (this.codeRequest != null) {
                ActivityCompat.startActivityForResult((Activity) context, in, codeRequest, options);
            } else {
                ActivityCompat.startActivity(context, in, options);
            }
            if (expander != null) {
                expander.expandAfterStartActivity();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 拓展类
     * {@link #expandIntent(Intent)}将Intent交给外界处理
     * {@link #expandAfterStartActivity()}在startActivity或者startActivityForResult之后会执行
     */
    public static class ActHelperExpander {
        public void expandIntent(Intent in) {
        }

        public void expandAfterStartActivity() {
        }
    }

}
