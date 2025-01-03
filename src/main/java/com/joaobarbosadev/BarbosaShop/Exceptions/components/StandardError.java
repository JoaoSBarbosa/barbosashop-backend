package com.joaobarbosadev.BarbosaShop.Exceptions.components;

import java.time.Instant;

public class StandardError {

    private Instant timestamp;
    private String message;
    private Integer status;
    private String path;
    private String error;

    public StandardError(){}

    public StandardError(Instant timestamp, String message, Integer status, String path, String error) {
        this.timestamp = timestamp;
        this.message = message;
        this.status = status;
        this.path = path;
        this.error = error;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "StandardError{" +
                "timestamp=" + timestamp +
                ", message='" + message + '\'' +
                ", status=" + status +
                ", path='" + path + '\'' +
                ", error='" + error + '\'' +
                '}';
    }
}
