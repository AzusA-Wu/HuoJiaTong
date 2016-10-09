package com.lolita.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lolita.service.IStaffService;

@Controller
@RequestMapping("staff")
public class StaffController {

	@Inject
	IStaffService staffService;

	// 获取员工列表
	// getstafflist.do
	@RequestMapping(value = "getstafflist.do", produces = "text/json;charset=UTF-8")
	public @ResponseBody String getStaffList(Integer status) {
		return staffService.getStaffList(status);
	}

	// 通过id获取员工
	// getstaffbyid.do
	@RequestMapping(value = "getstaffbyid.do", produces = "text/json;charset=UTF-8")
	public @ResponseBody String getStaffById(Integer staff_id) {
		return staffService.getStaffById(staff_id);
	}

	// 添加员工
	// add.do
	@RequestMapping(value = "add.do", produces = "text/json;charset=UTF-8")
	public @ResponseBody String addStaff(String staff_name,
			String staff_nickname, Integer status) {
		return staffService.addStaff(staff_name, staff_nickname, status);
	}

	// 更新员工资料
	// update.do
	@RequestMapping(value = "update.do", produces = "text/json;charset=UTF-8")
	public String updateStaff(Integer staff_id, String staff_name,
			String staff_nickname, Integer status) {
		return staffService.updateStaff(staff_id, staff_name, staff_nickname,
				status);
	}
}