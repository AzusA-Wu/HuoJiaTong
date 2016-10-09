package com.lolita.model;

public class Color {
	
	private Integer color_id;
	private String color_name;
	private Integer status;
	
	public Integer getId(){
		return color_id;
	}
	
	public void setId(Integer color_id){
		this.color_id = color_id;
	}
	
	public String getName(){
		return color_name;
	}
	
	public void setName(String color_name){
		this.color_name = color_name == null ? null : color_name.trim();
	}
	
	public Integer getStatus(){
		return status;
	}
	
	public void setStatus(Integer status){
		this.status = status;
	}
}