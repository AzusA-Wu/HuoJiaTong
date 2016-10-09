package com.lolita.service;

public interface ITypeService {

	// 添加商品类型
	public String addType(String type_name);

	// 获取商品类型列表
	public String getTypeList(Integer status);

	// 编辑商品类型
	public String updateType(Integer type_id, String type_name, Integer status);
}