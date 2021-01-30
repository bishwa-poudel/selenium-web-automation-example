package com.bishwa.project.intranetfunction.service;

import com.bishwa.project.intranetfunction.implementation.ChromeWebDriver;
import com.bishwa.project.intranetfunction.implementation.LisAutomateAction;
import com.bishwa.project.intranetfunction.implementation.lisautomateactions.CheckInAction;
import com.bishwa.project.intranetfunction.implementation.lisautomateactions.CheckOutAction;

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
