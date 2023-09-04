package com.hospital.management.entity;

import lombok.Data;
@Data
public class QueryResponse <T>{

    private T result;
    private boolean isSuccessful = true;
    private String errorMessage;

    public QueryResponse(T result, boolean isSuccessful, String errorMessage) {
        this.result = result;
        this.isSuccessful = isSuccessful;
        this.errorMessage = errorMessage;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public boolean isSuccessful() {
        return isSuccessful;
    }

    public void setSuccessful(boolean successful) {
        isSuccessful = successful;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
