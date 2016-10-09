package com.lolita.service.impl;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lolita.dao.BrandMapper;
import com.lolita.data.ResultCode;
import com.lolita.model.Brand;
import com.lolita.operate.ResultJSON;
import com.lolita.service.IBrandService;

@Service
public class BrandService implements IBrandService {

	// Mapper
	@Autowired
	BrandMapper brandMapper;

	// 创建实例
	ResultJSON resultJSON = new ResultJSON();

	// 获取品牌列表
	@Transactional(propagation = Propagation.REQUIRED)
	public String getBrandList(Integer status) {

		// 构建json
		JSONObject jo = new JSONObject();

		try {
			List<Brand> brandList = brandMapper.getBrandList(status);//0：获取有效品牌；1:获取无效品牌；2：获取所有品牌
			jo = resultJSON.createResultJSON(ResultCode.SUCCESS);
			jo.put("brand", createBrandJSON(brandList));
		} catch (Exception e) {
			e.printStackTrace();
			jo = resultJSON.createResultJSON(ResultCode.UNKNOWN_ERROR);
		}

		return jo.toString();
	}

	// 添加品牌
	@Transactional(propagation = Propagation.REQUIRED)
	public String addBrand(String brand_name, Integer status) {

		// 构建json
		JSONObject jo = new JSONObject();

		try {
			// 搜索是否已有该品牌
			List<Brand> brandList = brandMapper.checkBrand(brand_name);
			if (brandList.isEmpty()) {// 若无该品牌
				Brand brand = new Brand();
				brand.setName(brand_name);
				brand.setStatus(status);
				brandMapper.addBrand(brand);
				jo = resultJSON.createResultJSON(ResultCode.SUCCESS);// 成功
			} else {
				jo = resultJSON.createResultJSON(ResultCode.BRAND_EXIST);// 品牌已存在
			}

		} catch (Exception e) {
			e.printStackTrace();
			jo = resultJSON.createResultJSON(ResultCode.UNKNOWN_ERROR);
		}

		return jo.toString();
	}
	
	//修改品牌
	@Transactional(propagation = Propagation.REQUIRED)
	public String updateBrand(Integer brand_id, String brand_name, Integer status){
		
		//构建json
		JSONObject jo = new JSONObject();
		
		try{
			//通过id获取品牌
			Brand brand = brandMapper.getBrandById(brand_id);
			if(null == brand){//品牌不存在
				jo = resultJSON.createResultJSON(ResultCode.BRAND_NOT_EXIST);
			}else{
				brand.setName(brand_name);
				brand.setStatus(status);
				brandMapper.updateBrand(brand);
				jo = resultJSON.createResultJSON(ResultCode.SUCCESS);
			}
		}catch(Exception e){
			e.printStackTrace();
			jo = resultJSON.createResultJSON(ResultCode.UNKNOWN_ERROR);
		}
		
		return jo.toString();
	}
	
	
	// 构建品牌列表json
	private JSONArray createBrandJSON(List<Brand> brand) {

		// 构建json数组
		JSONArray ja = new JSONArray();

		for (Integer i = 0; i < brand.size(); i++) {
			// 写入json
			JSONObject jo = new JSONObject();
			try {
				jo.put("brand_id", brand.get(i).getId());
				jo.put("brand_name", brand.get(i).getName());
				jo.put("status", brand.get(i).getStatus());
			} catch (JSONException e) {
				e.printStackTrace();
			}

			// json写入至json数组
			ja.put(jo);
		}
		return ja;
	}
}