package com.lolita.operate;

import java.io.UnsupportedEncodingException;

import org.json.JSONException;
import org.json.JSONObject;

import com.lolita.model.ThirdUser;

public class WechatApi {

	// 微信AppID与AppSecret
	private String appid = "wxb9113d62e03b38ec";
	private String appsecret = "d4624c36b6795d1d99dcf0547af5443d";

	// 通过code获取用户access_token与openid
	public JSONObject getAccessToken(String code) throws UnsupportedEncodingException, JSONException {

		// 请求微信服务器
		String str = HttpRequest.sendGet(
				"https://api.weixin.qq.com/sns/oauth2/access_token", "appid="
						+ appid + "&secret=" + appsecret + "&code=" + code
						+ "&grant_type=authorization_code");
		str = new String(str.getBytes(), "UTF-8");
		System.out.println("Request result: " + str);
		
		JSONObject result = new JSONObject(str);
		return result;
		
	}

	// 通过微信openid获取用户资料
	public ThirdUser getUser(String access_token, String openid)
			throws JSONException, UnsupportedEncodingException {

		// 请求用户资料
		String str = HttpRequest.sendGet(
				"https://api.weixin.qq.com/sns/userinfo", "access_token="
						+ access_token + "&openid==" + openid);
		str = new String(str.getBytes(), "UTF-8");
		System.out.println("Request result: " + str);

		JSONObject result = new JSONObject(str);

		ThirdUser thirdUser = new ThirdUser();
		thirdUser.setOpenid(openid);
		thirdUser.setName(result.getString("nickname"));
		thirdUser.setAvatar(result.getString("headimgurl"));
		thirdUser.setGender(result.getString("sex"));

		return thirdUser;
	}
}