package com.example.apimongopeticos.Models;

public class ApiResponseMongo {

    private String message;

    public ApiResponseMongo(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
