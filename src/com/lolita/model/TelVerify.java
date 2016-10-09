package com.lolita.model;

public class TelVerify {
	
	private Integer id;
	private String tel;
	private Integer yzm;
	
	public Integer getId(){
		return id;
	}
	
	public void setId(Integer id){
		this.id = id;
	}
	
	public String getTel(){
		return tel;
	}
	
	public void setTel(String tel){
		this.tel = tel == null ? null : tel.trim();
	}
	
	public Integer getVerify(){
		return yzm;
	}
	
	public void setVerify(Integer yzm){
		this.yzm = yzm;
	}
}