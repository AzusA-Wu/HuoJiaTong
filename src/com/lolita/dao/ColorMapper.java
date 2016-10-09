package com.lolita.dao;

import java.util.List;

import com.lolita.model.Color;

public interface ColorMapper {
	
	//获取颜色列表
	public List<Color> getColorList(Integer status);
	
	//通过id获取颜色
	public Color getColorById(Integer color_id);
	
	//添加颜色
	public void addColor(Color color);
	
	//修改颜色
	public void updateColor(Color color);
}