package com.example.ShopAnime.DTO;

public class LoginResponse {
    private String message;
    private boolean success;
    private String role;
    private String token;

    public LoginResponse (boolean success, String message){
        this.message = message;
        this.success = success;
    }


    public LoginResponse (boolean success, String message, String role, String token ){
        this.message = message;
        this.success = success;
        this.role = role;
        this.token = token;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
