package com.lolita.service;

public interface IExportService {

	// 添加出货记录
	public String addExport(Integer goods_id, Integer amount,
			float export_price, Integer user_id, Integer vip_id,
			Integer pay_id, String remark);

	// 查看出货记录列表
	public String getExportList();

	// 通过id获取出货记录
	public String getExportById(Integer export_id);
}