package com.lolita.model;

public class Size {
	
	private Integer size_id;
	private String size_name;
	
	public Integer getId(){
		return size_id;
	}
	
	public void setId(Integer size_id){
		this.size_id = size_id;
	}
	
	public String getName(){
		return size_name;
	}
	
	public void setName(String size_name){
		this.size_name = size_name == null ? "" : size_name.trim();
	}
}