package com.lolita.model;

public class VipLocation {
	
	private Integer location_id;
	private String location_name;
	
	public Integer getId(){
		return location_id;
	}
	
	public void setId(Integer location_id){
		this.location_id = location_id;
	}
	
	public String getName(){
		return location_name;
	}
	
	public void setName(String location_name){
		this.location_name = location_name == null ? "" : location_name.trim();
	}
}