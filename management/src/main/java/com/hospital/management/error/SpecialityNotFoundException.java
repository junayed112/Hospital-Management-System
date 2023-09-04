package com.hospital.management.error;

public class SpecialityNotFoundException extends RuntimeException{
    public SpecialityNotFoundException() {
        super();
    }

    public SpecialityNotFoundException(String message) {
        super(message);
    }

    public SpecialityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public SpecialityNotFoundException(Throwable cause) {
        super(cause);
    }

    protected SpecialityNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
