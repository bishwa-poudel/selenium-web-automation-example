package com.bishwa.project.playground;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Author: Bishwa
 * Date: 25/01/2021
 * Time: 19:19
 */
public class SeleniumTest {
//    static {
//        System.setProperty("webdriver.chrome.driver", "C:\\apps\\webdriver\\bin\\chromedriver.exe");
//    }

    public static void main(String[] args) throws InterruptedException {
//        WebDriver driver = getWebDriver();

//        try {
//            Long startTime = System.currentTimeMillis();
//
//            driver.get("http://intranet.lisnepal.com.np/");
//
//            WebElement userField = driver.findElement(By.id("usr-name"));
//            WebElement passwordField = driver.findElement(By.id("usr-password"));
//            WebElement submitButton = driver.findElement(By.className("login-btn"));
//
//            userField.sendKeys("bishwa.poudel");
//            passwordField.sendKeys("LuPmDZ5RbUKaDBD");
//            submitButton.click();
//
//            System.out.println("Logged in to LIS Intranet");
//
//            driver.get("http://login.lisnepal.com.np/home/");
//
//            new WebDriverWait(driver, 1)
//                    .until(ExpectedConditions.visibilityOf(driver.findElement(By.className("user-name-top"))));
//
//            List<WebElement> checkInContainer = driver.findElements(By.xpath("//*[@id=\"check_in \"]"));
//            boolean isCheckedIn = checkInContainer.isEmpty();
//
//            if(isCheckedIn) {
//
//                List<WebElement> checkOutContainer = driver.findElements(By.id("check_out"));
//                if(checkOutContainer.isEmpty()) System.out.println("Already checked out of Intranet");
//                else {
//                    System.out.println("Checking out from LIS Intranet");
//
//                    WebElement checkOutButton = checkOutContainer.get(0);
//                    checkOutButton.click();
//
//                    new WebDriverWait(driver, 1).until(ExpectedConditions.alertIsPresent());
//
//                    Alert checkOutConfirmationAlert = driver.switchTo().alert();
//                    checkOutConfirmationAlert.accept();
//
//                    System.out.println("Successfully checked out");
//                }
//
//            }else {
//                System.out.println("Checking in to LIS Intranet");
//
//                WebElement checkInButton = checkInContainer.get(0);
//                checkInButton.click();
//
//                System.out.println("Successfully checked in");
//            }
//
//            Long stopTime = System.currentTimeMillis();
//
//            System.out.println("Execution time: " + (stopTime - startTime) + "ms");

//        } finally {
//            Thread.sleep(10000);
//            driver.quit();
//        }
    }

//    private static WebDriver getWebDriver() {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless", "--window-size=1366,768");
//
//        return new ChromeDriver(options);
//    }
}
