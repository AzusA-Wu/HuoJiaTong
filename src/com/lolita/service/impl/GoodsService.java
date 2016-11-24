package com.lolita.service.impl;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lolita.dao.BrandMapper;
import com.lolita.dao.ColorMapper;
import com.lolita.dao.GoodsMapper;
import com.lolita.dao.SizeMapper;
import com.lolita.data.ResultCode;
import com.lolita.model.Brand;
import com.lolita.model.Color;
import com.lolita.model.Goods;
import com.lolita.model.Size;
import com.lolita.operate.ResultJSON;
import com.lolita.service.IGoodsService;

@Service
public class GoodsService implements IGoodsService{

	// Mapper
	@Autowired
	GoodsMapper goodsMapper;
	@Autowired
	BrandMapper brandMapper;
	@Autowired
	ColorMapper colorMapper;
	@Autowired
	SizeMapper sizeMapper;

	// 创建实例
	ResultJSON resultJSON = new ResultJSON();

	// 添加商品
	@Transactional(propagation = Propagation.REQUIRED)
	public String addGoods(String goods_name, Integer brand_id,
			Integer color_id, Integer size_id, Integer stock,
			float standard_price, String remark) {

		// 构建json
		JSONObject jo = new JSONObject();

		try {
			Goods goods = new Goods();
			goods.setName(goods_name);
			goods.setBrand(brand_id);
			goods.setColor(color_id);
			goods.setSize(size_id);
			goods.setStock(stock);
			goods.setStandardPrice(standard_price);
			goods.setRemark(remark);

			goodsMapper.addGoods(goods);
			jo = resultJSON.createResultJSON(ResultCode.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			jo = resultJSON.createResultJSON(ResultCode.UNKNOWN_ERROR);
		}

		return jo.toString();
	}

	// 修改商品资料
	@Transactional(propagation = Propagation.REQUIRED)
	public String updateGoods(Integer goods_id, String goods_name,
			Integer brand_id, Integer color_id, Integer size_id, Integer stock,
			float standard_price, String remark) {

		// 构建json
		JSONObject jo = new JSONObject();

		try {
			Goods goods = new Goods();
			goods.setId(goods_id);
			goods.setName(goods_name);
			goods.setBrand(brand_id);
			goods.setColor(color_id);
			goods.setSize(size_id);
			goods.setStock(stock);
			goods.setStandardPrice(standard_price);
			goods.setRemark(remark);

			goodsMapper.updateGoods(goods);
			jo = resultJSON.createResultJSON(ResultCode.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			jo = resultJSON.createResultJSON(ResultCode.UNKNOWN_ERROR);
		}

		return jo.toString();
	}

	// 获取商品列表
	@Transactional(propagation = Propagation.REQUIRED)
	public String getGoodsListJson() {

		// 构建json
		JSONObject jo = new JSONObject();

		try {
			List<Goods> goods = goodsMapper.getGoodsList();

			JSONArray data = new JSONArray();
			for (Integer i = 0; i < goods.size(); i++) {
				JSONObject temp = new JSONObject();
				putGoodsToJSON(goods.get(i), temp);
				data.put(temp);
			}

			jo = resultJSON.createResultJSON(ResultCode.SUCCESS);
			jo.put("data", data);
		} catch (Exception e) {
			e.printStackTrace();
			jo = resultJSON.createResultJSON(ResultCode.UNKNOWN_ERROR);
		}

		return jo.toString();
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Goods> getGoodsList() {
		return goodsMapper.getGoodsList();
	}

	// 通过id获取商品资料
	@Transactional(propagation = Propagation.REQUIRED)
	public String getGoodsById(Integer goods_id) {

		// 构建json
		JSONObject jo = new JSONObject();

		try {
			Goods goods = goodsMapper.getGoodsById(goods_id);

			JSONObject data = new JSONObject();
			putGoodsToJSON(goods, data);

			jo = resultJSON.createResultJSON(ResultCode.SUCCESS);
			jo.put("data", data);
		} catch (Exception e) {
			e.printStackTrace();
			jo = resultJSON.createResultJSON(ResultCode.UNKNOWN_ERROR);
		}

		return jo.toString();
	}

	// 商品资料写入json
	private void putGoodsToJSON(Goods goods, JSONObject jo) throws Exception {

		jo.put("goods_id", goods.getId());
		jo.put("goods_name", goods.getName());
		Brand brand = brandMapper.getBrandById(goods.getBrand());
		jo.put("brand", brand.getName());
		Color color = colorMapper.getColorById(goods.getColor());
		jo.put("color", color.getName());
		Size size = sizeMapper.getSizeById(goods.getColor());
		jo.put("size", size.getName());
		jo.put("stock", goods.getStock());
		jo.put("standard_price", goods.getStandardPrice());
		jo.put("remark", goods.getRemark() == null ? "" : goods.getRemark());
	}
}