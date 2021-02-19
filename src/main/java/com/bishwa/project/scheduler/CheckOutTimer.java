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
public class CheckOutTimer extends TimerTask {
    private static final Logger logger = LogManager.getLogger(CheckOutTimer.class);

    @Override
    public void run() {
        try {
            logger.info("[CHECKOUT-TIMER] Check Out Intranet Triggered at : " + System.currentTimeMillis());
            new CheckInOutService().doCheckOut();
        } catch (Exception e) {
            logger.error("[CHECKOUT-TIMER] Exception running Check Out Timer");
            e.printStackTrace();
        }

    }
}
