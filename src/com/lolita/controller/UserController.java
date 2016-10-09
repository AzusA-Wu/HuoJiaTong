package com.lolita.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lolita.service.IUserService;

@Controller
@RequestMapping("user")
public class UserController {

	@Inject
	IUserService userService;

	// 用户登录
	// login.do
	@RequestMapping(value = "login.do", produces = "text/json;charset=UTF-8")
	public @ResponseBody String login(String account, String password) {
		return userService.login(account, password);
	}

	// 新增用户
	// add.do
	@RequestMapping(value = "add.do", produces = "text/json;charset=UTF-8")
	public @ResponseBody String addUser(String account, String password,
			String name, Integer permission_group) {
		return userService.addUser(account, password, name, permission_group);
	}

	// 更新用户资料
	// update.do
	@RequestMapping(value = "update.do", produces = "text/json;charset=UTF-8")
	public @ResponseBody String updateUser(Integer user_id, String account,
			String password, String name, Integer permission_group) {
		return userService.updateUser(user_id, account, password, name,
				permission_group);
	}

	// 创建权限组
	// addpermissiongroup.do
	@RequestMapping(value = "addpermissiongroup.do", produces = "text/json;charset=UTF-8")
	public @ResponseBody String addPermissionGroup(String group_name) {
		return userService.addPermissionGroup(group_name);
	}

	// 获取权限组列表
	// getpermissiongrouplist.do
	@RequestMapping(value = "getpermissiongrouplist.do", produces = "text/json;charset=UTF-8")
	public @ResponseBody String getPermissionGroupList() {
		return userService.getPermissionGroupList();
	}

	// 通过id获取权限组
	// getpermissiongroupbyid.do
	@RequestMapping(value = "getpermissiongroupbyid.do", produces = "text/json;charset=UTF-8")
	public @ResponseBody String getPermissionGroupById(Integer group_id) {
		return userService.getPermissionGroupById(group_id);
	}

	// 修改权限组
	// updatepermissiongroup.do
	@RequestMapping(value = "updatepermissiongroup.do", produces = "text/json;charset=UTF-8")
	public @ResponseBody String updatePermissionGroup(Integer group_id,
			String group_name) {
		return userService.updatePermissionGroup(group_id, group_name);
	}

	// 删除权限组
	// deletepermissiongroup.do
	@RequestMapping(value = "deletepermissiongroup.do", produces = "text/json;charset=UTF-8")
	public @ResponseBody String deletePermissionGroup(Integer group_id) {
		return userService.deletePermissionGroup(group_id);
	}

	// 创建权限
	// addpermission.do
	@RequestMapping(value = "addpermission.do", produces = "text/json;charset=UTF-8")
	public @ResponseBody String addPermission(String permission) {
		return userService.addPermission(permission);
	}

	// 修改权限名
	// updatepermission.do
	@RequestMapping(value = "updatepermission.do", produces = "text/json;charset=UTF-8")
	public @ResponseBody String updatePermission(Integer permission_id,
			String permission) {
		return userService.updatePermission(permission_id, permission);
	}

	// 添加权限至权限组
	// addpermissiontogroup.do
	@RequestMapping(value = "addpermissiontogroup.do", produces = "text/json;charset=UTF-8")
	public @ResponseBody String addPermissionToGroup(Integer group_id,
			Integer permission_id) {
		return userService.addPermissionToGroup(group_id, permission_id);
	}

	// 从权限组删除权限
	// deletepermissionfromgroup.do
	@RequestMapping(value = "deletepermissionfromgroup.do", produces = "text/json;charset=UTF-8")
	public @ResponseBody String deletePermissionFromGroup(Integer group_id,
			Integer permission_id) {
		return userService.deletePermissionFromGroup(group_id, permission_id);
	}

	// 通过权限组id获取权限组内的权限列表
	// getpermissionbygroup.do
	@RequestMapping(value = "getpermissionbygroup.do", produces = "text/json;charset=UTF-8")
	public @ResponseBody String getPermissionByGroup(Integer group_id) {
		return userService.getPermissionByGroup(group_id);
	}
	
	@RequestMapping("hello.do")
    public String sayHello(ModelMap map) {
        map.addAttribute("name", "PPAP");
        return "/hello.ftl";
    }
}