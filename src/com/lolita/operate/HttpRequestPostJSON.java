package com.lolita.operate;

import java.io.IOException;  
import java.io.InputStream;  
import java.io.OutputStreamWriter;  
import java.net.HttpURLConnection;  
import java.net.URL;

public class HttpRequestPostJSON {
  
    /** 
     * 发送HttpPost请求 
     *  
     * @param strURL 
     *            服务地址 
     * @param params 
     * 
     * @return 成功:返回json字符串
     */  
    public static String post(String strURL, String params) {  
        try {  
            URL url = new URL(strURL);// 创建连接  
            HttpURLConnection connection = (HttpURLConnection) url  
                    .openConnection();  
            connection.setDoOutput(true);  
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);  
            connection.setRequestMethod("POST"); // 设置请求方式  
            connection.setRequestProperty("Accept", "application/json"); // 设置接收数据的格式  
            connection.setRequestProperty("Content-Type", "application/json"); // 设置发送数据的格式  
            connection.connect();  
            OutputStreamWriter out = new OutputStreamWriter(  
                    connection.getOutputStream(), "UTF-8"); // utf-8编码  
            out.append(params);  
            out.flush();  
            out.close();  
            // 读取响应  
            int length = (int) connection.getContentLength();// 获取长度  
            InputStream is = connection.getInputStream();  
            if (length != -1) {  
                byte[] data = new byte[length];  
                byte[] temp = new byte[512];  
                int readLen = 0;  
                int destPos = 0;  
                while ((readLen = is.read(temp)) > 0) {  
                    System.arraycopy(temp, 0, data, destPos, readLen);  
                    destPos += readLen;  
                }  
                String result = new String(data, "UTF-8"); // utf-8编码  
                System.out.println(result);  
                return result;  
            }  
        } catch (IOException e) {
            e.printStackTrace();  
        }  
        return "error"; // 自定义错误信息  
    }
}
