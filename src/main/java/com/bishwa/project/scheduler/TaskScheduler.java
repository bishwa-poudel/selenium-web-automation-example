package com.bishwa.project.scheduler;

import com.bishwa.project.Utils.DateUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

import static com.bishwa.project.scheduler.ScheduleConstants.*;


/**
 * Author: Bishwa
 * Date: 30/01/2021
 * Time: 17:59
 */
public class TaskScheduler {
    private static final Logger logger = LogManager.getLogger(CheckOutTimer.class);

    private static Timer timer;
    private static TimerTask checkInTask;
    private static TimerTask checkOutTask;
    private static Date checkInTime;
    private static Date checkOutTime;

    private static void initTimer() {
        timer = new Timer();
        checkInTask = new CheckInTimer();
        checkOutTask = new CheckOutTimer();
    }

    private static void setTimer(Boolean skip) {
        Calendar initDate = new GregorianCalendar();

        if(skip) initDate.add(Calendar.DATE, 1);

        checkInTime = DateUtils.getNextSchedulingTime(initDate, DAY_OFFSET, CHECK_IN_HR, CHECK_IN_OUT_MIN, CHECK_IN_OUT_SEC);
        checkOutTime = DateUtils.getNextSchedulingTime(initDate, DAY_OFFSET, CHECK_OUT_HR, CHECK_IN_OUT_MIN, CHECK_IN_OUT_SEC);
    }

    private static void initScheduler() {
        timer.scheduleAtFixedRate(checkInTask, checkInTime, ONE_DAY_MILIS);
        timer.scheduleAtFixedRate(checkOutTask, checkOutTime, ONE_DAY_MILIS);

        logger.info("[TASK-SCHEDULER] CHECK IN REGISTERED FOR: " + checkInTime);
        logger.info("[TASK-SCHEDULER] CHECK OUT REGISTERED FOR: " + checkOutTime);
    }

    public static void scheduleTimer() {
        initTimer();
        setTimer(false);
        initScheduler();
    }

    public static void rescheduleTimer() {
        stopScheduler();

        initTimer();
        setTimer(true);
        initScheduler();
    }

    public static void stopScheduler() {
        checkInTask.cancel();
        checkOutTask.cancel();

        timer.cancel(); // Terminates this timer, discarding any currently scheduled tasks.
        timer.purge();  // Removes all cancelled tasks from this timer's task queue.

        logger.info("[TASK-SCHEDULER] TASK SCHEDULER STOPPED SUCCESSFULLY");
    }

}
