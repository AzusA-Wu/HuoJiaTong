package com.lolita.dao;

import java.util.List;

import com.lolita.model.GoodsSource;

public interface SourceMapper {
	
	//添加货源
	public void addSrouce(String source_name);
	
	//修改货源
	public void updateSource(GoodsSource source);
	
	//获取货源列表
	public List<GoodsSource> getSourceList();
	
	//通过id获取货源
	public GoodsSource getSourceById(Integer source_id);
}