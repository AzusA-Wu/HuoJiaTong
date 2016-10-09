package com.lolita.service.impl;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lolita.dao.PermissionMapper;
import com.lolita.dao.UserMapper;
import com.lolita.data.ResultCode;
import com.lolita.model.Permission;
import com.lolita.model.PermissionGroup;
import com.lolita.model.PermissionRelation;
import com.lolita.model.User;
import com.lolita.operate.ResultJSON;
import com.lolita.service.IUserService;

@Service
public class UserService implements IUserService {

	// Mapper
	@Autowired
	UserMapper userMapper;
	@Autowired
	PermissionMapper permissionMapper;

	// 创建实例
	ResultJSON resultJSON = new ResultJSON();

	// 用户登录
	@Transactional(propagation = Propagation.REQUIRED)
	public String login(String account, String password) {

		// 构建json
		JSONObject jo = new JSONObject();

		try {
			User user = userMapper.getUserByAccount(account);
			if (null == user) {
				jo = resultJSON.createResultJSON(ResultCode.USER_ACCOUNT_ERROR);// 账号错误
			} else if (!password.equals(user.getPassword())) {
				jo = resultJSON.createResultJSON(ResultCode.PASSWORD_ERROR);// 密码错误
			} else {
				JSONObject data = new JSONObject();
				putUserToJSON(user, data);
				jo = resultJSON.createResultJSON(ResultCode.SUCCESS);
				jo.put("data", data);
			}

		} catch (Exception e) {
			e.printStackTrace();
			jo = resultJSON.createResultJSON(ResultCode.UNKNOWN_ERROR);
		}

		return jo.toString();
	}

	// 修改用户资料
	@Transactional(propagation = Propagation.REQUIRED)
	public String updateUser(Integer user_id, String account, String password,
			String name, Integer permission_group) {

		// 构建json
		JSONObject jo = new JSONObject();

		try {
			User user = new User();
			user.setId(user_id);
			user.setAccount(account);
			user.setPassword(password);
			user.setName(name);
			user.setPermissionGroup(permission_group);

			userMapper.updateUser(user);
			jo = resultJSON.createResultJSON(ResultCode.SUCCESS);

		} catch (Exception e) {
			e.printStackTrace();
			jo = resultJSON.createResultJSON(ResultCode.UNKNOWN_ERROR);
		}

		return jo.toString();
	}

	// 添加用户
	@Transactional(propagation = Propagation.REQUIRED)
	public String addUser(String account, String password, String name,
			Integer permission_group) {

		// 构建json
		JSONObject jo = new JSONObject();

		try {
			if (null != userMapper.getUserByAccount(account)) {
				jo = resultJSON.createResultJSON(ResultCode.USER_ACCOUNT_EXIST);// 用户名已被使用
			} else {
				User user = new User();
				user.setAccount(account);
				user.setPassword(password);
				user.setName(name);
				user.setPermissionGroup(permission_group);

				userMapper.addUser(user);
				jo = resultJSON.createResultJSON(ResultCode.SUCCESS);
			}

		} catch (Exception e) {
			e.printStackTrace();
			jo = resultJSON.createResultJSON(ResultCode.UNKNOWN_ERROR);
		}

		return jo.toString();
	}

