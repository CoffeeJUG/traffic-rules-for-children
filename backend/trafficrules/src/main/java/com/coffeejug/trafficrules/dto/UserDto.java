package com.coffeejug.trafficrules.dto;

import java.util.UUID;

public class UserDto {

    private UUID uuid;

    private int levelsCompleted;

    private String name;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public void setUuid(String uuid) {
        if (uuid != null) {
            this.uuid = UUID.fromString(uuid);
        }
    }

    public int getLevelsCompleted() {
        return levelsCompleted;
    }

    public void setLevelsCompleted(int levelsCompleted) {
        this.levelsCompleted = levelsCompleted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
