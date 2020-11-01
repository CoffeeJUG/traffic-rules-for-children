package com.coffeejug.trafficrules.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StatisticServiceTest {

    private final StatisticService statisticService;

    @Autowired
    StatisticServiceTest(StatisticService statisticService) {
        this.statisticService = statisticService;
    }


    @Test
    void getUptimeTest() {

        Long start = statisticService.getUptime();
        Long end = null;
        try {
            Thread.sleep(1000);
            end = statisticService.getUptime();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        assertThat(end - 1100L).isLessThan(start);
//        assertThat(end - 900L).isGreaterThan(start);
    }

}