package com.lolita.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lolita.service.ITypeService;

@Controller
@RequestMapping("type")
public class TypeController {
	
	@Inject
	ITypeService typeService;
	
	
	//获取商品类型列表
	//getlist.do?status=xx
	@RequestMapping(value = "getlist.do", produces = "text/json;charset=UTF-8")
	public @ResponseBody String getList(Integer status){
		return typeService.getTypeList(status);
	}
	
	//添加商品类型
	//add.do?type_name
	@RequestMapping(value = "add.do", produces = "text/json;charset=UTF-8")
	public @ResponseBody String addType(String type_name){
		return typeService.addType(type_name);
	}
	
	//编辑商品类型
	//update.do?
	@RequestMapping(value = "update.do", produces = "text/json;charset=UTF-8")
	public @ResponseBody String updateType(Integer type_id, String type_name, Integer status){
		return typeService.updateType(type_id, type_name, status);
	}
}