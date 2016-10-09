package com.lolita.service;

public interface IImportService {

	// 添加入货记录
	public String addImport(Integer goods_id, float import_price,
			Integer amount, Integer source_id, Integer user_id, String remark);

	// 查看入货记录列表
	public String getImportList();

	// 通过id获取入货记录
	public String getImportById(Integer import_id);
}