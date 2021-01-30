package com.bishwa.project.intranetfunction.implementation.lisautomateactions;

import com.bishwa.project.intranetfunction.implementation.LisAutomateAction;
import com.bishwa.project.intranetfunction.specification.IWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Author: Bishwa
 * Date: 30/01/2021
 * Time: 15:58
 */
public class CheckInAction extends LisAutomateAction {
    public CheckInAction(IWebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void action() {
        List<WebElement> checkInContainer = driver.findElements(By.xpath("//*[@id=\"check_in \"]"));
        boolean isCheckedIn = checkInContainer.isEmpty();

        if(isCheckedIn) System.out.println("Already checked in");
        else {
            System.out.println("Checking in to LIS Intranet");

            WebElement checkInButton = checkInContainer.get(0);
            checkInButton.click();

            System.out.println("Successfully checked in");
        }
    }
}
