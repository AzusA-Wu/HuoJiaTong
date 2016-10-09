package com.lolita.dao;

import java.util.List;

import com.lolita.model.Permission;
import com.lolita.model.PermissionGroup;
import com.lolita.model.PermissionRelation;

public interface PermissionMapper {

	// 创建权限组
	public void addPermissionGroup(PermissionGroup group);

	// 获取权限组列表
	public List<PermissionGroup> getPermissionGroupList();

	// 通过id获取权限组
	public PermissionGroup getPermissionGroupById(Integer group_id);

	// 修改权限组
	public void updatePermissionGroup(PermissionGroup group);

	// 删除权限组
	public void deletePermissionGroup(Integer group_id);

	// 创建权限
	public void addPermission(Permission permission);

	// 修改权限名
	public void updatePermission(Permission permission);

	// 添加权限至权限组
	public void addPermissionToGroup(PermissionRelation relation);

	// 从权限组删除权限
	public void deletePermissionFromGroup(PermissionRelation relation);

	// 通过权限组id获取权限组内的权限列表
	public List<PermissionRelation> getPermissionByGroup(Integer group_id);
	
	//删除权限组时删除组<->权限之间关系
	public void deleteRelationByGroup(Integer group_id);
}