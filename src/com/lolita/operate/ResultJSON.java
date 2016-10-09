package com.lolita.operate;

import org.json.JSONObject;

import com.lolita.data.ResultCode;

public class ResultJSON {
	
	//创建结果JSON
	public JSONObject createResultJSON(Integer resultCode){
		
		JSONObject jo = new JSONObject();
		try {
			jo.put("resultCode", resultCode);
			jo.put("errmsg", ResultCode.getErrmsg(resultCode));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jo;
	}
}