package com.lolita.dao;

import java.util.List;

import com.lolita.model.Import;

public interface ImportMapper {
	
	//添加入货记录
	public void addImport(Import im);
	
	//查看入货记录列表
	public List<Import> getImportList();
	
	//通过id获取入货记录
	public Import getImportById(Integer import_id);
}