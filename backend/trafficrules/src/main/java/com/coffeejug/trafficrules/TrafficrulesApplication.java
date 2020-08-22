package com.coffeejug.trafficrules;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TrafficrulesApplication {

    private static final Logger logger = LoggerFactory.getLogger(TrafficrulesApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(TrafficrulesApplication.class, args);
        System.out.println("Started...");
        logger.warn("Started...");
    }

}