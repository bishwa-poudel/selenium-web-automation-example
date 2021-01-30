package com.bishwa.project.Utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Author: Bishwa
 * Date: 30/01/2021
 * Time: 18:47
 */
public class DateUtils {
    public static Date getTimeOfDay(int dayOffset, int hr, int min, int s) {
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.DATE, dayOffset);
        Calendar checkInTime = new GregorianCalendar(
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DATE),
                hr,
                min,
                s
        );

        return checkInTime.getTime();
    }
}
