package com.lolita.model;

public class GoodsType {
	
	private Integer type_id;
	private String type_name;
	private Integer status;
	
	
	public Integer getId(){
		return type_id;
	}
	
	public void setId(Integer type_id){
		this.type_id = type_id;
	}
	
	public String getName(){
		return type_name;
	}
	
	public void setName(String type_name){
		this.type_name = type_name == null ? null : type_name.trim();
	}
	
	public Integer getStatus(){
		return status;
	}
	
	public void setStatus(Integer status){
		this.status = status;
	}
}