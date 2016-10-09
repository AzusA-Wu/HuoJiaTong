package com.lolita.model;

public class Brand {
	
	private Integer brand_id;
	private String brand_name;
	private Integer status;
	
	public Integer getId(){
		return brand_id;
	}
	
	public void setId(Integer brand_id){
		this.brand_id = brand_id;
	}
	
	public String getName(){
		return brand_name;
	}
	
	public void setName(String brand_name){
		this.brand_name = brand_name == null ? null : brand_name.trim();
	}
	
	public Integer getStatus(){
		return status;
	}
	
	public void setStatus(Integer status){
		this.status = status;
	}
	
}