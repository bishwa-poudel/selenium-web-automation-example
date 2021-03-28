package com.bishwa.project;

import com.bishwa.project.lis.core.specification.IDriverManager;
import com.bishwa.project.lis.core.webdrivers.ChromeDriverManager;
import com.bishwa.project.scheduler.CheckOutTimer;
import com.bishwa.project.scheduler.TaskScheduler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.TimeZone;

/**
 * Author: Bishwa
 * Date: 30/01/2021
 * Time: 19:31
 */
@WebListener
public class RequestListener implements ServletContextListener {
    private static final Logger logger = LogManager.getLogger(CheckOutTimer.class);

    // initializing class will initialize static values once, thereby initializes chrome driver.
    private final IDriverManager driverManager = new ChromeDriverManager();

    static {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kathmandu"));
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("SERVER STARTED SUCCESSFULLY");
        logger.info("RUNNING POST DEPLOYMENT HOOKS");

        TaskScheduler.scheduleTimer();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("[CONTEXT-DESTROYED] SERVER STOP SIGNAL RECEIVED");

        TaskScheduler.stopScheduler();
        driverManager.tearDown();
    }
}
