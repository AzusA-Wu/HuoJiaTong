package com.lolita.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lolita.model.Brand;
import com.lolita.model.Color;
import com.lolita.model.Size;
import com.lolita.service.IBrandService;
import com.lolita.service.IColorService;
import com.lolita.service.IGoodsService;
import com.lolita.service.ISizeService;

@Controller
@RequestMapping("goods")
public class GoodsController {

	@Inject
	IGoodsService goodsService;
	@Inject
	IBrandService brandService;
	@Inject
	IColorService colorService;
	@Inject
	ISizeService sizeService;
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
		return goodsService.getGoodsListJson();
	}

	// 通过id获取商品资料
	//getbyid.do
	@RequestMapping(value="getbyid.do", produces = "text/json;charset=UTF-8")
	public @ResponseBody String getGoodsById(Integer goods_id){
		return goodsService.getGoodsById(goods_id);
	}
	
	// 商品列表页面
	@RequestMapping(value = "listPage.do", method = RequestMethod.GET)
	public ModelAndView listPage() throws Exception {
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("list", goodsService.getGoodsList());
		return new ModelAndView("h-ui/product-list.ftl", data);
	}
	
	// 添加商品页面
	@RequestMapping(value = "addPage.do", method = RequestMethod.GET)
	public ModelAndView addPage() throws Exception {
		Map<String, Object> data = new HashMap<String, Object>();
		// 获取品牌list
		List<Brand> brandList = brandService.getBrandList(0);
		data.put("brandList", brandList);
		// 获取颜色list
		List<Color> colorList = colorService.getColorList(0);
		data.put("colorList", colorList);
		// 获取尺寸list
		List<Size> sizeList = sizeService.getSizeList();
		data.put("sizeList", sizeList);
		return new ModelAndView("h-ui/product-add.ftl", data);
	}
}