package com.coffeejug.trafficrules.dto;

public class UserStatisticDto {

    private final long total;
    private final long registeredFromStart;
    private final long activeFromStart;
    private final long active;

    public UserStatisticDto(long total, long registeredFromStart, long activeFromStart, long active) {
        this.total = total;
        this.registeredFromStart = registeredFromStart;
        this.activeFromStart = activeFromStart;
        this.active = active;
    }

    public UserStatisticDto() {
        total = 0;
        registeredFromStart = 0;
        activeFromStart = 0;
        active = 0;
    }

    public long getTotal() {
        return total;
    }

    public long getRegisteredFromStart() {
        return registeredFromStart;
    }

    public long getActiveFromStart() {
        return activeFromStart;
    }

    public long getActive() {
        return active;
    }
}
