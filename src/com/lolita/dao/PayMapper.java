package com.lolita.dao;

import java.util.List;

import com.lolita.model.Pay;

public interface PayMapper {
	
	//获取支付方式列表
	public List<Pay> getPayList();
	
	//添加支付方式
	public void addPay(Pay pay);
}