package com.bishwa.project.scheduler;

import com.bishwa.project.lis.service.CheckInOutService;

import java.util.TimerTask;

/**
 * Author: Bishwa
 * Date: 30/01/2021
 * Time: 18:54
 */
public class CheckInTimer extends TimerTask {
    @Override
    public void run() {
        try {
            System.out.println("[CHECKIN-TIMER] Check In LIS Intranet Triggered at : " + System.currentTimeMillis());
            new CheckInOutService().doCheckIn();
        } catch (Exception e) {
            System.out.println("[CHECKIN-TIMER] Exception running Check In Timer");
            e.printStackTrace();
        }

    }
}