	// 创建权限组
	@Transactional(propagation = Propagation.REQUIRED)
	public String addPermissionGroup(String group_name) {

		// 构建json
		JSONObject jo = new JSONObject();

		try {
			PermissionGroup group = new PermissionGroup();
			group.setName(group_name);

			permissionMapper.addPermissionGroup(group);
			jo = resultJSON.createResultJSON(ResultCode.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			jo = resultJSON.createResultJSON(ResultCode.UNKNOWN_ERROR);
		}
		return jo.toString();
	}

	// 获取权限组列表
	@Transactional(propagation = Propagation.REQUIRED)
	public String getPermissionGroupList() {

		// 构建json
		JSONObject jo = new JSONObject();

		try {
			List<PermissionGroup> group = permissionMapper
					.getPermissionGroupList();

			JSONArray data = new JSONArray();
			for (Integer i = 0; i < group.size(); i++) {
				JSONObject temp = new JSONObject();
				putPermissionGroupToJSON(group.get(i), temp);
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

	// 通过id获取权限组
	@Transactional(propagation = Propagation.REQUIRED)
	public String getPermissionGroupById(Integer group_id) {

		// 构建json
		JSONObject jo = new JSONObject();

		try {
			PermissionGroup group = permissionMapper
					.getPermissionGroupById(group_id);

			JSONObject data = new JSONObject();
			putPermissionGroupToJSON(group, data);

			jo = resultJSON.createResultJSON(ResultCode.SUCCESS);
			jo.put("data", data);
		} catch (Exception e) {
			e.printStackTrace();
			jo = resultJSON.createResultJSON(ResultCode.UNKNOWN_ERROR);
		}
		return jo.toString();
	}

	// 修改权限组
	@Transactional(propagation = Propagation.REQUIRED)
	public String updatePermissionGroup(Integer group_id, String group_name) {

		// 构建json
		JSONObject jo = new JSONObject();

		try {
			PermissionGroup group = new PermissionGroup();
			group.setId(group_id);
			group.setName(group_name);

			permissionMapper.updatePermissionGroup(group);
			jo = resultJSON.createResultJSON(ResultCode.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			jo = resultJSON.createResultJSON(ResultCode.UNKNOWN_ERROR);
		}
		return jo.toString();
	}

	// 删除权限组
	@Transactional(propagation = Propagation.REQUIRED)
	public String deletePermissionGroup(Integer group_id) {

		// 构建json
		JSONObject jo = new JSONObject();

		try {
			permissionMapper.deleteRelationByGroup(group_id);
			permissionMapper.deletePermissionGroup(group_id);
			jo = resultJSON.createResultJSON(ResultCode.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			jo = resultJSON.createResultJSON(ResultCode.UNKNOWN_ERROR);
		}
		return jo.toString();
	}

	// 创建权限
	@Transactional(propagation = Propagation.REQUIRED)
	public String addPermission(String permission) {

		// 构建json
		JSONObject jo = new JSONObject();

		try {
			Permission param = new Permission();
			param.setPermission(permission);

			permissionMapper.addPermission(param);
			jo = resultJSON.createResultJSON(ResultCode.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			jo = resultJSON.createResultJSON(ResultCode.UNKNOWN_ERROR);
		}
		return jo.toString();
	}

	// 修改权限名
	@Transactional(propagation = Propagation.REQUIRED)
	public String updatePermission(Integer permission_id, String permission) {

		// 构建json
		JSONObject jo = new JSONObject();

		try {
			Permission param = new Permission();
			param.setId(permission_id);
			param.setPermission(permission);

			permissionMapper.updatePermission(param);
			jo = resultJSON.createResultJSON(ResultCode.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			jo = resultJSON.createResultJSON(ResultCode.UNKNOWN_ERROR);
		}
		return jo.toString();
	}

	// 添加权限至权限组
	@Transactional(propagation = Propagation.REQUIRED)
	public String addPermissionToGroup(Integer group_id, Integer permission_id) {

		// 构建json
		JSONObject jo = new JSONObject();

		try {
			PermissionRelation relation = new PermissionRelation();
			relation.setGroup(group_id);
			relation.setPermission(permission_id);

			permissionMapper.addPermissionToGroup(relation);
			jo = resultJSON.createResultJSON(ResultCode.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			jo = resultJSON.createResultJSON(ResultCode.UNKNOWN_ERROR);
		}

		return jo.toString();
	}

	// 从权限组删除权限
	@Transactional(propagation = Propagation.REQUIRED)
	public String deletePermissionFromGroup(Integer group_id,
			Integer permission_id) {

		// 构建json
		JSONObject jo = new JSONObject();

		try {
			PermissionRelation relation = new PermissionRelation();
			relation.setGroup(group_id);
			relation.setPermission(permission_id);

			permissionMapper.deletePermissionFromGroup(relation);
			jo = resultJSON.createResultJSON(ResultCode.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			jo = resultJSON.createResultJSON(ResultCode.UNKNOWN_ERROR);
		}

		return jo.toString();
	}

	// 通过权限组id获取权限组内的权限列表
	@Transactional(propagation = Propagation.REQUIRED)
	public String getPermissionByGroup(Integer group_id) {

		// 构建json
		JSONObject jo = new JSONObject();

		try {
			List<PermissionRelation> relation = permissionMapper.getPermissionByGroup(group_id);
			JSONArray data = new JSONArray();
			for (Integer i = 0; i < relation.size(); i++) {
				JSONObject temp = new JSONObject();
				putPermissionRelationToJSON(relation.get(i), temp);
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

	// 用户资料写入json
	private void putUserToJSON(User user, JSONObject jo) throws Exception {

		jo.put("user_id", user.getId());
		jo.put("name", user.getName());
		jo.put("permission_group", user.getPermissionGroup());
	}

	// 权限组资料写入json
	private void putPermissionGroupToJSON(PermissionGroup group, JSONObject jo)
			throws Exception {

		jo.put("group_id", group.getId());
		jo.put("group_name", group.getName());
	}
	
	//权限关系写入json
	private void putPermissionRelationToJSON(PermissionRelation relation, JSONObject jo) throws Exception{
		
		jo.put("group_id", relation.getGroup());
		jo.put("permission_id", relation.getPermission());
	}
}