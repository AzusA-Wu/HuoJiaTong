package com.lolita.model;

public class Permission {
	
	private Integer permission_id;
	private String permission;
	
	public Integer getId(){
		return permission_id;
	}
	
	public void setId(Integer permission_id){
		this.permission_id = permission_id;
	}
	
	public String getPermission(){
		return permission;
	}
	
	public void setPermission(String permission){
		this.permission = permission == null ? "" : permission.trim();
	}
}