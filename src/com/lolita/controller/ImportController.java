package com.lolita.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lolita.service.IImportService;

@Controller
@RequestMapping("import")
public class ImportController {

	@Inject
	IImportService importService;

	// 添加出货记录
	// add.do
	@RequestMapping(value = "add.do", produces = "text/json;charset=UTF-8")
	public @ResponseBody String addImport(Integer goods_id, float import_price,
			Integer amount, Integer source_id, Integer user_id, String remark) {
		return importService.addImport(goods_id, import_price, amount, source_id, user_id, remark);
	}

	// 查看入货记录列表
	//getlist.do
	@RequestMapping(value = "getlist.do", produces = "text/json;charset=UTF-8")
	public @ResponseBody String getImportList(){
		return importService.getImportList();
	}

	// 通过id获取入货记录
	//get.do
	@RequestMapping(value = "get.do", produces = "text/json;charset=UTF-8")
	public @ResponseBody String getImportById(Integer import_id){
		return importService.getImportById(import_id);
	}
}