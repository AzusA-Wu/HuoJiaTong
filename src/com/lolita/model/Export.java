package com.lolita.model;

import java.util.Date;

public class Export {
	
	private Integer export_id;
	private Integer goods_id;
	private Integer amount;
	private float export_price;
	private Integer user_id;
	private Date export_time;
	private Integer vip_id;
	private Integer pay_id;
	private String remark;
	
	public Integer getId(){
		return export_id;
	}
	
	public void setId(Integer export_id){
		this.export_id = export_id;
	}
	
	public Integer getGoods(){
		return goods_id;
	}
	
	public void setGoods(Integer goods_id){
		this.goods_id = goods_id;
	}
	
	public Integer getAmount(){
		return amount;
	}
	
	public void setAmount(Integer amount){
		this.amount = amount;
	}
	
	public float getPrice(){
		return export_price;
	}
	
	public void setPrice(float export_price){
		this.export_price = export_price;
	}
	
	public Integer getUser(){
		return user_id;
	}
	
	public void setUser(Integer user_id){
		this.user_id = user_id;
	}
	
	public Date getTime(){
		return export_time;
	}
	
	public void setTime(Date export_time){
		this.export_time = export_time;
	}
	
	public Integer getVip(){
		return vip_id;
	}
	
	public void setVip(Integer vip_id){
		this.vip_id = vip_id;
	}
	
	public Integer getPay(){
		return pay_id;
	}
	
	public void setPay(Integer pay_id){
		this.pay_id = pay_id;
	}
	
	public String getRemark(){
		return remark;
	}
	
	public void setRemark(String remark){
		this.remark = remark == null ? null : remark.trim();
	}
}