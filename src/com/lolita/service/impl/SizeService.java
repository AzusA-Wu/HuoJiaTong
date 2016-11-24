package com.lolita.service.impl;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lolita.dao.SizeMapper;
import com.lolita.data.ResultCode;
import com.lolita.model.Size;
import com.lolita.operate.ResultJSON;
import com.lolita.service.ISizeService;

@Service
public class SizeService implements ISizeService{
	
	//Mapper
	@Autowired
	SizeMapper sizeMapper;
	
	// 创建实例
	ResultJSON resultJSON = new ResultJSON();
	
	
	//添加尺寸
	@Transactional(propagation = Propagation.REQUIRED)
	public String addSize(String size_name){
		
		//构建json
		JSONObject jo = new JSONObject();
		
		try{
			sizeMapper.addSize(size_name);
			
			jo = resultJSON.createResultJSON(ResultCode.SUCCESS);
		}catch(Exception e){
			e.printStackTrace();
			jo = resultJSON.createResultJSON(ResultCode.UNKNOWN_ERROR);
		}
		
		return jo.toString();
	}
	
	//获取尺寸列表
	@Transactional(propagation = Propagation.REQUIRED)
	public String getSizeListJson(){
		
		//构建json
		JSONObject jo = new JSONObject();
		
		try{
			List<Size> size = sizeMapper.getSizeList();
			
			JSONArray data = new JSONArray();
			for(Integer i=0;i<size.size();i++){
				JSONObject temp = new JSONObject();
				temp.put("size_id", size.get(i).getId());
				temp.put("size_name", size.get(i).getName());
				
				data.put(temp);
			}
			
			jo = resultJSON.createResultJSON(ResultCode.SUCCESS);
			jo.put("data", data);
		}catch(Exception e){
			e.printStackTrace();
			jo = resultJSON.createResultJSON(ResultCode.UNKNOWN_ERROR);
		}
		
		return jo.toString();
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Size> getSizeList(){
		return sizeMapper.getSizeList();
	}
}