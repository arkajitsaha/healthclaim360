package com.example.healthclaim.exception;

import java.util.Map;

public class ErrorResponse {

    private int status;
    private String error;
    private String message;
    private Map<String, String> errors;

    public ErrorResponse(
            int status,
            String error,
            String message,
            Map<String, String> errors) {

        this.status = status;
        this.error = error;
        this.message = message;
        this.errors = errors;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public Map<String, String> getErrors() {
        return errors;
    }
}
