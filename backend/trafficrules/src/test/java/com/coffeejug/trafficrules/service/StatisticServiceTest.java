package com.coffeejug.trafficrules.service;

import java.lang.management.RuntimeMXBean;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import com.coffeejug.trafficrules.repository.UserRepository;
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
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StatisticServiceTest {

    @Mock
    private RuntimeMXBean runtimeMXBean;
    @Mock
    private UserService userService;
    @Mock
    private UserRepository userRepository;

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
        assertThat(calledValue).isAfterOrEqualTo(beforeServiceCall.minus(1000L, ChronoUnit.MILLIS));
    }

    @Test
    void shouldReturnAllUsersActiveFromStart() {
        when(runtimeMXBean.getUptime()).thenReturn(27L);
        when(userService.countAllByLastActivityAfter(any())).thenReturn(5L);

        LocalDateTime beforeServiceCall = LocalDateTime.now();

        assertThat(statisticService.usersActiveFromStart()).isEqualTo(5L);

        verify(userService).countAllByLastActivityAfter(localDateTimeArgumentCaptor.capture());
        LocalDateTime calledValue = localDateTimeArgumentCaptor.getValue();
        assertThat(calledValue).isBefore(LocalDateTime.now());
        assertThat(calledValue).isAfterOrEqualTo(beforeServiceCall.minus(27L, ChronoUnit.MILLIS));
    }

    @Test
    void shouldReturnAllUsersActiveLastSeconds() {
        when(userService.countAllByLastActivityAfter(any())).thenReturn(5L);

        LocalDateTime beforeServiceCall = LocalDateTime.now();

        long lastSeconds = 50L;
        assertThat(statisticService.usersActiveLastSeconds(lastSeconds)).isEqualTo(5L);

        verify(userService).countAllByLastActivityAfter(localDateTimeArgumentCaptor.capture());
        LocalDateTime calledValue = localDateTimeArgumentCaptor.getValue();
        assertThat(calledValue).isBefore(LocalDateTime.now());
        assertThat(calledValue).isAfterOrEqualTo(beforeServiceCall.minus(lastSeconds, ChronoUnit.SECONDS));
    }

}