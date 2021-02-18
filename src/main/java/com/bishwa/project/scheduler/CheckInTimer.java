package com.bishwa.project.scheduler;

import com.bishwa.project.lis.service.CheckInOutService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.TimerTask;

/**
 * Author: Bishwa
 * Date: 30/01/2021
 * Time: 18:54
 */
public class CheckInTimer extends TimerTask {
    private static final Logger logger = LogManager.getLogger(CheckInTimer.class);

    @Override
    public void run() {
        try {
            logger.info("[CHECKIN-TIMER] Check In LIS Intranet Triggered at : " + System.currentTimeMillis());
            new CheckInOutService().doCheckIn();
        } catch (Exception e) {
            logger.error("[CHECKIN-TIMER] Exception running Check In Timer");
            e.printStackTrace();
        }

    }
}
