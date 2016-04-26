package com.cus.lib.network;

import android.os.Handler;
import android.os.Message;

import com.cus.lib.LogUtil;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 在子线程中使用HttpUrlConnection连接网络 - netConnection()
 *
 * Created by 杨威 on 2016/2/11 - 15:43
 */
public class 网络连接 {

    String urlStr = "";

    //△△△△△△1. 在主线程中创建一个handler对象
    //△△△△△△2. 实现Handler对象的handleMessage方法
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            //△△△△△△6. 主线程在handlerMessage方法中接收子线程发来的Message对象, 并获取绑定结果数据, 进行跟新UI的处理
            String result = (String) msg.obj;
        }
    };

    /**
     * 在子线程中使用HttpUrlConnection连接网络
     * 时间: 2016/2/11 15:51
     */
    public void netConnection() {
        //请求URL地址, 获取源码内容
        //创建子线程去请求网络
        new Thread(){
            @Override
            public void run() {
                LogUtil.e("创建子线程");
                //URLConnection的使用
                try {
                    //1. 创建URL对象
                    URL url = new URL(urlStr);
                    //2. 通过URL获取一个HttpUrlConnection对象
                    HttpURLConnection openConnection = (HttpURLConnection) url.openConnection();
                    //3. 为HttpUrlConnection对象设置请求方式, 联网的超时时间
                    openConnection.setRequestMethod("GET"); //请求方式必须大写
                    openConnection.setReadTimeout(10 * 1000); //设置超时时间
                    LogUtil.e("判断响应参数");
                    //4. 获取服务器的响应码, 判断是否是200
                    if (openConnection.getResponseCode() == 200) {
                        //5. 是200则获取流信息
                        InputStream inputStream = openConnection.getInputStream();
                        //6. ....执行相关操作

                        //7. 关闭资源
                        inputStream.close();


                        //△△△△△△3. 如果当前消息池中有则返回一个，没有则创建
                        Message message = Message.obtain();
                        //△△△△△△4. 将子线程中获取的数据绑定给message对象
                        message.obj = "result";
                        //△△△△△△5. 使用主线程中的handler对象将子线程中的message对象发送到主线程
                        handler.sendMessage(message);
                    } else {
                        System.out.println("返回值错误");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }//netConnection


}