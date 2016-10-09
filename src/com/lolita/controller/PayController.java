package com.lolita.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lolita.service.IPayService;

@Controller
@RequestMapping("pay")
public class PayController {
	
	@Inject
	IPayService payService;
	
	
	//获取支付方式
	//getlist.do
	@RequestMapping(value = "getlist.do", produces = "text/json;charset=UTF-8")
	public @ResponseBody String getPayList(){
		return payService.getPayList();
	}
	
	//新增支付方式
	//add.do?pay_name=xx
	@RequestMapping(value="add.do", produces = "text/json;charset=UTF-8")
	public @ResponseBody String addPay(String pay_name){
		return payService.addPay(pay_name);
	}
}