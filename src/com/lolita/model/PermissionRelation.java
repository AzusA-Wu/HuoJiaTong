package com.lolita.model;

public class PermissionRelation {
	
	private Integer relation_id;
	private Integer group_id;
	private Integer permission_id;
	
	
	public Integer getId(){
		return relation_id;
	}
	
	public void setId(Integer relation_id){
		this.relation_id=relation_id;
	}
	
	public Integer getGroup(){
		return group_id;
	}
	
	public void setGroup(Integer group_id){
		this.group_id = group_id;
	}
	
	public Integer getPermission(){
		return permission_id;
	}
	
	public void setPermission(Integer permission_id){
		this.permission_id = permission_id;
	}
}