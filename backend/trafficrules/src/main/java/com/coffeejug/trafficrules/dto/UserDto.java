package com.coffeejug.trafficrules.dto;

public class UserDto {

    private String uuid;

    public UserDto(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
