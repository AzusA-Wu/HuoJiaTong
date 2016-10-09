package com.lolita.service;

public interface IStaffService {

	// 获取员工列表
	public String getStaffList(Integer status);

	// 通过id获取员工
	public String getStaffById(Integer staff_id);

	// 添加员工
	public String addStaff(String staff_name, String staff_nickname,
			Integer status);

	// 更新员工资料
	public String updateStaff(Integer staff_id, String staff_name,
			String staff_nickname, Integer status);
}