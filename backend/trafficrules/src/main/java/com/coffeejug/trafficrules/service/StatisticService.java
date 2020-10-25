package com.coffeejug.trafficrules.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.management.RuntimeMXBean;

@Service
public class StatisticService {

    @Autowired
    private RuntimeMXBean runtimeMXBean;

    public long getUptime() {
        return runtimeMXBean.getUptime();
    }
}
