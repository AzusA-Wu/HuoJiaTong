package com.lolita.model;

import java.util.Date;

public class Vip {
	
	private Integer id;
	private String vip_id;
	private String vip_name;
	private Date birthday;
	private String phone;
	private String other_contact;
	private Integer location;
	
	public Integer getId(){
		return id;
	}
	
	public void setId(Integer id){
		this.id = id;
	}
	
	public String getVipId(){
		return vip_id;
	}
	
	public void setVipId(String vip_id){
		this.vip_id = vip_id == null ? "" : vip_id.trim();
	}
	
	public String getName(){
		return vip_name;
	}
	
	public void setName(String vip_name){
		this.vip_name = vip_name == null ? "" : vip_name.trim();
	}
	
	public Date getBirthday(){
		return birthday;
	}
	
	public void setBirthday(Date birthday){
		this.birthday = birthday;
	}
	
	public String getPhone(){
		return phone;
	}
	
	public void setPhone(String phone){
		this.phone = phone == null ? "" : phone.trim();
	}
	
	public String getContact(){
		return other_contact;
	}
	
	public void setContact(String other_contact){
		this.other_contact = other_contact == null ? null : other_contact.trim();
	}
	
	public Integer getLocation(){
		return location;
	}
	
	public void setLocation(Integer location){
		this.location = location;
	}
}