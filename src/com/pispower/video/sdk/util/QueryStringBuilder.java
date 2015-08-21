package com.pispower.video.sdk.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

import android.util.Log;

public class QueryStringBuilder {
	public static final String GET_PREFIX = "get";

	public QueryString build(Object request) {
		Method[] methods = request.getClass().getMethods();
		QueryString qs = new QueryString();

		for (Method method : methods) {

			if (isFielGetdMethod(method)) {
				try {
					String fieldName = getGetMethodField(method);
					Object fieldValue = method.invoke(request);
					if (null == fieldValue) {
						continue;
					}
					
					String fieldValueString;
					if(fieldValue.getClass().isArray()) {
						fieldValueString = Arrays.toString((Object[]) fieldValue);
					} else if (fieldValue instanceof Date) {
						fieldValueString = DateUtil.dateToString((Date) fieldValue);
					} else {
						fieldValueString = "" + fieldValue;
					}

					qs.addParam(fieldName, fieldValueString);
				} catch (IllegalAccessException | IllegalArgumentException
						| InvocationTargetException e) {

					Log.w(getClass().getName(),
							"append field to query string from method"
									+ getMethodName(method) + " fail for "
									+ e.getMessage());
				}
				;
			}
		}

		return qs;
	}

	private boolean isFielGetdMethod(Method method) {
		if (!isGetMethod(method)) {
			return false;
		}

		String fieldName = getGetMethodField(method);
		@SuppressWarnings("rawtypes")
		Class clz = method.getDeclaringClass();
		
		try {
			
			clz.getDeclaredField(fieldName);
			return true;
		} catch (SecurityException | NoSuchFieldException e) {
			try {
				clz.getField(fieldName);
				return true;
			} catch (NoSuchFieldException | SecurityException e1) {
			}
		}
		
		return false;
	}

	private String getGetMethodField(Method method) {
		return getGetMethodField(getMethodName(method));
	}

	private String getGetMethodField(String methodName) {
		String str = methodName.substring(GET_PREFIX.length());
		// lower first char

		return str.substring(0, 1).toLowerCase() + str.substring(1);
	}

	private boolean isGetMethod(Method method) {
		return getMethodName(method).startsWith(GET_PREFIX);
	}

	private String getMethodName(Method method) {
		return method.getName();
	}
}
