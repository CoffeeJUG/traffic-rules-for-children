package com.coffeejug.trafficrules.db;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Progress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String mockProgress;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    public Progress() {
    }

    public Progress(String mockProgress, User user) {
        this.mockProgress = mockProgress;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMockProgress() {
        return mockProgress;
    }

    public void setMockProgress(String mockProgress) {
        this.mockProgress = mockProgress;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
