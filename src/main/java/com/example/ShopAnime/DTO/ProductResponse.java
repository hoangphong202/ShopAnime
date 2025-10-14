package com.example.ShopAnime.DTO;

public class ProductResponse {
    private boolean success;
    private String message;
    private Object data; // có thể là ProductDTO, List<ProductDTO>, v.v.


    public ProductResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public ProductResponse(boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    // Getter và Setter
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
