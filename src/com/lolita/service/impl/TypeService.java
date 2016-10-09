package com.lolita.service.impl;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lolita.dao.TypeMapper;
import com.lolita.data.ResultCode;
import com.lolita.model.GoodsType;
import com.lolita.operate.ResultJSON;
import com.lolita.service.ITypeService;

@Service
public class TypeService implements ITypeService{
	
	//Mapper
	@Autowired
	TypeMapper typeMapper;
	
	// 创建实例
	ResultJSON resultJSON = new ResultJSON();
	
	
	//添加商品类型
	@Transactional(propagation = Propagation.REQUIRED)
	public String addType(String type_name){
		
		//构建json
		JSONObject jo = new JSONObject();
		
		try{
			if(typeMapper.checkType(type_name).isEmpty()){//若该商品类型不存在
			GoodsType type = new GoodsType();
			type.setName(type_name);
			type.setStatus(0);//0为有效
			
			typeMapper.addType(type);
			jo = resultJSON.createResultJSON(ResultCode.SUCCESS);
			}else{//该商品类型已存在
				jo = resultJSON.createResultJSON(ResultCode.TYPE_EXIST);
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
			jo = resultJSON.createResultJSON(ResultCode.UNKNOWN_ERROR);
		}
		
		return jo.toString();
	}
	
	//获取商品类型列表
	@Transactional(propagation = Propagation.REQUIRED)
	public String getTypeList(Integer status){
		
		//构建json
		JSONObject jo = new JSONObject();
		
		try{
			List<GoodsType> type = typeMapper.getTypeList(status);
			JSONArray ja = new JSONArray();
			
			for(Integer i=0;i<type.size();i++){
				JSONObject temp = new JSONObject();
				temp.put("type_id", type.get(i).getId());
				temp.put("type_name", type.get(i).getName());
				temp.put("status", status);
				
				ja.put(temp);
			}
			jo = resultJSON.createResultJSON(ResultCode.SUCCESS);
			jo.put("type", ja);
			
		}catch(Exception e){
			e.printStackTrace();
			jo = resultJSON.createResultJSON(ResultCode.UNKNOWN_ERROR);			
		}
		
		return jo.toString();
	}
	
	//编辑商品类型
	@Transactional(propagation = Propagation.REQUIRED)
	public String updateType(Integer type_id, String type_name, Integer status){
		
		//构建json
		JSONObject jo = new JSONObject();
		
		try{
			GoodsType type = new GoodsType();
			type.setId(type_id);
			type.setName(type_name);
			type.setStatus(status);
			typeMapper.updateType(type);
			
			jo = resultJSON.createResultJSON(ResultCode.SUCCESS);
		}catch(Exception e){
			e.printStackTrace();
			jo = resultJSON.createResultJSON(ResultCode.UNKNOWN_ERROR);
		}
		
		return jo.toString();
	}
	
}