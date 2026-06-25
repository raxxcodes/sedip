package com.raxxcodes.sedip.common.response;

import java.time.Instant;

public class ApiResponse<T> {

    private boolean success;
    private String message;
    private Instant timestamp;
    private T data;

    public ApiResponse() {
    }

    public ApiResponse(boolean success, String message, Instant timestamp, T data) {
        this.success = success;
        this.message = message;
        this.timestamp = timestamp;
        this.data = data;
    }

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

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> ApiResponse<T> success(String message, T data) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setSuccess(true);
        response.setMessage(message);
        response.setTimestamp(Instant.now());
        response.setData(data);
        return response;
    }

    public static <T> ApiResponse<T> error(String message) {
        return new ApiResponse<>(false, message, Instant.now(), null);
    }
}