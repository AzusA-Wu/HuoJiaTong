package com.lolita.service.impl;

import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lolita.dao.VipMapper;
import com.lolita.data.ResultCode;
import com.lolita.model.Vip;
import com.lolita.model.VipLocation;
import com.lolita.operate.ResultJSON;
import com.lolita.service.IVipService;

@Service
public class VipService implements IVipService{

	// Mapper
	@Autowired
	VipMapper vipMapper;

	// 创建实例
	ResultJSON resultJSON = new ResultJSON();

	// 添加Vip
	@Transactional(propagation = Propagation.REQUIRED)
	public String addVip(String vip_id, String vip_name, Date birthday,
			String phone, String other_contact, Integer location) {

		// 构建json
		JSONObject jo = new JSONObject();

		try {
			// 赋值
			Vip vip = new Vip();
			vip.setVipId(vip_id);
			vip.setName(vip_name);
			vip.setBirthday(birthday);
			vip.setPhone(phone);
			vip.setContact(other_contact);
			vip.setLocation(location);
			// 插入数据库
			vipMapper.addVip(vip);

			jo = resultJSON.createResultJSON(ResultCode.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			jo = resultJSON.createResultJSON(ResultCode.UNKNOWN_ERROR);
		}

		return jo.toString();
	}

	// 更新Vip
	@Transactional(propagation = Propagation.REQUIRED)
	public String updateVip(Integer id, String vip_id, String vip_name,
			Date birthday, String phone, String other_contact, Integer location) {

		// 构建json
		JSONObject jo = new JSONObject();

		try {
			// 赋值
			Vip vip = new Vip();
			vip.setId(id);
			vip.setVipId(vip_id);
			vip.setName(vip_name);
			vip.setBirthday(birthday);
			vip.setPhone(phone);
			vip.setContact(other_contact);
			vip.setLocation(location);
			// 更新数据库
			vipMapper.updateVip(vip);

			jo = resultJSON.createResultJSON(ResultCode.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			jo = resultJSON.createResultJSON(ResultCode.UNKNOWN_ERROR);
		}

		return jo.toString();
	}
	
	//通过会员账号获取会员资料
	@Transactional(propagation = Propagation.REQUIRED)
	public String getVipById(String vip_id){
		
		// 构建json
		JSONObject jo = new JSONObject();
		
		try{
			Vip vip = vipMapper.getVipById(vip_id);
			
			JSONObject data = new JSONObject();
			putVipToJSON(vip, data);
			jo = resultJSON.createResultJSON(ResultCode.SUCCESS);
			jo.put("data", data);
		}catch(Exception e){
			e.printStackTrace();
			jo = resultJSON.createResultJSON(ResultCode.UNKNOWN_ERROR);
		}
		
		return jo.toString();
	}
	
	//获取会员列表
	@Transactional(propagation = Propagation.REQUIRED)
	public String getVipList(){
		
		// 构建json
		JSONObject jo = new JSONObject();
		
		try{
			List<Vip> vip = vipMapper.getVipList();
			
			JSONArray data = new JSONArray();
			for(Integer i=0;i<vip.size();i++){
				JSONObject temp = new JSONObject();
				putVipToJSON(vip.get(i), temp);
				
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
	
	//获取归属地列表
	@Transactional(propagation = Propagation.REQUIRED)
	public String getLocationList(){
		
		//构建json
		JSONObject jo = new JSONObject();
		
		try{
			List<VipLocation> location = vipMapper.getLocationList();
			
			JSONArray ja = new JSONArray();
			for(Integer i=0;i<location.size();i++){
				JSONObject temp = new JSONObject();
				temp.put("location_id", location.get(i).getId());
				temp.put("location_name", location.get(i).getName());
				
				ja.put(temp);
			}
			
			jo = resultJSON.createResultJSON(ResultCode.SUCCESS);
			jo.put("data", ja);
		}catch(Exception e){
			e.printStackTrace();
			jo = resultJSON.createResultJSON(ResultCode.UNKNOWN_ERROR);
		}
		
		return jo.toString();
	}
	
	//添加归属地
	@Transactional(propagation = Propagation.REQUIRED)
	public String addLocation(String location_name){
		
		//构建json
		JSONObject jo = new JSONObject();
		
		try{
			vipMapper.addLocation(location_name);
			
			jo = resultJSON.createResultJSON(ResultCode.SUCCESS);
		}catch(Exception e){
			e.printStackTrace();
			jo = resultJSON.createResultJSON(ResultCode.UNKNOWN_ERROR);
		}
		
		return jo.toString();
	}
	
	
	//会员资料写入JSON
	private void putVipToJSON(Vip vip, JSONObject jo) throws Exception{
		
		jo.put("vip_id", vip.getVipId());
		jo.put("vip_name", vip.getName());
		jo.put("birthday", vip.getBirthday());
		jo.put("phone", vip.getPhone());
		jo.put("other_contact", vip.getContact());
		VipLocation location = vipMapper.getLocation(vip.getLocation());
		jo.put("location", location.getName());
	}
}