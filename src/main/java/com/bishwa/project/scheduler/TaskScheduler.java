package com.bishwa.project.scheduler;

import com.bishwa.project.Utils.DateUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

/**
 * Author: Bishwa
 * Date: 30/01/2021
 * Time: 17:59
 */
public class TaskScheduler {
    private static final Logger logger = LogManager.getLogger(CheckOutTimer.class);

    private final static int DAY_OFFSET = 1;
    private final static int CHECK_IN_HR = 9;
    private final static int CHECK_IN_OUT_MIN = 30;
    private final static int CHECK_IN_OUT_SEC = 0;
    private final static int CHECK_OUT_HR = 17;
    private final static long ONE_DAY_MILIS = 60*60*24*1000;

    private final Timer timer = new Timer();
    private final TimerTask checkInTask = new CheckInTimer();
    private final TimerTask checkOutTask = new CheckOutTimer();
    private final Date checkInTime = DateUtils.getNextSchedulingTime(DAY_OFFSET, CHECK_IN_HR, CHECK_IN_OUT_MIN, CHECK_IN_OUT_SEC);
    private final Date checkOutTime = DateUtils.getNextSchedulingTime(DAY_OFFSET, CHECK_OUT_HR, CHECK_IN_OUT_MIN, CHECK_IN_OUT_SEC);


    public void initScheduler() {
        timer.scheduleAtFixedRate(checkInTask, checkInTime, ONE_DAY_MILIS);
        timer.scheduleAtFixedRate(checkOutTask, checkOutTime, ONE_DAY_MILIS);

        logger.info("[TASK-SCHEDULER] CHECK IN REGISTERED FOR: " + checkInTime);
        logger.info("[TASK-SCHEDULER] CHECK OUT REGISTERED FOR: " + checkOutTime);
    }

    public void stopScheduler() {
        checkInTask.cancel();
        checkOutTask.cancel();

        timer.cancel(); // Terminates this timer, discarding any currently scheduled tasks.
        timer.purge();  // Removes all cancelled tasks from this timer's task queue.

        logger.info("[TASK-SCHEDULER] TASK SCHEDULER STOPPED SUCCESSFULLY");
    }

}
