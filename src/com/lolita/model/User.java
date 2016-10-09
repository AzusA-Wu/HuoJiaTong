package com.lolita.model;

public class User {
	
	private Integer user_id;
	private String account;
	private String password;
	private String name;
	private Integer permission_group;
	
	public Integer getId(){
		return user_id;
	}
	
	public void setId(Integer user_id){
		this.user_id = user_id;
	}
	
	public String getAccount(){
		return account;
	}
	
	public void setAccount(String account){
		this.account = account == null ? null : account;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password){
		this.password = password == null ? null : password.trim();
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name == null ? null : name.trim();
	}
	
	public Integer getPermissionGroup(){
		return permission_group;
	}
	
	public void setPermissionGroup(Integer permission_group){
		this.permission_group = permission_group;
	}
}