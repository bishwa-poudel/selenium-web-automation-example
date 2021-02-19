package com.bishwa.project.lis.service;

import com.bishwa.project.lis.core.lisautomateactions.LisAutomateAction;
import com.bishwa.project.lis.core.lisautomateactions.CheckInAction;
import com.bishwa.project.lis.core.lisautomateactions.CheckOutAction;
import com.bishwa.project.lis.core.lisautomateactions.LoginAction;
import com.bishwa.project.lis.core.webdrivers.ChromeDriverManager;

/**
 * Author: Bishwa
 * Date: 30/01/2021
 * Time: 13:13
 */
public class CheckInOutService {
    public void doLogin() {
        LisAutomateAction loginAction = new LoginAction(new ChromeDriverManager());
        loginAction.execute();
    }

    public void doCheckIn() {
        LisAutomateAction checkInAction = new CheckInAction(new ChromeDriverManager());
        checkInAction.execute();
    }

    public void doCheckOut() {
        LisAutomateAction checkOutAction = new CheckOutAction(new ChromeDriverManager());
        checkOutAction.execute();
    }
}
