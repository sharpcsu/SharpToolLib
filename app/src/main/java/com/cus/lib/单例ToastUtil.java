package com.cus.lib;

import android.content.Context;
import android.widget.Toast;

/**
 * 单例toast
 * Created by 杨威 on 2016/1/22 - 15:05
 */
public class 单例ToastUtil {
    private static Toast toast;

    /**
     * 单例toast
     * 强大的toast, 能够连续弹得toast
     * @param msg toast的文本
     */
    public static void SingleToastUtil(Context context, String msg) {
        if (toast == null) {
            toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        } else {
            toast.setText(msg); //如果不为null, 则直接改变当天toast的文本
        }
        toast.show();
    }
}