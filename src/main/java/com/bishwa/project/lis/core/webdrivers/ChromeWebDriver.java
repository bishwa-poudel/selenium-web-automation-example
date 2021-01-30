package com.bishwa.project.lis.core.webdrivers;

import com.bishwa.project.lis.core.specification.IWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Author: Bishwa
 * Date: 30/01/2021
 * Time: 15:12
 */
public class ChromeWebDriver implements IWebDriver {
    private static final WebDriver chromeDriver;
    private static final String DRIVER_PATH = "C:\\apps\\webdriver\\bin\\chromedriver.exe";

    static {
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless", "--window-size=1366,768");

        chromeDriver = new ChromeDriver(options);
    }

    @Override
    public WebDriver getDriver() {
        return chromeDriver;
    }
}
