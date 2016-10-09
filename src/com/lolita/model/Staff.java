package com.lolita.model;

public class Staff {
	
	private Integer staff_id;
	private String staff_name;
	private String staff_nickname;
	private Integer status;
	
	public Integer getId(){
		return staff_id;
	}
	
	public void setId(Integer staff_id){
		this.staff_id = staff_id;
	}
	
	public String getName(){
		return staff_name;
	}
	
	public void setName(String staff_name){
		this.staff_name = staff_name == null ? "" : staff_name.trim();
	}
	
	public String getNickname(){
		return staff_nickname;
	}
	
	public void setNickname(String staff_nickname){
		this.staff_nickname = staff_nickname == null ? null : staff_nickname.trim();
	}
	
	public Integer getStatus(){
		return status;
	}
	
	public void setStatus(Integer status){
		this.status = status;
	}
}