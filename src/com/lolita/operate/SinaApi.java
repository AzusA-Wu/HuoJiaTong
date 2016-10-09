package com.lolita.operate;

import java.io.UnsupportedEncodingException;

import org.json.JSONException;
import org.json.JSONObject;

import com.lolita.model.ThirdUser;

public class SinaApi {
	
	//通过access_token获取新浪微博uid
	public String getUid(String access_token) throws JSONException{
		
		//请求用户uid
		String str = HttpRequest.sendGet(
				"https://api.weibo.com/2/account/get_uid.json",
				"access_token=" + access_token);
		System.out.println("Request result: " + str);
		
		JSONObject result = new JSONObject(str);
		
		return result.getString("uid");
	}
	
	//通过新浪微博uid获取用户资料
	public ThirdUser getUser(String access_token, String uid) throws JSONException, UnsupportedEncodingException{
		
		//请求用户资料
		String str = HttpRequest.sendGet(
				"https://api.weibo.com/2/users/show.json",
				"access_token=" + access_token + "&uid=" + uid);
		str = new String(str.getBytes(),"UTF-8");
		System.out.println("Request result: " + str);
		
		JSONObject result = new JSONObject(str);
		
		ThirdUser thirdUser = new ThirdUser();
		thirdUser.setSinaId(uid);
		thirdUser.setName(result.getString("name"));
		thirdUser.setAvatar(result.getString("avatar_large"));
		thirdUser.setGender(result.getString("gender"));
		thirdUser.setDescription(result.getString("description"));
		
		return thirdUser;
	}
}