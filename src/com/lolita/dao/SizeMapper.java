package com.lolita.dao;

import java.util.List;

import com.lolita.model.Size;

public interface SizeMapper {
	
	//添加尺寸
	public void addSize(String size_name);
	
	//获取尺寸列表
	public List<Size> getSizeList();
	
	//通过id获取尺寸
	public Size getSizeById(Integer size_id);
}