package com.lolita.service;

import org.json.JSONException;

public interface IWechatService {

	//获取openid
	public String getOpenid(String code) throws JSONException;
	
	//更新关注状态
	public String updateFollowStatus(String openid) throws JSONException;
	
	//获取JSApi签名
	public String getSignature(String url);
}