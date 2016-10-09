package com.lolita.model;

import java.util.Date;

public class JSApi {
	
	private String type;
	private String content;
	private Date refresh_time;
	
	public String getType(){
		return type;
	}
	
	public void setType(String type){
		this.type = type == null ? null :type.trim();
	}
	
	public String getContent(){
		return content;
	}
	
	public void setContent(String content){
		this.content = content == null ? null : content.trim();
	}
	
	public Date getRefreshTime(){
		return refresh_time;
	}
	
	public void setRefreshTime(Date refresh_time){
		this.refresh_time = refresh_time;
	}
	
}