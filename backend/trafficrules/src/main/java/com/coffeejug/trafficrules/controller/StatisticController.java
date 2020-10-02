package com.coffeejug.trafficrules.controller;

import com.coffeejug.trafficrules.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/statistic")
public class StatisticController {

    @Autowired
    private StatisticService statisticService;

    @GetMapping("/uptime")
    public long getUptime() {
        return statisticService.getUptime();
    }
}
