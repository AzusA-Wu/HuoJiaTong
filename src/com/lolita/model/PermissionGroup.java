package com.lolita.model;

public class PermissionGroup {
	
	private Integer group_id;
	private String group_name;
	
	public Integer getId(){
		return group_id;
	}
	
	public void setId(Integer group_id){
		this.group_id = group_id;
	}
	
	public String getName(){
		return group_name;
	}
	
	public void setName(String group_name){
		this.group_name = group_name;
	}
}