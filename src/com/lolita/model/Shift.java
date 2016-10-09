package com.lolita.model;

import java.util.Date;

public class Shift {
	
	private Integer shift_id;
	private Integer staff_id;
	private Date starttime;
	private Date endtime;
	private Integer user_id;
	private Date time;
	
	public Integer getId(){
		return shift_id;
	}
	
	public void setId(Integer shift_id){
		this.shift_id = shift_id;
	}
	
	public Integer getStaff(){
		return staff_id;
	}
	
	public void setStaff(Integer staff_id){
		this.staff_id = staff_id;
	}
	
	public Date getStarttime(){
		return starttime;
	}
	
	public void setStarttime(Date starttime){
		this.starttime = starttime;
	}
	
	public Date getEndtime(){
		return endtime;
	}
	
	public void setEndtime(Date endtime){
		this.endtime = endtime;
	}
	
	public Integer getUser(){
		return user_id;
	}
	
	public void setUser(Integer user_id){
		this.user_id = user_id;
	}
	
	public Date getTime(){
		return time;
	}
	
	public void setTime(Date time){
		this.time = time;
	}
}