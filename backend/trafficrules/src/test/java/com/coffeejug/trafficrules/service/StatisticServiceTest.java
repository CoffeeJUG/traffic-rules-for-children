package com.coffeejug.trafficrules.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class StatisticServiceTest {

    @Mock
    private StatisticService statisticService;

    @Test
    void shouldReturnZero() {

        Long start = statisticService.getUptime();
        assertThat(start).isEqualTo(0L);
        Long end = null;
        try {
            Thread.sleep(1000);
            end = statisticService.getUptime();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertThat(end).isEqualTo(0L);
    }

}