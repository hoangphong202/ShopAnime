package com.example.ShopAnime.DTO;

public class LoginResponse {
    private String message;
    private boolean success;

    public LoginResponse (boolean success,String message){
        this.message = message;
        this.success = success;
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
}
