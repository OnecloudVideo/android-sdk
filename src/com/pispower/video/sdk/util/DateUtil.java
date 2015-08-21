package com.pispower.video.sdk.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static final String FORMAT_PATTERN = "yyyy-MM-dd HH:mm:ss";
	
    public static String dateToString(Date date) {
        return getFormat().format(date);
    }

    public static Date stringToDate(String str) throws ParseException {
        return getFormat().parse(str);
    }
    
    public static SimpleDateFormat getFormat() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
}
