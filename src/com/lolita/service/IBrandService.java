package com.lolita.service;

public interface IBrandService {
	
	//获取品牌列表
	public String getBrandList(Integer status);
	
	//添加品牌
	public String addBrand(String brand_name, Integer status);
	
	//修改品牌
	public String updateBrand(Integer brand_id, String brand_name, Integer status);
}