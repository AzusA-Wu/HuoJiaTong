package com.lolita.dao;

import java.util.List;

import com.lolita.model.Export;

public interface ExportMapper {
	
	//添加出货记录
	public void addExport(Export ex);
	
	//查看出货记录列表
	public List<Export> getExportList();
	
	//通过id获取出货记录
	public Export getExportById(Integer export_id);
}