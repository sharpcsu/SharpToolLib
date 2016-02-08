package com.cus.lib;

import android.content.Context;
import android.widget.Toast;

/**
 * Toast的工具类
 * 作者:杨威
 * 时间:2015年12月7日12:51:56
 */
public class ToastUtil {
    public static void showToast(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }

    public static void showToastLong(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
    }
}