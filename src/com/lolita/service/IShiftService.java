package com.lolita.service;

import java.util.Date;

public interface IShiftService {

	// 添加排班
	public String addShift(Integer staff_id, Date starttime, Date endtime,
			Integer user_id);

	// 修改排班
	public String updateShift(Integer shift_id, Integer staff_id,
			Date starttime, Date endtime, Integer user_id);

	// 删除排班
	public String deleteShift(Integer shift_id);

	// 获取特定时间排班表
	public String getShiftListByDate(Date starttime, Date endtime);
}