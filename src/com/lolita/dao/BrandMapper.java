package com.lolita.dao;

import java.util.List;

import com.lolita.model.Brand;

public interface BrandMapper {
	
	//添加品牌
	public void addBrand(Brand brand);
	
	//获取品牌列表
	public List<Brand> getBrandList(Integer status);
	
	//通过id获取品牌
	public Brand getBrandById(Integer brand_id);
	
	//通过品牌名搜索品牌
	public List<Brand> checkBrand(String brand_name);
	
	//修改品牌
	public void updateBrand(Brand brand);
}