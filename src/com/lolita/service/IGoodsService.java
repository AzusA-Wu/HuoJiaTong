package com.lolita.service;

public interface IGoodsService {

	// 添加商品
	public String addGoods(String goods_name, Integer brand_id,
			Integer color_id, Integer size_id, Integer stock,
			float standard_price, String remark);

	// 修改商品资料
	public String updateGoods(Integer goods_id, String goods_name,
			Integer brand_id, Integer color_id, Integer size_id, Integer stock,
			float standard_price, String remark);

	// 获取商品列表
	public String getGoodsList();

	// 通过id获取商品资料
	public String getGoodsById(Integer goods_id);
}