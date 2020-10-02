package com.coffeejug.trafficrules.service;

import org.springframework.stereotype.Service;

import java.lang.management.ManagementFactory;

@Service
public class StatisticService {

    public long getUptime() {
        return ManagementFactory.getRuntimeMXBean().getUptime();
    }
}
