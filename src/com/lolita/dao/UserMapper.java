package com.lolita.dao;

import com.lolita.model.User;

public interface UserMapper {
	
	//通过用户名获取用户
	public User getUserByAccount(String account);
	
	//通过id获取用户资料
	public User getUserById(Integer user_id);
	
	//添加用户
	public void addUser(User user);
	
	//更新用户资料
	public void updateUser(User user);
	
}