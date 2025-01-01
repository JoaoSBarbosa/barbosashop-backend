package com.joaobarbosadev.BarbosaShop.components;

import java.time.Instant;

public class CustomResponse<T> {

    private Instant timestamp;
    private String message;
    private Integer status;
    private String path;
    private T data;

    public CustomResponse(){}

    public CustomResponse(Instant timestamp, String message, Integer status, String path, T data) {
        this.timestamp = timestamp;
        this.message = message;
        this.status = status;
        this.path = path;
        this.data = data;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "RespostaPersonalizada{" +
                "dataHora=" + timestamp +
                ", mensagem='" + message + '\'' +
                ", status=" + status +
                ", caminho='" + path + '\'' +
                ", dados=" + data +
                '}';
    }



}
