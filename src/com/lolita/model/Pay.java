package com.lolita.model;

public class Pay {
	
	private Integer pay_id;
	private String pay_name;
	
	public Integer getId(){
		return pay_id;
	}
	
	public void setId(Integer pay_id){
		this.pay_id = pay_id;
	}
	
	public String getName(){
		return pay_name;
	}
	
	public void setName(String pay_name){
		this.pay_name = pay_name == null ? null : pay_name.trim();
	}
}