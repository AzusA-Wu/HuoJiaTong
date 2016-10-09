package com.lolita.model;

public class Goods {
	
	private Integer goods_id;
	private String goods_name;
	private Integer brand_id;
	private Integer color_id;
	private Integer size_id;
	private Integer stock;
	private Integer type_id;
	private float standard_price;
	private String remark;
	
	public Integer getId(){
		return goods_id;
	}
	
	public void setId(Integer goods_id){
		this.goods_id = goods_id;
	}
	
	public String getName(){
		return goods_name;
	}
	
	public void setName(String goods_name){
		this.goods_name = goods_name == null ? "" : goods_name.trim();
	}
	
	public Integer getBrand(){
		return brand_id;
	}
	
	public void setBrand(Integer brand_id){
		this.brand_id = brand_id;
	}
	
	public Integer getColor(){
		return color_id;
	}
	
	public void setColor(Integer color_id){
		this.color_id = color_id;
	}
	
	public Integer getSize(){
		return size_id;
	}
	
	public void setSize(Integer size_id){
		this.size_id = size_id;
	}
	
	public Integer getStock(){
		return stock;
	}
	
	public void setStock(Integer stock){
		this.stock = stock;
	}
	
	public Integer getGoodsType(){
		return type_id;
	}
	
	public float getStandardPrice(){
		return standard_price;
	}
	
	public void setStandardPrice(float standard_price){
		this.standard_price = standard_price;
	}
		
	public String getRemark(){
		return remark;
	}
	
	public void setRemark(String remark){
		this.remark = remark == null ? null : remark.trim();
	}
}