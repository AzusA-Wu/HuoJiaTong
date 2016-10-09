package com.lolita.operate;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.apache.http.NameValuePair;

/**
 * HTTP Client, to send data of XML type to Server. This is a demonstration of
 * how to use HTTP Client API
 * 
 * @author Lv Pin
 * 
 */

@SuppressWarnings("deprecation")
public class SMS_Request {

	private static String account = "gzxingyao";
	private static String pswd = "GZxingyao6";
	private static String url = "http://120.24.167.205/msg/HttpSendSM";//单发短信

	@SuppressWarnings("resource")
	public String sendSMS(String mobile, String msg) throws Exception {

		// POST的URL
		HttpPost httppost = new HttpPost(url);
		// 建立HttpPost对象
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		// 建立一个NameValuePair数组，用于存储欲传送的参数
		// account=gzxingyao&pswd=GZxingyao6&mobile=13416154093&msg=您好,您的验证码为:0000,请注意保管【e改车】&needstatus=true&product=
		params.add(new BasicNameValuePair("account", account));
		params.add(new BasicNameValuePair("pswd", pswd));
		params.add(new BasicNameValuePair("mobile", mobile));
		params.add(new BasicNameValuePair("msg", msg));
		params.add(new BasicNameValuePair("needstatus", "true"));
		params.add(new BasicNameValuePair("product", ""));
		// 添加参数
		httppost.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
		// 设置编码
		HttpResponse response = new DefaultHttpClient().execute(httppost);
		// 发送Post,并返回一个HttpResponse对象
		// Header header = response.getFirstHeader("Content-Length");
		// String Length=header.getValue();
		// 上面两行可以得到指定的Header
		String result = EntityUtils.toString(response.getEntity());
		// 得到返回的字符串
		// System.out.println(result);
		// 打印输出
		// 如果是下载文件,可以用response.getEntity().getContent()返回InputStream

		return result;
	}
}