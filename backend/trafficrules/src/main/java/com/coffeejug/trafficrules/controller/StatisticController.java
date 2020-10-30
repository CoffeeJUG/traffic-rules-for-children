package com.coffeejug.trafficrules.controller;

import com.coffeejug.trafficrules.service.StatisticService;
import com.coffeejug.trafficrules.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/statistics")
public class StatisticController {

    private final StatisticService statisticService;
    private final UserService userService;

    @Autowired
    public StatisticController(StatisticService statisticService, UserService userService) {
        this.statisticService = statisticService;
        this.userService = userService;
    }

    @GetMapping("/uptime")
    public long getUptime() {
        return statisticService.getUptime();
    }

    @GetMapping("/users/total")
    public long totalUsers() {
        return userService.count();
    }

    @GetMapping("/users/registered-from-start")
    public long usersRegisteredFromStart() {
        return statisticService.usersRegisteredFromStart();
    }


    @GetMapping("/users/active-from-start")
    public long usersActiveFromStart() {
        return statisticService.usersActiveFromStart();
    }

    @GetMapping("/users/active")
    public long usersActive(@RequestParam(value = "lastSeconds", required = false, defaultValue = "600") long lastSeconds) {
        return statisticService.usersActiveLastSeconds(lastSeconds);
    }

}
