package com.cus.lib;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户登入的相关操作
 * Created by 杨威 on 2016/2/13 - 14:30
 */
public class 用户登入 {
    //保存用户名和密码
    public static boolean saveUserInfoForAndroid(Context context, String username, String password) {
        try {
            //使用sharedPreference保存用户信息
            //1. 使用context对象获取一个sharedPreference对象
            SharedPreferences sharedPreferences = context.getSharedPreferences("userInfo.txt", Context.MODE_PRIVATE);
            //2. 使用sharedPreference对象获取一个Editor对象
            SharedPreferences.Editor edit = sharedPreferences.edit();
            //3. 往Editor对象中put键值对
            edit.putString("username", username);
            edit.putString("password", password);
            //4. 提交Editor对象
            edit.commit();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    //获取保存的用户名密码
    public static Map<String, String> getUserInfoForAndroid(Context context) {
        Map<String, String> map = new HashMap<>();

        try {
            //使用sharedPreference获取数据
            //1.使用context对象获取一个sharedPreference对象,  name:preference文件的名称    mode： 文件的操作模式
            SharedPreferences sharedPreferences = context.getSharedPreferences("userInfo.txt", Context.MODE_PRIVATE);

            //2. 使用sharedPreference对象通过键值对的key获取存储的值,  key: 键值对的key, delValue: 默认值
            String username = sharedPreferences.getString("username", "admin");
            String password = sharedPreferences.getString("password", "admin");

            map.put("username", username);
            map.put("password", password);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
