package com.lolita.dao;

import com.lolita.model.JSApi;
import com.lolita.model.WechatData;

public interface WechatDataMapper {

	//openid写入数据库
	public void addOpenid(WechatData wechatData);
	
	//通过openid获取资料
	public WechatData getWechatDataByOpenid(String openid);
	
	//更新关注状态
	public void updateFollowStatus(String openid);
	
	//更新用户微信认证资料
	public void updateWechatData(WechatData wechatData);
	
	//更新JSApi所需认证资料
	public void updateJSApiData(JSApi jsApi);
	
	//获取JSApi认证资料
	public JSApi getJSApiData(String type);
	
}