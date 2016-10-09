package com.lolita.service;

import java.util.Date;

public interface IVipService {
	
	//添加vip
	public String addVip(String vip_id, String vip_name, Date birthday,
			String phone, String other_contact, Integer location);
	
	//更新vip
	public String updateVip(Integer id, String vip_id, String vip_name,
			Date birthday, String phone, String other_contact, Integer location);
	
	//通过会员账号获取会员资料
	public String getVipById(String vip_id);
	
	//获取会员列表
	public String getVipList();
	
	//获取归属地列表
	public String getLocationList();
	
	//添加归属地
	public String addLocation(String location_name);
}