package com.bishwa.project.lis.core.lisautomateactions;

import com.bishwa.project.lis.core.specification.IDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Author: Bishwa
 * Date: 30/01/2021
 * Time: 15:58
 */
public class CheckInAction extends LisAutomateAction {
    private static final Logger logger = LogManager.getLogger(CheckInAction.class);

    public CheckInAction(IDriverManager webDriver) {
        super(webDriver);
    }

    @Override
    public void action() {
        List<WebElement> checkInContainer = driver.findElements(By.xpath("//*[@id=\"check_in \"]"));
        boolean isCheckedIn = checkInContainer.isEmpty();

        if(isCheckedIn) logger.info("Already checked in");
        else {
            logger.info("Checking in to LIS Intranet");

            WebElement checkInButton = checkInContainer.get(0);
            checkInButton.click();

            logger.info("Successfully checked in at : " + System.currentTimeMillis());
        }
    }
}
