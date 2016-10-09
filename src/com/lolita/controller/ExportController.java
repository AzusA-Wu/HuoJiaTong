package com.lolita.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lolita.service.IExportService;

@Controller
@RequestMapping("export")
public class ExportController {

	@Inject
	IExportService exportService;

	// 添加出货记录
	// add.do
	@RequestMapping(value = "add.do", produces = "text/json;charset=UTF-8")
	public @ResponseBody String addExport(Integer goods_id, Integer amount,
			float export_price, Integer user_id, Integer vip_id,
			Integer pay_id, String remark) {
		return exportService.addExport(goods_id, amount, export_price, user_id,
				vip_id, pay_id, remark);
	}

	// 查看出货记录列表
	// getlist.do
	@RequestMapping(value = "getlist.do", produces = "text/json;charset=UTF-8")
	public @ResponseBody String getExportList() {
		return exportService.getExportList();
	}

	// 通过id获取出货记录
	// get.do
	@RequestMapping(value = "get.do", produces = "text/json;charset=UTF-8")
	public @ResponseBody String getExportById(Integer export_id) {
		return exportService.getExportById(export_id);
	}
}