package com.lolita.service;

public interface ISourceService {

	// 添加货源
	public String addSrouce(String source_name);

	// 修改货源
	public String updateSource(Integer source_id, String source_name);

	// 获取货源列表
	public String getSourceList();

	// 通过id获取货源
	public String getSourceById(Integer source_id);
}