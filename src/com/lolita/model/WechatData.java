package com.lolita.model;

public class WechatData {

	private Integer id;
	private String code;
	private String openid;
	private String access_token;
	private String refresh_token;
	private int is_follow;
	
	public Integer getId(){
		return id;
	}
	
	public void setId(Integer id){
		this.id = id;
	}
	
	public String getCode(){
		return code;
	}
	
	public void setCode(String code){
		this.code = code == null ? null : code.trim();
	}
	
	public String getOpenid(){
		return openid;
	}
	
	public void setOpenid(String openid){
		this.openid = openid == null ? null : openid.trim();
	}
	
	public String getAccess_Token(){
		return access_token;
	}
	
	public void setAccess_Token(String access_token){
		this.access_token = access_token == null ? null : access_token.trim();
	}
	
	public String getRefresh_Token(){
		return refresh_token;
	}
	
	public void setRefresh_Token(String refresh_token){
		this.refresh_token = refresh_token == null ? null : refresh_token.trim();
	}
	
	public boolean getIs_Follow(){
		if(is_follow == 0) return false;
		else return true;
	}
	
	public void setIs_Follow(boolean is_follow){
		if(is_follow == false) this.is_follow = 0;
		else this.is_follow = 1;
	}
}