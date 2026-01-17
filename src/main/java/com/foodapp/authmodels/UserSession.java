package com.foodapp.authmodels;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserSession {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
    private Integer userId;

    private String UUID;
    private LocalDateTime timeStamp;

    // ====================
    // Constructores
    // ====================

    public UserSession() {
    }

    public UserSession(Integer id, Integer userId, String UUID, LocalDateTime timeStamp) {
        this.id = id;
        this.userId = userId;
        this.UUID = UUID;
        this.timeStamp = timeStamp;
    }

    public UserSession(Integer userId, String UUID, LocalDateTime timeStamp) {
        this.userId = userId;
        this.UUID = UUID;
        this.timeStamp = timeStamp;
    }

    // ====================
    // Getters y Setters
    // ====================

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}
