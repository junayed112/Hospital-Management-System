package com.hospital.management.advice;

import com.hospital.management.entity.QueryResponse;
import com.hospital.management.error.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice(
        value = "com.hospital.management.controller"
)
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<QueryResponse<String>> HandleUserNotFoundException(
            UserNotFoundException exception, WebRequest request) {
        QueryResponse<String> response = new QueryResponse<>(
                "User not found", false,
                exception.getMessage()
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TokenNotMatchedException.class)
    public ResponseEntity<QueryResponse<String>> TokenNotMatchedException(
            TokenNotMatchedException exception, WebRequest request) {

        QueryResponse<String> response = new QueryResponse<>(
                "Token not matched", false,
                exception.getMessage()

        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SpecialityNotFoundException.class)
    public ResponseEntity<QueryResponse<String>> SpecialityNotFoundException(
            SpecialityNotFoundException exception, WebRequest request){
        QueryResponse<String > response = new QueryResponse<>("Speciality Doesn't exist",
                false, exception.getMessage());

        return  new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<QueryResponse<String>> HandlerIdNotFoundException(
            IdNotFoundException exception, WebRequest request){
        QueryResponse<String > response = new QueryResponse<>(null,
                false, exception.getMessage());

        return  new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(AppointmentBookedException.class)
    public ResponseEntity<QueryResponse<String> > HandlerAppointmentAlreadyBookedException(
            AppointmentBookedException exception, WebRequest request){
        QueryResponse<String> response = new QueryResponse<>("The appointment is already booked", false, exception.getMessage());
        return  new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(PasswordNotMatchedException.class)
    public ResponseEntity<QueryResponse<String> > HandlerPasswordNotMatchedException(
            PasswordNotMatchedException exception, WebRequest request){
        QueryResponse<String> response = new QueryResponse<>("Wrong password", false, exception.getMessage());
        return  new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
