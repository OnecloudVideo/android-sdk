package com.pispower.video.sdk.util;


public class StatusTransition {
	
	public static final String PROCESSING = "PROCESSING";
	public static final String AUDIT_SUCCESS = "AUDIT_SUCCESS";
	public static final String AUDIT_FAIL = "AUDIT_FAIL";
	public static final String UNAUDIT = "UNAUDIT";
	public static final String FAIL = "FAIL";
	
	public static String toChinese(String status) {
		if(status.equals("PROCESSING")) {
			return "处理中";
		}
		if(status.equals("AUDIT_SUCCESS")){
			return "可发布";
		}
		if(status.equals("AUDIT_FAIL")){
			return "禁播";
		}
		if(status.equals("UNAUDIT")){
			return "未审核";
		}
		if(status.equals("FAIL")){
			return "转码失败";
		}
		
		return "未知";
	}

}
