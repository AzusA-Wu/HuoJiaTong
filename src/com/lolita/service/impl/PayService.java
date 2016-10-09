package com.lolita.service.impl;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lolita.dao.PayMapper;
import com.lolita.data.ResultCode;
import com.lolita.model.Pay;
import com.lolita.operate.ResultJSON;
import com.lolita.service.IPayService;

@Service
public class PayService implements IPayService{

	// Mapper
	@Autowired
	PayMapper payMapper;

	// 创建实例
	ResultJSON resultJSON = new ResultJSON();
	
	
	// 获取支付方式列表
	@Transactional(propagation = Propagation.REQUIRED)
	public String getPayList(){
		
		//构建json
		JSONObject jo = new JSONObject();
		
		try{
			List<Pay> payList = payMapper.getPayList();
			
			JSONArray ja = new JSONArray();
			for(Integer i=0;i<payList.size();i++){
				JSONObject temp = new JSONObject();
				temp.put("pay_id", payList.get(i).getId());
				temp.put("pay_name", payList.get(i).getName());
				ja.put(temp);
			}
			
			jo = resultJSON.createResultJSON(ResultCode.SUCCESS);
			jo.put("pay", ja);
			
		}catch(Exception e){
			e.printStackTrace();
			jo = resultJSON.createResultJSON(ResultCode.UNKNOWN_ERROR);
		}
		
		return jo.toString();
	}
	
	//添加支付方式
	@Transactional(propagation = Propagation.REQUIRED)
	public String addPay(String pay_name){
		
		//构建json
		JSONObject jo = new JSONObject();
		
		try{
			Pay pay = new Pay();
			pay.setName(pay_name);
			payMapper.addPay(pay);
			
			jo = resultJSON.createResultJSON(ResultCode.SUCCESS);
		}catch(Exception e){
			e.printStackTrace();
			jo = resultJSON.createResultJSON(ResultCode.UNKNOWN_ERROR);
		}
		
		return jo.toString();
	}
}