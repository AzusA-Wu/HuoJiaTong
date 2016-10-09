package com.lolita.dao;

import com.lolita.model.TelVerify;

public interface TelVerifyMapper {
	
	//写入手机验证码表
	public void addTelVerify(TelVerify verify);
	
	//更新手机验证码表
	public void updateTelVerify(TelVerify verify);
	
	//通过手机号获取验证码
	public TelVerify getVerifyByTel(String tel);
	
	//清理手机验证码条目
	public void deleteVerifyByTel(String tel);
}