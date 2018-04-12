package com.sid.vocabulary.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created 2018/4/12.
 *
 * @author HongTao
 */

public class DateUtil {
    private static final String DATE_FORMAT = "yyyy-M-dd";

    public static String getFormatDateString(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
        return simpleDateFormat.format(date);
    }
}
