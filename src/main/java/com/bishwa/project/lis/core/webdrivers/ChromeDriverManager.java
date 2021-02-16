package com.bishwa.project.lis.core.webdrivers;

import com.bishwa.project.lis.core.specification.IDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Author: Bishwa
 * Date: 16/02/2021
 * Time: 10:14
 */
public class ChromeDriverManager extends IDriverManager {

    @Override
    protected void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @Override
    protected void initDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--window-size=1366,768");

        webDriver = new ChromeDriver(options);
    }
}
