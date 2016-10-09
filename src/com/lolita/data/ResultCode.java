package com.lolita.data;

public class ResultCode {

	public static Integer SUCCESS = 0; // 成功
	public static Integer UNKNOWN_ERROR = -1;// 未知错误

	// 用户错误码10XXX
	public static Integer USER_ACCOUNT_ERROR = 10001;// 用户账号错误
	public static Integer PASSWORD_ERROR = 10002;// 密码错误
	public static Integer USERTOKEN_ERROR = 10003;// 用户token错误
	public static Integer USERID_ERROR = 10004;// 用户id不存在
	public static Integer USER_ACCOUNT_EXIST = 10005;// 用户账号已被使用
	public static Integer NICKNAME_EXIST = 10006;// 昵称已被使用
	public static Integer TEL_FORMAT_ERROR = 11001;// 手机格式错误
	public static Integer VERIFY_CODE_ERROR = 12001;// 验证码错误
	public static Integer SMS_SERVER_ERROR = 12002;// 验证码平台返回码错误

	// 品牌错误码3XXXX
	public static Integer BRAND_EXIST = 30001;// 品牌已存在
	public static Integer BRAND_NOT_EXIST = 30002;// 品牌不存在
	
	//商品类型错误码4XXXX
	public static Integer TYPE_EXIST = 40001;//商品类型已存在
	public static Integer TYPE_NOT_EXIST = 40002;//商品类型不存在
	
	//会员卡错误码5XXXX

	// 根据resultcode返回错误信息
	public static String getErrmsg(Integer resultCode) {

		String errmsg = "";
		switch (resultCode) {
		case 0:
			errmsg = "success";
			break;
		case -1:
			errmsg = "unknown error";
			break;

		// 用户类
		case 10001:
			errmsg = "invalid account";
			break;
		case 10002:
			errmsg = "wrong password";
			break;
		case 10003:
			errmsg = "invalid token";
			break;
		case 10004:
			errmsg = "invalid user_id";
			break;
		case 10005:
			errmsg = "account used";
			break;
		case 10006:
			errmsg = "nickname used";
			break;
		case 11001:
			errmsg = "phone number error";
			break;
		case 12001:
			errmsg = "verification code error";
			break;
		case 12002:
			errmsg = "sms server error";
			break;

		// 品牌类
		case 30001:
			errmsg = "brand exist";
			break;
		case 30002:
			errmsg = "brand not exist";
			break;
			
		//商品类型类
		case 40001:
			errmsg = "goods type exist";
			break;
		case 40002:
			errmsg = "goods type not exist";
			break;
		}
		return errmsg;
	}
}