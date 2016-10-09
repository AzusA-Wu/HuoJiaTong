package com.lolita.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lolita.service.IGoodsService;

@Controller
@RequestMapping("goods")
public class GoodsController {

	@Inject
	IGoodsService goodsService;

	// 添加商品
	//add.do
	@RequestMapping(value="add.do", produces = "text/json;charset=UTF-8")
	public @ResponseBody String addGoods(String goods_name, Integer brand_id,
			Integer color_id, Integer size_id, Integer stock,
			float standard_price, String remark){
		return goodsService.addGoods(goods_name, brand_id, color_id, size_id, stock, standard_price, remark);
	}

	// 修改商品资料
	//update.do
	@RequestMapping(value="update.do", produces = "text/json;charset=UTF-8")
	public @ResponseBody String updateGoods(Integer goods_id, String goods_name,
			Integer brand_id, Integer color_id, Integer size_id, Integer stock,
			float standard_price, String remark){
		return goodsService.updateGoods(goods_id, goods_name, brand_id, color_id, size_id, stock, standard_price, remark);
	}

	// 获取商品列表
	//getlist.do
	@RequestMapping(value="getlist.do", produces = "text/json;charset=UTF-8")
	public @ResponseBody String getGoodsList(){
		return goodsService.getGoodsList();
	}

	// 通过id获取商品资料
	//getbyid.do
	@RequestMapping(value="getbyid.do", produces = "text/json;charset=UTF-8")
	public @ResponseBody String getGoodsById(Integer goods_id){
		return goodsService.getGoodsById(goods_id);
	}
}