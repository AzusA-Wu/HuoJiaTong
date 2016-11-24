package com.lolita.service;

import java.util.List;

import com.lolita.model.Size;

public interface ISizeService {
	
	//添加尺寸
	public String addSize(String size_name);
	
	//获取尺寸列表
	public String getSizeListJson();
	
	public List<Size> getSizeList();
}