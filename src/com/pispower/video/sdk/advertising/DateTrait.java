//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pispower.video.sdk.advertising;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTrait {
    public static final String FORMAT_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public DateTrait() {
    }

    public String dateToString(Date date) {
        return this.getFormat().format(date);
    }

    public Date stringToDate(String str) throws ParseException {
        return this.getFormat().parse(str);
    }

    private SimpleDateFormat getFormat() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
}
