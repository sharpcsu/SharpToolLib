package com.cus.lib;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 把流的内容解析成字符串
 * Created by 杨威 on 2015/12/6 - 12:57
 */
public class 流解析成字符串 {
    public static String streamToString(InputStream inputStream) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = -1;
            while ((len = inputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, len);
            }

            String string = byteArrayOutputStream.toString();
            byteArrayOutputStream.close();
            inputStream.close();

            return string;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}