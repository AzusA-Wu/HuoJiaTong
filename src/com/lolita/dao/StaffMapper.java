package com.lolita.dao;

import java.util.List;

import com.lolita.model.Staff;

public interface StaffMapper {
	
	//通过id获取员工资料
	public Staff getStaffById(Integer staff_id);
	
	//添加员工资料
	public void addStaff(Staff staff);
	
	//修改员工资料
	public void updateStaff(Staff staff);
	
	//获取员工列表
	public List<Staff> getStaffList(Integer status);
}