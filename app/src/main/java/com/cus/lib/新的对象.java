package com.cus.lib;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by 杨威 on 2016/2/15 - 16:02
 */
public class 新的对象 extends Activity {
    /**
     * 保存少量信息
     * sharedPreference使用示例
     * @param inputNumber 保存内容
     * 时间: 2016/2/15 16:05
     */
    public void sharedPreferenceDemo(String inputNumber) {
        //将ip号码保存到sharedPreference
        SharedPreferences sharedPreferences = getSharedPreferences("inputNumber", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("inputNumber", inputNumber);
        edit.apply();
    }

    /**
     * ContentValue使用示例, 代替Map
     * 时间: 2016/2/15 16:05
     */
    public void contentValueDemo() {

    }
}
