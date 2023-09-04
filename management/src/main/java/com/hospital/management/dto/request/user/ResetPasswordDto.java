package com.hospital.management.dto.request.user;

public class ResetPasswordDto {

    private String password;
    private String token;

    public ResetPasswordDto() {
    }

    public ResetPasswordDto(String password, String token) {
        this.password = password;
        this.token = token;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
