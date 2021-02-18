package com.bishwa.project.lis.core.lisautomateactions;

import com.bishwa.project.lis.core.specification.IDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Author: Bishwa
 * Date: 30/01/2021
 * Time: 15:58
 */
public class CheckOutAction extends LisAutomateAction {
    private static final Logger logger = LogManager.getLogger(CheckOutAction.class);

    public CheckOutAction(IDriverManager webDriver) {
        super(webDriver);
    }

    @Override
    public void action() {
        List<WebElement> checkInContainer = driver.findElements(By.xpath("//*[@id=\"check_in \"]"));
        boolean isCheckedIn = checkInContainer.isEmpty();

        if (isCheckedIn) {
            List<WebElement> checkOutContainer = driver.findElements(By.id("check_out"));
            if (checkOutContainer.isEmpty()) logger.info("Already checked out of Intranet");
            else {
                logger.info("Checking out from LIS Intranet");

                WebElement checkOutButton = checkOutContainer.get(0);
                checkOutButton.click();

                new WebDriverWait(driver, 1).until(ExpectedConditions.alertIsPresent());

                Alert checkOutConfirmationAlert = driver.switchTo().alert();
                checkOutConfirmationAlert.accept();

                logger.info("Successfully checked out at : " + System.currentTimeMillis());
            }
        } else logger.error("Trying to check out without checked in");
    }
}
