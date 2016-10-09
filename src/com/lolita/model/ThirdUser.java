package com.lolita.model;

public class ThirdUser {
	
	private Integer third_id;
	private String sina_id;//新浪微博api所用的用户id
	private String openid;//用户微信openid
	private String name;
	private String avatar;
	private String gender;
	private String description;
	
	public Integer getId(){
		return third_id;
	}
	
	public void setId(Integer third_id){
		this.third_id = third_id;
	}
	
	public String getSinaId(){
		return sina_id;
	}
	
	public void setSinaId(String sina_id){
		this.sina_id = sina_id;
	}
	
	public String getOpenid(){
		return openid;
	}
	
	public void setOpenid(String openid){
		this.openid = openid;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getAvatar(){
		return avatar;
	}
	
	public void setAvatar(String avatar){
		this.avatar = avatar;
	}
	
	public String getGender(){
		return gender;
	}
	
	public void setGender(String gender){
		this.gender = gender;
	}
	
	public String getDescription(){
		return description;
	}
	
	public void setDescription(String description){
		this.description = description == null ? "" : description.trim();
	}
}