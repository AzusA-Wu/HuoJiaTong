package com.lolita.service;

public interface IUserService {

	// 用户登录
	public String login(String account, String password);

	// 修改用户资料
	public String updateUser(Integer user_id, String account, String password,
			String name, Integer permission_group);

	// 添加用户
	public String addUser(String account, String password, String name,
			Integer permission_group);

	// 创建权限组
	public String addPermissionGroup(String group_name);

	// 获取权限组列表
	public String getPermissionGroupList();

	// 通过id获取权限组
	public String getPermissionGroupById(Integer group_id);

	// 修改权限组
	public String updatePermissionGroup(Integer group_id, String group_name);

	// 删除权限组
	public String deletePermissionGroup(Integer group_id);

	// 创建权限
	public String addPermission(String permission);

	// 修改权限名
	public String updatePermission(Integer permission_id, String permission);

	// 添加权限至权限组
	public String addPermissionToGroup(Integer group_id, Integer permission_id);

	// 从权限组删除权限
	public String deletePermissionFromGroup(Integer group_id,
			Integer permission_id);

	// 通过权限组id获取权限组内的权限列表
	public String getPermissionByGroup(Integer group_id);
}