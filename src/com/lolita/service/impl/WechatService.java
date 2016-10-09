package com.lolita.service.impl;

import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lolita.dao.WechatDataMapper;
import com.lolita.data.RandomCode;
import com.lolita.data.ResultCode;
import com.lolita.model.JSApi;
import com.lolita.model.WechatData;
import com.lolita.operate.HttpRequest;
import com.lolita.operate.SHA1_Encode;
import com.lolita.service.IWechatService;

@Service
public class WechatService implements IWechatService {

	@Autowired
	WechatDataMapper wechatDataMapper;

	//珠海源构
	private static String appid = "wxa68b1c4595d634ec";
	private static String secret = "833ed9cbc89833df42faab0254b9bbce";

	// 请求openid
	// https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code
	@Transactional(propagation = Propagation.REQUIRED)
	public String getOpenid(String code) throws JSONException {

		try {

			String str = HttpRequest.sendGet(
					"https://api.weixin.qq.com/sns/oauth2/access_token",
					"appid=" + appid + "&secret=" + secret + "&code=" + code
							+ "&grant_type=authorization_code");
			System.out.println("get openid result: " + str);

			JSONObject result = new JSONObject(str);
			WechatData wechatData = wechatDataMapper
					.getWechatDataByOpenid(result.getString("openid"));
			if (null == wechatData) {
				// 若没有既存结果则新建
				wechatData = new WechatData();
				wechatData.setAccess_Token(result.getString("access_token"));
				wechatData.setCode(code);
				wechatData.setOpenid(result.getString("openid"));
				wechatData.setRefresh_Token(result.getString("refresh_token"));
				wechatData.setIs_Follow(false);

				wechatDataMapper.addOpenid(wechatData);
			} else {
				// 若有既存结果则更新
				wechatData.setAccess_Token(result.getString("access_token"));
				wechatData.setCode(code);
				wechatData.setRefresh_Token(result.getString("refresh_token"));

				wechatDataMapper.updateWechatData(wechatData);
			}

			JSONObject jo = new JSONObject();
			jo.put("resultCode", ResultCode.SUCCESS);
			jo.put("openid", wechatData.getOpenid());
			jo.put("is_follow", wechatData.getIs_Follow());
			return jo.toString();

		} catch (Exception e) {
			e.printStackTrace();
			JSONObject jo = new JSONObject();
			jo.put("resultCode", ResultCode.UNKNOWN_ERROR);
			return jo.toString();
		}
	}

	// 更新关注状态
	@Transactional(propagation = Propagation.REQUIRED)
	public String updateFollowStatus(String openid) throws JSONException {

		try {
			wechatDataMapper.updateFollowStatus(openid);
			JSONObject jo = new JSONObject();
			jo.put("resultCode", ResultCode.SUCCESS);
			return jo.toString();
		} catch (Exception e) {
			e.printStackTrace();
			JSONObject jo = new JSONObject();
			jo.put("resultCode", ResultCode.UNKNOWN_ERROR);
			return jo.toString();
		}
	}

	// 获取微信号的access_token
	public String getAccessToken() {
		try {
			String str = HttpRequest.sendGet(
					"https://api.weixin.qq.com/cgi-bin/token",
					"grant_type=client_credential&appid=" + appid + "&secret="
							+ secret);
			JSONObject result = new JSONObject(str);

			return result.getString("access_token");

		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}	

	// 获取jsapi_ticket
	@Transactional(propagation = Propagation.REQUIRED)
	public String getJsapi_ticket() {

		try {
			Date date = new Date();
			JSApi jsApi = wechatDataMapper.getJSApiData("jsapi_ticket");
			if (date.getTime() - jsApi.getRefreshTime().getTime() < 6000 * 1000) {
				return jsApi.getContent();
			} else {
				String str = HttpRequest.sendGet(
						"https://api.weixin.qq.com/cgi-bin/ticket/getticket",
						"access_token=" + getAccessToken() + "&type=jsapi");
				JSONObject result = new JSONObject(str);

				// if (result.getInt("errcode") == 0) {
				String jsapi_ticket = result.getString("ticket");
				jsApi = new JSApi();
				jsApi.setType("jsapi_ticket");
				jsApi.setContent(jsapi_ticket);
				jsApi.setRefreshTime(date);
				wechatDataMapper.updateJSApiData(jsApi);
				return jsapi_ticket;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	// 构筑签名，并返回对应的随机字符串和时间戳
	@Transactional(propagation = Propagation.REQUIRED)
	public String getSignature(String url) {

		try {
			String origin_str = "";
			Date date = new Date();
			long timestamp = date.getTime();
			timestamp = timestamp / 1000;
			String noncestr = new RandomCode().getNoncestr();
			origin_str = "jsapi_ticket=" + getJsapi_ticket() + "&noncestr="
					+ noncestr + "&timestamp=" + timestamp + "&url=" + url;

			// 进行SHA1加密处理
			String digest = new SHA1_Encode().getDigestOfString(origin_str
					.getBytes());
			digest = digest.toLowerCase();

			// 返回签名JSON
			JSONObject jo = new JSONObject();
			jo.put("resultCode", ResultCode.SUCCESS);
			jo.put("signature", digest);
			jo.put("noncestr", noncestr);
			jo.put("timestamp", timestamp);
			return jo.toString();

		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

}