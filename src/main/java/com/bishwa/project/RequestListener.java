package com.bishwa.project;

import com.bishwa.project.lis.core.webdrivers.ChromeWebDriver;
import com.bishwa.project.scheduler.TaskScheduler;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Author: Bishwa
 * Date: 30/01/2021
 * Time: 19:31
 */
@WebListener
public class RequestListener implements ServletContextListener {
    private final TaskScheduler taskScheduler = new TaskScheduler();

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("SERVER STARTED SUCCESSFULLY");
        System.out.println("RUNNING POST DEPLOYMENT HOOKS");

        taskScheduler.initScheduler();
        new ChromeWebDriver(); // initializing class will initialize static values once, thereby initializes chrome driver.
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("[CONTEXT-DESTROYED] SERVER STOP SIGNAL RECEIVED");
        taskScheduler.stopScheduler();
    }
}
