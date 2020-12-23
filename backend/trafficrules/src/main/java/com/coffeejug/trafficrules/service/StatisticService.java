package com.coffeejug.trafficrules.service;

import java.lang.management.RuntimeMXBean;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import org.springframework.stereotype.Service;

@Service
public class StatisticService {

    private final RuntimeMXBean runtimeMXBean;
    private final UserService userService;

    public StatisticService(RuntimeMXBean runtimeMXBean, UserService userService) {
        this.runtimeMXBean = runtimeMXBean;
        this.userService = userService;
    }

    public long uptime() {
        return runtimeMXBean.getUptime();
    }

    public long usersRegisteredFromStart() {
        return userService.countAllByRegisteredAfter(LocalDateTime.now().minus(uptime(), ChronoUnit.MILLIS));
    }

    public long usersActiveFromStart() {
        return userService.countAllByLastActivityAfter(LocalDateTime.now().minus(uptime(), ChronoUnit.MILLIS));
    }

    public long usersActiveLastSeconds(long lastSeconds) {
        return userService.countAllByLastActivityAfter(LocalDateTime.now().minusSeconds(lastSeconds));
    }
}
