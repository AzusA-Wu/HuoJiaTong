package com.lolita.dao;

import java.util.List;

import com.lolita.model.Vip;
import com.lolita.model.VipLocation;

public interface VipMapper {
	
	//添加会员
	public void addVip(Vip vip);
	
	//修改会员资料
	public void updateVip(Vip vip);
	
	//通过用户账号查找会员
	public Vip getVipById(String vip_id);
	
	//获取会员列表
	public List<Vip> getVipList();
	
	//获取归属地
	public VipLocation getLocation(Integer location_id);
	
	//添加归属地
	public void addLocation(String location_name);
	
	//获取归属地列表
	public List<VipLocation> getLocationList();
}