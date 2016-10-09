package com.lolita.dao;

import com.lolita.model.ThirdUser;

public interface ThirdUserMapper {
	
	//写入新浪第三方资料
	public void addSinaUser(ThirdUser thirdUser);
	
	//写入微信第三方资料
	public void addWecharUser(ThirdUser thirdUser);
}