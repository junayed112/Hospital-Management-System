package com.hospital.management.dto.response;

public class GenerateToken {
    private String token;

    public GenerateToken() {

    }

    public GenerateToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
