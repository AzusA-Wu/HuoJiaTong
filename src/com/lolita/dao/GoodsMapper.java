package com.lolita.dao;

import java.util.List;

import com.lolita.model.Goods;

public interface GoodsMapper {
	
	//获取商品列表
	public List<Goods> getGoodsList();
	
	//通过id获取商品资料
	public Goods getGoodsById(Integer goods_id);
	
	//添加商品
	public void addGoods(Goods goods);
	
	//修改商品资料
	public void updateGoods(Goods goods);
	
	//增加商品库存
	public void increaseGoodsStock(Goods goods);
	
	//减少商品库存
	public void decreaseGoodsStock(Goods goods);
}