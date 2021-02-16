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
    public static Date getNextSchedulingTime(int dayOffset, int hr, int min, int s) {
        Calendar currentDate = new GregorianCalendar();
        Calendar todayScheduledDate  = new GregorianCalendar(
                currentDate.get(Calendar.YEAR),
                currentDate.get(Calendar.MONTH),
                currentDate.get(Calendar.DATE),
                hr,
                min,
                s
                );

        if(currentDate.before(todayScheduledDate)) return todayScheduledDate.getTime();

        todayScheduledDate.add(Calendar.DATE, dayOffset);

        return todayScheduledDate.getTime();
    }
}
