package com.lolita.model;

public class GoodsSource {
	
	private Integer source_id;
	private String source_name;
	
	public Integer getId(){
		return source_id;
	}
	
	public void setId(Integer source_id){
		this.source_id = source_id;
	}
	
	public String getName(){
		return source_name;
	}
	
	public void setName(String source_name){
		this.source_name = source_name == null ? "" : source_name.trim();
	}
}