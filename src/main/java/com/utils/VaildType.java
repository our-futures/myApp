package com.utils;

import java.util.regex.Pattern;

import com.alibaba.fastjson.JSONObject;



public class VaildType {
	/**
	 * 用户名
	 * //\u4e00-\u9fa5 代表中文，\\w代表英文、数字和“_"，中括号代表其中的任意字符，最后的加号代表至少出现一次。
	 */
	public static final String USER_NAME = "[\u4e00-\u9fa5\\w]{3,8}";
	/**
	 * 手机号码
	 */
	public static final String USER_PHONE ="^(13\\d|14[57]|15[012356789]|18\\d|17[013678])\\d{8}$";
	/**
	 * 邮箱
	 */
	public static final String USER_EMAIL = "\\w+(\\.\\w)*@\\w+(\\.\\w{2,3}){1,3}";
	
	public static  int checkUserType(String name){
		 int flag = 0;
		 Pattern pattern = null;
//		 pattern = Pattern.compile(USER_NAME);
//		 if(pattern.matcher(name).matches()){
//			 flag = 1;
//			 return flag;
//		 }
		 pattern = Pattern.compile(USER_EMAIL);
		 if(pattern.matcher(name).matches()){
			 flag = 2;
			 return flag;
		 }
		 pattern = Pattern.compile(USER_PHONE);
		 if(pattern.matcher(name).matches()){
			 flag = 3;
			 return flag;
		 }
		return flag;
	}
	
	//判断手机号码和邮箱是否正确
	public static JSONObject checkParms(String phone,String email){
		JSONObject result = new JSONObject();
		result.put("flag", true);
		result.put("msg", "");
		Pattern pattern = null;
		pattern = Pattern.compile(USER_PHONE);
		if(!pattern.matcher(phone).matches()){
			result.put("flag", false);
			result.put("msg", "手机格式不正确");
			return result;
		}
		pattern = Pattern.compile(USER_EMAIL);
		if(!pattern.matcher(email).matches()){
			result.put("flag", false);
			result.put("msg", "邮箱格式不正确");
			return result;
		}
		return result;
		
	}
	
	//判断邮箱是否正确
	public static JSONObject checkEmail(String email){
		JSONObject result = new JSONObject();
		result.put("flag", true);
		result.put("msg", "");
		Pattern pattern = Pattern.compile(USER_EMAIL);
		if(!pattern.matcher(email).matches()){
			result.put("flag", false);
			result.put("msg", "邮箱格式不正确");
			return result;
		}
		return result;
		
	}
	
}
