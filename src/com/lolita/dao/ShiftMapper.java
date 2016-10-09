package com.lolita.dao;

import java.util.List;

import com.lolita.model.Shift;

public interface ShiftMapper {
	
	//添加排班
	public void addShift(Shift shift);
	
	//修改排班
	public void updateShift(Shift shift);
	
	//删除排班
	public void deleteShift(Integer shift_id);
	
	//获取排班列表
	public List<Shift> getShiftListByDate(Shift shift);
}