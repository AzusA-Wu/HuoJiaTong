package com.lolita.service.impl;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lolita.dao.StaffMapper;
import com.lolita.data.ResultCode;
import com.lolita.model.Staff;
import com.lolita.operate.ResultJSON;
import com.lolita.service.IStaffService;

@Service
public class StaffService implements IStaffService{

	// Mapper
	@Autowired
	StaffMapper staffMapper;

	// 创建实例
	ResultJSON resultJSON = new ResultJSON();

	// 获取员工列表
	@Transactional(propagation = Propagation.REQUIRED)
	public String getStaffList(Integer status) {

		// 构建json
		JSONObject jo = new JSONObject();

		try {
			List<Staff> staff = staffMapper.getStaffList(status);

			JSONArray data = new JSONArray();
			for (Integer i = 0; i < staff.size(); i++) {
				JSONObject temp = new JSONObject();
				putStaffToJSON(staff.get(i), temp);

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

	// 通过id获取员工
	@Transactional(propagation = Propagation.REQUIRED)
	public String getStaffById(Integer staff_id) {

		// 构建json
		JSONObject jo = new JSONObject();

		try {
			Staff staff = staffMapper.getStaffById(staff_id);

			JSONObject data = new JSONObject();
			putStaffToJSON(staff, data);

			jo = resultJSON.createResultJSON(ResultCode.SUCCESS);
			jo.put("data", data);

		} catch (Exception e) {
			e.printStackTrace();
			jo = resultJSON.createResultJSON(ResultCode.UNKNOWN_ERROR);
		}

		return jo.toString();
	}

	// 添加员工
	@Transactional(propagation = Propagation.REQUIRED)
	public String addStaff(String staff_name, String staff_nickname,
			Integer status) {

		// 构建json
		JSONObject jo = new JSONObject();

		try {
			Staff staff = new Staff();
			staff.setName(staff_name);
			staff.setNickname(staff_nickname);
			staff.setStatus(status);

			staffMapper.addStaff(staff);
			jo = resultJSON.createResultJSON(ResultCode.SUCCESS);

		} catch (Exception e) {
			e.printStackTrace();
			jo = resultJSON.createResultJSON(ResultCode.UNKNOWN_ERROR);
		}

		return jo.toString();
	}

	// 更新员工资料
	@Transactional(propagation = Propagation.REQUIRED)
	public String updateStaff(Integer staff_id, String staff_name,
			String staff_nickname, Integer status) {

		// 构建json
		JSONObject jo = new JSONObject();

		try {
			Staff staff = new Staff();
			staff.setName(staff_name);
			staff.setNickname(staff_nickname);
			staff.setStatus(status);

			staffMapper.updateStaff(staff);
			jo = resultJSON.createResultJSON(ResultCode.SUCCESS);

		} catch (Exception e) {
			e.printStackTrace();
			jo = resultJSON.createResultJSON(ResultCode.UNKNOWN_ERROR);
		}

		return jo.toString();
	}
	
	
	//员工资料写入JSON
	private void putStaffToJSON(Staff staff, JSONObject jo) throws Exception{
		
		jo.put("staff_id", staff.getId());
		jo.put("staff_name", staff.getName());
		jo.put("staff_nickname", staff.getNickname());
		jo.put("status", staff.getStatus());
	}
}