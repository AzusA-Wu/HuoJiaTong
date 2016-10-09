package com.lolita.dao;

import java.util.List;

import com.lolita.model.GoodsType;

public interface TypeMapper {
	
	//获取商品类型
	public List<GoodsType> getTypeList(Integer status);
	
	//添加商品类型
	public void addType(GoodsType goods_type);
	
	//检查商品类型是否已存在
	public List<GoodsType> checkType(String type_name);
	
	//更新商品类型
	public void updateType(GoodsType type);
	
}