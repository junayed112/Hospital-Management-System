package com.hospital.management.error;

public class AppointmentBookedException extends RuntimeException{
    public AppointmentBookedException() {
        super();
    }

    public AppointmentBookedException(String message) {
        super(message);
    }

    public AppointmentBookedException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppointmentBookedException(Throwable cause) {
        super(cause);
    }

    protected AppointmentBookedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
