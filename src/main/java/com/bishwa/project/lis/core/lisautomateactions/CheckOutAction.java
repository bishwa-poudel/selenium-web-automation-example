package com.bishwa.project.lis.core.lisautomateactions;

import com.bishwa.project.lis.core.specification.IDriverManager;
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
    public CheckOutAction(IDriverManager webDriver) {
        super(webDriver);
    }

    @Override
    public void action() {
        List<WebElement> checkInContainer = driver.findElements(By.xpath("//*[@id=\"check_in \"]"));
        boolean isCheckedIn = checkInContainer.isEmpty();

        if (isCheckedIn) {
            List<WebElement> checkOutContainer = driver.findElements(By.id("check_out"));
            if (checkOutContainer.isEmpty()) System.out.println("Already checked out of Intranet");
            else {
                System.out.println("Checking out from LIS Intranet");

                WebElement checkOutButton = checkOutContainer.get(0);
                checkOutButton.click();

                new WebDriverWait(driver, 1).until(ExpectedConditions.alertIsPresent());

                Alert checkOutConfirmationAlert = driver.switchTo().alert();
                checkOutConfirmationAlert.accept();

                System.out.println("Successfully checked out");
            }
        }
    }
}
