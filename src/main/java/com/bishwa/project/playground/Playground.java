package com.bishwa.project.playground;

import com.bishwa.project.Utils.DateUtils;

import java.util.*;

/**
 * Author: Bishwa
 * Date: 25/01/2021
 * Time: 19:19
 */
public class Playground extends TimerTask {
//    static {
//        System.setProperty("webdriver.chrome.driver", "C:\\apps\\webdriver\\bin\\chromedriver.exe");
//    }

    public static void main(String[] args) {
        Timer timer = new Timer();
//        TimerTask playgroundTask = new Playground();
        System.out.println(DateUtils.getTimeOfDay(1, 18, 30, 0));
    }

    @Override
    public void run() {
        System.out.println("Scheduled task");
    }

    //    private static WebDriver getWebDriver() {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless", "--window-size=1366,768");
//
//        return new ChromeDriver(options);
//    }
}
