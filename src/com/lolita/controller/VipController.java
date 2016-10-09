package com.lolita.controller;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lolita.service.IVipService;

@Controller
@RequestMapping("vip")
public class VipController {
	
	@Inject
	IVipService vipService;
	
	//添加vip
	//add.do
	@RequestMapping(value = "add.do", produces = "text/json;charset=UTF-8")
	public @ResponseBody String addVip(String vip_id, String vip_name, Date birthday,
			String phone, String other_contact, Integer location){
		return vipService.addVip(vip_id, vip_name, birthday, phone, other_contact, location);
	}
	
	//更新vip
	//update.do
	@RequestMapping(value="update.do", produces = "text/json;charset=UTF-8")
	public @ResponseBody String updateVip(Integer id, String vip_id, String vip_name,
			Date birthday, String phone, String other_contact, Integer location){
		return vipService.updateVip(id, vip_id, vip_name, birthday, phone, other_contact, location);
	}
	
	//通过会员账号获取会员资料
	//get.do
	@RequestMapping(value="get.do", produces = "text/json;charset=UTF-8")
	public @ResponseBody String getVipById(String vip_id){
		return vipService.getVipById(vip_id);
	}
	
	//获取会员列表
	//getlist.do
	@RequestMapping(value="getlist.do", produces = "text/json;charset=UTF-8")
	public @ResponseBody String getVipList(){
		return vipService.getVipList();
	}
	
	//获取归属地列表
	//getlocationlist.do
	@RequestMapping(value="getlocationlist.do", produces = "text/json;charset=UTF-8")
	public @ResponseBody String getLocationList(){
		return vipService.getLocationList();
	}
	
	//添加归属地
	//addlocation.do?location_name=xx
	@RequestMapping(value="addlocation.do", produces = "text/json;charset=UTF-8")
	public @ResponseBody String addLocation(String location_name){
		return vipService.addLocation(location_name);
	}
}