package com.pispower.video.sdk.util;

import java.io.IOException;
import java.util.Properties;

import android.util.Log;

import com.pispower.video.sdk.VideoSDK;

public class PropertiesUtil {

	public static final String PROPERTYS = "videosdk.properties";
	public static final String HOST = "host";
	public static final String ACCESS_KEY = "accessKey";
	public static final String ACCESS_SECRET = "accessSecret";
	
	private static Properties properties;
	private static String Tag = PropertiesUtil.class.getName();
	
	static {
		try {
			properties = new Properties();
			properties.load(VideoSDK.class.getClassLoader().getResourceAsStream(PROPERTYS));
			Log.i(Tag, "Load property file " + PROPERTYS + " success");
		} catch (IOException e) {
			Log.e(Tag, PROPERTYS + " file is missing\n" + e.getMessage());
		}
	}
	
	public static String getHostProperty() {
		return getProperty(HOST);
	}
	
	public static String getAccessKeyProperty() {
		return getProperty(ACCESS_KEY);
	}
	
	public  static String getAccessSecretProperty() {
		return getProperty(ACCESS_SECRET);
	}
	
	private static String getProperty(String key) {
		String val = properties.getProperty(key);
		if (null == val) {
			throw new RuntimeException("Property [" + key + "] is expected in " + PROPERTYS);
		}
		return val.trim();
	}
}