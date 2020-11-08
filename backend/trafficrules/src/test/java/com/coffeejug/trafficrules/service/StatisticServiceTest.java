package com.coffeejug.trafficrules.service;

import java.lang.management.RuntimeMXBean;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StatisticServiceTest {

    @Mock
    private RuntimeMXBean runtimeMXBean;
    @Mock
    private UserService userService;

    @InjectMocks
    private StatisticService statisticService;

    @Captor
    private ArgumentCaptor<LocalDateTime> localDateTimeArgumentCaptor;

    @Test
    void shouldReturnCorrectUptime() {
        when(runtimeMXBean.getUptime()).thenReturn(42L);
        assertThat(statisticService.uptime()).isEqualTo(42L);
    }

    @Test
    void shouldReturnAllUsersActiveFromStart() {
        when(runtimeMXBean.getUptime()).thenReturn(27L);
        when(userService.countAllByLastActivityAfter(any())).thenReturn(5L);
        assertThat(statisticService.usersActiveFromStart()).isEqualTo(5L);
    }

    @Test
    void shouldThrowExceptionWhenNoUptimeAvailable() {
        when(runtimeMXBean.getUptime()).thenThrow(new RuntimeException("Something goes wrong"));
        assertThatThrownBy(() -> statisticService.uptime())
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Something goes wrong");
    }

    @Test
    void shouldReturnAllUsersRegisteredFromStart() {
        when(runtimeMXBean.getUptime()).thenReturn(1000L);
        when(userService.countAllByRegisteredAfter(any())).thenReturn(15L);

        LocalDateTime beforeServiceCall = LocalDateTime.now();

        assertThat(statisticService.usersRegisteredFromStart()).isEqualTo(15L);

        verify(userService).countAllByRegisteredAfter(localDateTimeArgumentCaptor.capture());
        LocalDateTime calledValue = localDateTimeArgumentCaptor.getValue();
        assertThat(calledValue).isBefore(LocalDateTime.now());
        assertThat(calledValue).isAfterOrEqualTo(beforeServiceCall.minus(1000, ChronoUnit.MILLIS));
    }
}