package com.bishwa.project.scheduler;

import com.bishwa.project.lis.service.CheckInOutService;

import java.util.TimerTask;

/**
 * Author: Bishwa
 * Date: 30/01/2021
 * Time: 18:54
 */
public class CheckOutTimer extends TimerTask {
    @Override
    public void run() {
        try {
            System.out.println("[CHECKOUT-TIMER] Check Out LIS Intranet Triggered");
            new CheckInOutService().doCheckOut();
        } catch (Exception e) {
            System.out.println("[CHECKOUT-TIMER] Exception running Check Out Timer");
            e.printStackTrace();
        }

    }
}
