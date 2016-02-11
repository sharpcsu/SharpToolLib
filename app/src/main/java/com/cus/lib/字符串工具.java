package com.cus.lib;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * 字符串工具类, 字符串转换工具
 * Created by 杨威 on 2016/2/11 - 9:35
 */
public class 字符串工具 {
    /**
     * 字节数据转字符串, 内存写入流
     * 时间: 2016/2/11 9:36
     */
    public static String streamToString(InputStream inputStream) {
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(buf)) != -1) {
                out.write(buf, 0, len);
                out.flush();
            }

            String string = out.toString();
            out.close();
            return string;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
