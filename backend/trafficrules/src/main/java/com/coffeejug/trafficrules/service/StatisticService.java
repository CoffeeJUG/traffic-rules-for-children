package com.coffeejug.trafficrules.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.management.RuntimeMXBean;
import java.time.LocalDateTime;

@Service
public class StatisticService {

    @Autowired
    private RuntimeMXBean runtimeMXBean;
    @Autowired
    private UserService userService;

    public long getUptime() {
        return runtimeMXBean.getUptime();
    }

    public long usersRegisteredFromStart() {

        long upTime = getUptime();
        return userService.countAllByRegisteredAfter(LocalDateTime.now().minusSeconds(upTime / 1000));
    }

    public long usersActiveFromStart() {

        long upTime = getUptime();
        return userService.countAllByLastActivityAfter(LocalDateTime.now().minusSeconds(upTime / 1000));
    }

    public long usersActiveLastSeconds(long lastSeconds) {
        return userService.countAllByLastActivityAfter(LocalDateTime.now().minusSeconds(lastSeconds));
    }
}
