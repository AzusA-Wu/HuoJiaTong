package com.lolita.service.impl;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lolita.dao.ColorMapper;
import com.lolita.data.ResultCode;
import com.lolita.model.Color;
import com.lolita.operate.ResultJSON;
import com.lolita.service.IColorService;

@Service
public class ColorService implements IColorService{
	
	//Mapper
	@Autowired
	ColorMapper colorMapper;
	
	// 创建实例
	ResultJSON resultJSON = new ResultJSON();
	
	
	//获取颜色列表
	@Transactional(propagation = Propagation.REQUIRED)
	public String getColorListJson(Integer status){
		
		//构建json
		JSONObject jo = new JSONObject();
		
		try{
			List<Color> color = colorMapper.getColorList(status);
			
			JSONArray ja = new JSONArray();
			for(Integer i=0; i<color.size();i++){
				JSONObject temp = new JSONObject();
				temp.put("color_id", color.get(i).getId());
				temp.put("color_name", color.get(i).getName());
				temp.put("status", color.get(i).getStatus());
				
				ja.put(temp);
			}
			
			jo = resultJSON.createResultJSON(ResultCode.SUCCESS);
			jo.put("color", ja);
			
		}catch(Exception e){
			e.printStackTrace();
			jo = resultJSON.createResultJSON(ResultCode.UNKNOWN_ERROR);
		}
		
		return jo.toString();
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Color> getColorList(Integer status){
		return colorMapper.getColorList(status);
	}
	
	//添加颜色
	@Transactional(propagation = Propagation.REQUIRED)
	public String addColor(String color_name){
		
		//构建json
		JSONObject jo = new JSONObject();
		
		try{
			Color color = new Color();
			color.setName(color_name);
			color.setStatus(0);
			colorMapper.addColor(color);
			
			jo = resultJSON.createResultJSON(ResultCode.SUCCESS);
		}catch(Exception e){
			e.printStackTrace();
			jo = resultJSON.createResultJSON(ResultCode.UNKNOWN_ERROR);
		}
		
		return jo.toString();
	}
	
	//修改颜色
	@Transactional(propagation = Propagation.REQUIRED)
	public String updateColor(Integer color_id, String color_name, Integer status){
		
		//构建json
		JSONObject jo = new JSONObject();
		
		try{
			Color color = new Color();
			color.setId(color_id);
			color.setName(color_name);
			color.setStatus(status);
			colorMapper.updateColor(color);
			
			jo = resultJSON.createResultJSON(ResultCode.SUCCESS);
		}catch(Exception e){
			e.printStackTrace();
			jo = resultJSON.createResultJSON(ResultCode.UNKNOWN_ERROR);
		}
		
		return jo.toString();
	}
}