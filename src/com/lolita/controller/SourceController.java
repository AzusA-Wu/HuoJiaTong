package com.lolita.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lolita.service.ISourceService;

@Controller
@RequestMapping("source")
public class SourceController {
	
	@Inject
	ISourceService sourceService;
	
	// 添加货源
	//add.do
	@RequestMapping(value = "add.do", produces = "text/json;charset=UTF-8")
	public @ResponseBody String addSrouce(String source_name){
		return sourceService.addSrouce(source_name);
	}

	// 修改货源
	//update.do
	@RequestMapping(value = "update.do", produces = "text/json;charset=UTF-8")
	public @ResponseBody String updateSource(Integer source_id,
			String source_name){
		return sourceService.updateSource(source_id, source_name);
	}

	// 获取货源列表
	//getlist.do
	@RequestMapping(value = "getlist.do", produces = "text/json;charset=UTF-8")
	public @ResponseBody String getSourceList(){
		return sourceService.getSourceList();
	}

	// 通过id获取货源
	//getbyid.do
	@RequestMapping(value = "getbyid.do", produces = "text/json;charset=UTF-8")
	public @ResponseBody String getSourceById(Integer source_id){
		return sourceService.getSourceById(source_id);
	}
}