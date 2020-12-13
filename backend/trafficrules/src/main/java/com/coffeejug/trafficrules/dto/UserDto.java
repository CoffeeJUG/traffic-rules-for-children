package com.coffeejug.trafficrules.dto;

import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

    private UUID uuid;
    private int levelsCompleted;
    private String name;
    private String email;

    public UserDto(UUID uuid, int levelsCompleted, String name) {
        this.uuid = uuid;
        this.levelsCompleted = levelsCompleted;
        this.name = name;
    }

    public UserDto() {
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public void setUuid(String uuid) {
        Objects.requireNonNull(uuid);
        this.uuid = UUID.fromString(uuid);
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return levelsCompleted == userDto.levelsCompleted &&
                Objects.equals(uuid, userDto.uuid) &&
                Objects.equals(name, userDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, levelsCompleted, name);
    }
}
