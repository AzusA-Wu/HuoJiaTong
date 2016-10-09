package com.lolita.controller;

import javax.inject.Inject;

import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lolita.service.IWechatService;

@Controller
@RequestMapping("wechat")
public class WechatController {
	
	@Inject
	IWechatService wechatService;
	
	//获取openid
	//getopenid.do?code=xx
	@RequestMapping(value="getopenid.do", produces="text/json;charset=UTF-8")
	public @ResponseBody String getOpenid(String code) throws JSONException{
		return wechatService.getOpenid(code);
	}
	
	//更新关注状态
	//updatefollowstatus.do?openid=xx
	@RequestMapping(value="updatefollowstatus.do", produces="text/json;charset=UTF-8")
	public @ResponseBody String updateFollowStatus(String openid) throws JSONException{
		return wechatService.updateFollowStatus(openid);
	}
	
	//获取JSApi签名
	//getsignature.do?url=xx
	@RequestMapping(value="getsignature.do", produces="text/json;charset=UTF-8")
	public @ResponseBody String getSignature(String url){
		return wechatService.getSignature(url);
	}
	
}