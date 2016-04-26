package com.cus.lib;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.telephony.SmsManager;

import java.util.ArrayList;

/**
 * Created by 杨威 on 2016/2/14 - 22:06
 */
public class 系统应用 extends Activity{

    /**
     * 打开短信应用
     * @param phoneNumber 电话号码
     * @param msg 短信内容
     * 时间: 2016/2/14 22:07
     */
    public void startMms(String phoneNumber, String msg) {
        //发送短信
        Intent intent2 = new Intent();
        intent2.setAction("android.intent.action.VIEW");
        intent2.addCategory("android.intent.category.BROWSABLE");
        //设置参数

        intent2.setData(Uri.parse("sms:" + phoneNumber));
        //设置短信内容
        intent2.putExtra("sms_body", msg);
        startActivity(intent2);
    }

    /**
     * 发送短信
     * @param phoneNumber 电话号码
     * @param msg 短信内容
     * 时间: 2016/2/14 22:47
     */
    public void sendMms(String phoneNumber, String msg) {
        //发送短信 添加发送短信的权限send_Sms
        //1. 创建一个SmsManager对象
        SmsManager smsManager = SmsManager.getDefault();
        //2. 切割短信内容
        ArrayList<String> list = smsManager.divideMessage(msg);
        for (String s : list) {
            //4. 调用sendMessageText方法发送短信, destinationAddress: 发送地址, scAddress: 服务中心号码, text: 短信内容
            smsManager.sendTextMessage(phoneNumber, null, s, null, null);
        }
    }

    /**
     * 启动浏览器
     * 时间: 2016/2/14 22:07
     */
    public static void startBrower() {

    }
}
