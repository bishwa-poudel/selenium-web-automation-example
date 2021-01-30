package com.bishwa.project.scheduler;

import com.bishwa.project.Utils.DateUtils;

import java.util.*;

/**
 * Author: Bishwa
 * Date: 30/01/2021
 * Time: 17:59
 */
public class TaskScheduler {
    private final static int ONE_DAY = 1;
    private final static int CHECK_IN_HR = 9;
    private final static int CHECK_IN_OUT_MIN = 30;
    private final static int CHECK_IN_OUT_SEC = 0;
    private final static int CHECK_OUT_HR = 5;
    private final static long ONE_DAY_MILIS = 60*60*24*1000;

    private final Timer timer = new Timer();
    private final TimerTask checkInTask = new CheckInTimer();
    private final TimerTask checkOutTask = new CheckOutTimer();
    private final Date checkInTime = DateUtils.getTimeOfDay(ONE_DAY, CHECK_IN_HR, CHECK_IN_OUT_MIN, CHECK_IN_OUT_SEC);
    private final Date checkOutTime = DateUtils.getTimeOfDay(ONE_DAY, CHECK_OUT_HR, CHECK_IN_OUT_MIN, CHECK_IN_OUT_SEC);


    public void initScheduler() {
        timer.scheduleAtFixedRate(checkInTask, checkInTime, ONE_DAY_MILIS);
        timer.scheduleAtFixedRate(checkOutTask, checkOutTime, ONE_DAY_MILIS);
        System.out.println("[TASK-SCHEDULER] TASK SCHEDULER STARTED SUCCESSFULLY");
    }

}
