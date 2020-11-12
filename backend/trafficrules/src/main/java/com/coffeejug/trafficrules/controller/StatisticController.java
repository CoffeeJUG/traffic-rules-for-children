package com.coffeejug.trafficrules.controller;

import com.coffeejug.trafficrules.exception.BadRequestException;
import com.coffeejug.trafficrules.service.StatisticService;
import com.coffeejug.trafficrules.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/api/v1/statistics")
public class StatisticController {

    private static final List<String> ALLOWED_TYPES = Arrays.asList(
            "TOTAL", "REGISTERED-FROM-START", "ACTIVE-FROM-START", "ACTIVE");
    private final StatisticService statisticService;
    private final UserService userService;

    @Autowired
    public StatisticController(StatisticService statisticService, UserService userService) {
        this.statisticService = statisticService;
        this.userService = userService;
    }

    @GetMapping("/uptime")
    public long getUptime() {
        return statisticService.uptime();
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

    @GetMapping("/users")
    public long users(@RequestParam("type") String type,
                      @RequestParam(value = "lastSeconds", required = false, defaultValue = "600") long lastSeconds) {

        if (type == null || !ALLOWED_TYPES.contains(type.toUpperCase())) {
            throw new BadRequestException("Wrong type");
        }

        long result;
        switch (type.toUpperCase()) {
            case "TOTAL":
                result = userService.count();
                break;
            case "REGISTERED-FROM-START":
                result = statisticService.usersRegisteredFromStart();
                break;
            case "ACTIVE-FROM-START":
                result = statisticService.usersActiveFromStart();
                break;
            case "ACTIVE":
                result = statisticService.usersActiveLastSeconds(lastSeconds);
                break;
            default:
                throw new BadRequestException("Not configured");
        }

        return result;
    }
}
