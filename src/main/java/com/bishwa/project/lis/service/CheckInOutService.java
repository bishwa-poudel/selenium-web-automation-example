package com.bishwa.project.lis.service;

import com.bishwa.project.lis.core.webdrivers.ChromeWebDriver;
import com.bishwa.project.lis.core.lisautomateactions.LisAutomateAction;
import com.bishwa.project.lis.core.lisautomateactions.CheckInAction;
import com.bishwa.project.lis.core.lisautomateactions.CheckOutAction;

/**
 * Author: Bishwa
 * Date: 30/01/2021
 * Time: 13:13
 */
public class CheckInOutService {
    public void doCheckIn() {
        LisAutomateAction checkInAction = new CheckInAction(new ChromeWebDriver());
        checkInAction.execute();
    }

    public void doCheckOut() {
        LisAutomateAction checkOutAction = new CheckOutAction(new ChromeWebDriver());
        checkOutAction.execute();
    }
}
