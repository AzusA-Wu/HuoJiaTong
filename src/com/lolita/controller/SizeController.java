package com.lolita.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lolita.service.ISizeService;

@Controller
@RequestMapping("size")
public class SizeController {

	@Inject
	ISizeService sizeService;

	// 获取尺寸列表
	// getsizelist.do
	@RequestMapping(value = "getsizelist.do", produces = "text/json;charset=UTF-8")
	public @ResponseBody String getSizeList() {
		return sizeService.getSizeList();
	}

	// 添加归属地
	// addsize.do?size_name=xx
	@RequestMapping(value = "addsize.do", produces = "text/json;charset=UTF-8")
	public @ResponseBody String addSize(String size_name) {
		return sizeService.addSize(size_name);
	}
}