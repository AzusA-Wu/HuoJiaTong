package com.lolita.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lolita.service.IColorService;

@Controller
@RequestMapping("color")
public class ColorController {
	
	@Inject
	IColorService colorService;
	
	//获取颜色列表
	//getlist.do?status=xx
	@RequestMapping(value = "getlist.do", produces = "text/json;charset=UTF-8")
	public @ResponseBody String getColorList(Integer status){
		return colorService.getColorList(status);
	}
	
	//添加颜色
	//add.do?color_name=xx
	@RequestMapping(value = "add.do", produces = "text/json;charset=UTF-8")
	public @ResponseBody String addColor(String color_name){
		return colorService.addColor(color_name);
	}
	
	//修改颜色
	//update.do?color_id=xx&color_name=xx&color_status=xx
	@RequestMapping(value = "update.do", produces = "text/json;charset=UTF-8")
	public @ResponseBody String updateColor(Integer color_id, String color_name, Integer status){
		return colorService.updateColor(color_id, color_name, status);
	}
}