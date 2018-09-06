package com.bmt.zicreative.maidas.Utils;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created By Herwin DJ on 9/6/2018
 **/

public class DateConverterUtils {
    public static Date standartDateFormatter(String stringDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date d = sdf.parse(stringDate, new ParsePosition(0));
        return d;
    }
}
