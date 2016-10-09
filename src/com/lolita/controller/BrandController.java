package com.lolita.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lolita.service.IBrandService;

@Controller
@RequestMapping("brand")
public class BrandController {
	
	@Inject
	IBrandService brandService;
	
	//获取品牌列表
	//getlist.do?status=xx
	@RequestMapping(value = "getlist.do", produces = "text/json;charset=UTF-8")
	public @ResponseBody String getBrandList(Integer status){
		return brandService.getBrandList(status);
	}
	
	//添加品牌
	//add.do?brand_name=xx&status=xx
	@RequestMapping(value = "add.do", produces = "text/json;charset=UTF-8")
	public @ResponseBody String addBrand(String brand_name, Integer status){
		return brandService.addBrand(brand_name, status);
	}
	
	//修改品牌
	//update.do?brand_id=xx&brand_name=xx&status=xx
	@RequestMapping(value = "update.do", produces = "text/json;charset=UTF-8")
	public String updateBrand(Integer brand_id, String brand_name, Integer status){
		return brandService.updateBrand(brand_id, brand_name, status);
	}
}