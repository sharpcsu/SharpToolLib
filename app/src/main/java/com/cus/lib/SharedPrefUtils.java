package com.cus.lib;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * SharedPreferences 的工具类
 * Created by 杨威 on 2015/12/6 - 14:53
 */
public class SharedPrefUtils {
    private static SharedPreferences mSp;
    private static SharedPreferences getSharedPreferences(Context context) {
        if (mSp == null) {
            mSp = context.getSharedPreferences("confid", Context.MODE_PRIVATE);
        }
        return mSp;
    }
    
    public static void putString(Context context, String key, String defValue) {
        getSharedPreferences(context).edit().putString(key, defValue).commit();
    }

    public static String getString(Context context, String key, String value) {
        return getSharedPreferences(context).getString(key, value);
    }

    public static void putBoolean(Context context, String key, boolean defValue) {
        LogUtil.e("杨威   -   context: " + context + "key: " + key + " defValue:" + defValue);
        getSharedPreferences(context).edit().putBoolean(key, defValue).commit();
    }

    public static boolean getBoolean(Context context, String key, boolean value) {
        LogUtil.e("杨威   -   context: " + context + "key: " + key);
        return getSharedPreferences(context).getBoolean(key, value);
    }
}

//====================================================================
//
//=====================================================================

/**
 * Created by 杨威 on 2015/12/29 - 10:20
 */
class PrefaceUtil {

    private static SharedPreferences sp;

    /**
     * 保存boolean值信息
     * @param context
     * @param key
     * @param value
     */
    public static void putBoolean(Context context, String key, boolean value) {
        if (sp == null) {
            sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        }

        sp.edit().putBoolean(key, value).commit();
    }


    /**
     * 获取boolean数据
     * @param context
     * @param key
     * @param defValue 默认值为true
     * @return
     */
    public static boolean getBoolean(Context context, String key, boolean defValue) {
        if (sp == null) {
            sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        }

        return sp.getBoolean(key, defValue);
    }

    /**
     * 保存字符串类型数据
     * @param context
     * @param key
     * @param value
     */
    public static void putString(Context context, String key, String value) {
        if (sp == null) {
            sp = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        }

        sp.edit().putString(key, value).commit();
    }

    public static String getString(Context context, String key, String defValue) {
        if (sp == null) {
            sp = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        }

        return sp.getString(key, defValue);
    }
}
