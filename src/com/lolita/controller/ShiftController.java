package com.lolita.controller;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lolita.service.IShiftService;

@Controller
@RequestMapping("shift")
public class ShiftController {
	
	@Inject
	IShiftService shiftService;
	
	
	//添加排班
	//addshift.do
	@RequestMapping(value = "addshift.do", produces = "text/json;charset=UTF-8")
	public @ResponseBody String addShift(Integer staff_id, Date starttime, Date endtime, Integer user_id){
		return shiftService.addShift(staff_id, starttime, endtime, user_id);
	}
	
	//更新排班
	//updateshift.do
	@RequestMapping(value = "updateshift.do", produces = "text/json;charset=UTF-8")
	public @ResponseBody String updateShift(Integer shift_id, Integer staff_id, Date starttime, Date endtime, Integer user_id){
		return shiftService.updateShift(shift_id, staff_id, starttime, endtime, user_id);
	}
	
	//删除排班
	//deleteshift.do
	@RequestMapping(value = "deleteshift.do", produces = "text/json;charset=UTF-8")
	public @ResponseBody String deleteShift(Integer shift_id){
		return shiftService.deleteShift(shift_id);
	}
	
	//获取某一时段排班列表
	//getshiftbydate.do
	@RequestMapping(value = "getshiftbydate.do", produces = "text/json;charset=UTF-8")
	public @ResponseBody String getShiftListByDate(Date starttime, Date endtime){
		return shiftService.getShiftListByDate(starttime, endtime);
	}
}