package com.bishwa.project.playground;

import com.bishwa.project.Utils.DateUtils;

import java.time.*;
import java.util.*;

/**
 * Author: Bishwa
 * Date: 25/01/2021
 * Time: 19:19
 */
public class Playground extends TimerTask {

    public static void main(String[] args) {
//        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
//
//        LocalDateTime currentDateTime = zonedDateTime.toLocalDateTime();
//
//        System.out.println(Date.from(currentDateTime.toInstant(ZoneOffset.of("+06:45"))));

//        Clock clock = Clock.tick(Clock.system(ZoneId.of("Asia/Kolkata")), Duration.ofSeconds(1));
//        LocalDateTime dateTime = LocalDateTime.now(clock);
//
//
//        System.out.println(Date.from(dateTime.toInstant(ZoneOffset.of("+05:30"))));

//        System.setProperty("user.timezone", "Asia/Kolkata");
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));

//        Instant currentTimeMilis = Instant.now();
//
//        ZoneId zoneId = ZoneId.of("Asia/Kolkata");
//        ZonedDateTime zdt = ZonedDateTime.ofInstant(currentTimeMilis, zoneId);
//
//        System.out.println(zdt.toLocalDateTime());

        System.out.println(LocalDateTime.now());

    }

    @Override
    public void run() {
        System.out.println("Scheduled task");
    }

}
