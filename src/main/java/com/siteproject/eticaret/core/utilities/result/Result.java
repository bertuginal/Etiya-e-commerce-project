package com.siteproject.eticaret.core.utilities.result;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Result<T> {

    private boolean success;
    private String message;
    private T data;

    public Result(boolean success) {
        this.success = success;
    }

    public Result(boolean success, String message) {
        this.message = message;
        this.success = success;
    }

    public Result(boolean success, T data) {
        this.success = success;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
