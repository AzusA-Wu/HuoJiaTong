package com.lolita.service;

public interface IPayService {

	// 获取支付方式列表
	public String getPayList();

	// 添加支付方式
	public String addPay(String pay_name);
}