package com.lolita.service;

import java.util.List;

import com.lolita.model.Color;

public interface IColorService {
	
	//获取颜色列表
	public String getColorListJson(Integer status);
	
	public List<Color> getColorList(Integer status);
		
	//添加颜色
	public String addColor(String color_name);
		
	//修改颜色
	public String updateColor(Integer color_id, String color_name, Integer status);
}