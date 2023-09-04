package com.hospital.management.error;

public class UserNotFoundException extends RuntimeException {

    private String message;

//    public UserNotFoundException(String message) {
//        this.message = message;
//    }
//
//    @Override
//    public String getMessage() {
//        return message;

    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundException(Throwable cause) {
        super(cause);
    }

    protected UserNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
//    }
}
