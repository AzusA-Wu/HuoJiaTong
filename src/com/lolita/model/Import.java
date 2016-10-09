package com.lolita.model;

import java.util.Date;

public class Import {
	
	private Integer import_id;
	private Integer goods_id;
	private float import_price;
	private Integer amount;
	private Integer source_id;
	private Integer user_id;
	private Date import_time;
	private String remark;
	
	public Integer getId(){
		return import_id;
	}
	
	public void setId(Integer import_id){
		this.import_id = import_id;
	}
	
	public Integer getGoods(){
		return goods_id;
	}
	
	public void setGoods(Integer goods_id){
		this.goods_id = goods_id;
	}
	
	public float getPrice(){
		return import_price;
	}
	
	public void setPrice(float import_price){
		this.import_price = import_price;
	}
	
	public Integer getAmount(){
		return amount;
	}
	
	public void setAmount(Integer amount){
		this.amount = amount;
	}
	
	public Integer getSource(){
		return source_id;
	}
	
	public void setSource(Integer source_id){
		this.source_id = source_id;
	}
	
	public Integer getUser(){
		return user_id;
	}
	
	public void setUser(Integer user_id){
		this.user_id = user_id;
	}
	
	public Date getTime(){
		return import_time;
	}
	
	public void setTime(Date import_time){
		this.import_time = import_time;
	}
	
	public String getRemark(){
		return remark;
	}
	
	public void setRemark(String remark){
		this.remark = remark == null ? null : remark.trim();
	}
}