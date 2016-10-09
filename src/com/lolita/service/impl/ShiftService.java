package com.lolita.service.impl;

import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lolita.dao.ShiftMapper;
import com.lolita.dao.StaffMapper;
import com.lolita.dao.UserMapper;
import com.lolita.data.ResultCode;
import com.lolita.model.Shift;
import com.lolita.model.Staff;
import com.lolita.model.User;
import com.lolita.operate.ResultJSON;
import com.lolita.service.IShiftService;

@Service
public class ShiftService implements IShiftService {

	// Mapper
	@Autowired
	ShiftMapper shiftMapper;
	@Autowired
	StaffMapper staffMapper;
	@Autowired
	UserMapper userMapper;

	// 创建实例
	ResultJSON resultJSON = new ResultJSON();

	// 添加排班
	@Transactional(propagation = Propagation.REQUIRED)
	public String addShift(Integer staff_id, Date starttime, Date endtime,
			Integer user_id) {

		// 构建json
		JSONObject jo = new JSONObject();

		try {
			Shift shift = new Shift();
			shift.setStaff(staff_id);
			shift.setStarttime(starttime);
			shift.setEndtime(endtime);
			shift.setUser(user_id);
			shift.setTime(new Date());

			shiftMapper.addShift(shift);
			jo = resultJSON.createResultJSON(ResultCode.SUCCESS);

		} catch (Exception e) {
			e.printStackTrace();
			jo = resultJSON.createResultJSON(ResultCode.UNKNOWN_ERROR);
		}

		return jo.toString();
	}

	// 修改排班
	@Transactional(propagation = Propagation.REQUIRED)
	public String updateShift(Integer shift_id, Integer staff_id,
			Date starttime, Date endtime, Integer user_id) {

		// 构建json
		JSONObject jo = new JSONObject();

		try {
			Shift shift = new Shift();
			shift.setId(shift_id);
			shift.setStaff(staff_id);
			shift.setStarttime(starttime);
			shift.setEndtime(endtime);
			shift.setUser(user_id);
			shift.setTime(new Date());

			shiftMapper.updateShift(shift);
			jo = resultJSON.createResultJSON(ResultCode.SUCCESS);

		} catch (Exception e) {
			e.printStackTrace();
			jo = resultJSON.createResultJSON(ResultCode.UNKNOWN_ERROR);
		}

		return jo.toString();
	}

	// 删除排班
	@Transactional(propagation = Propagation.REQUIRED)
	public String deleteShift(Integer shift_id) {

		// 构建json
		JSONObject jo = new JSONObject();

		try {
			shiftMapper.deleteShift(shift_id);
			jo = resultJSON.createResultJSON(ResultCode.SUCCESS);

		} catch (Exception e) {
			e.printStackTrace();
			jo = resultJSON.createResultJSON(ResultCode.UNKNOWN_ERROR);
		}

		return jo.toString();
	}

	// 获取特定时间排班表
	@Transactional(propagation = Propagation.REQUIRED)
	public String getShiftListByDate(Date starttime, Date endtime) {

		// 构建json
		JSONObject jo = new JSONObject();
		
		try {
			Shift param = new Shift();
			param.setStarttime(starttime);
			param.setEndtime(endtime);
			List<Shift> shift = shiftMapper.getShiftListByDate(param);
			
			JSONArray data = new JSONArray();
			for(Integer i=0;i<shift.size();i++){
				JSONObject temp = new JSONObject();
				temp.put("shift_id", shift.get(i).getId());
				Staff staff = staffMapper.getStaffById(shift.get(i).getStaff());
				temp.put("staff_id", staff.getId());
				temp.put("staff_name", staff.getName());
				temp.put("staff_nickname", staff.getNickname());
				temp.put("starttime", shift.get(i).getStarttime());
				temp.put("endtime", shift.get(i).getEndtime());
				User user = userMapper.getUserById(shift.get(i).getUser());
				temp.put("user_id", user.getId());
				temp.put("user_name", user.getName());
				temp.put("edittime", shift.get(i).getTime());
				
				data.put(temp);
			}
			jo = resultJSON.createResultJSON(ResultCode.SUCCESS);
			jo.put("data", data);

		} catch (Exception e) {
			e.printStackTrace();
			jo = resultJSON.createResultJSON(ResultCode.UNKNOWN_ERROR);
		}

		return jo.toString();
	}
}