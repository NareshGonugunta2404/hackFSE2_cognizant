package com.united.company.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomizedExceptionHandling extends ResponseEntityExceptionHandler {

	 @ExceptionHandler(CompanyNotFoundException.class)
	 public ResponseEntity<Object> handleExceptions( CompanyNotFoundException exception, WebRequest webRequest) {
	    ExceptionResponse response = new ExceptionResponse();
	    response.setDateTime(LocalDateTime.now());
	    response.setMessage("Company not found");
	    ResponseEntity<Object> entity = new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
	    return entity;
	  }
	
    @ExceptionHandler(CompanyCodeAlreadyExistException.class)
    public ResponseEntity<Object> handleExceptions( CompanyCodeAlreadyExistException exception, WebRequest webRequest) {
        ExceptionResponse response = new ExceptionResponse();
        response.setDateTime(LocalDateTime.now());
        response.setMessage("Company code already Exist");
        ResponseEntity<Object> entity = new ResponseEntity<>(response,HttpStatus.ALREADY_REPORTED);
        return entity;
    }
    
    @ExceptionHandler(CompanyTurnoverException.class)
    public ResponseEntity<Object> handleExceptions( CompanyTurnoverException exception, WebRequest webRequest) {
        ExceptionResponse response = new ExceptionResponse();
        response.setDateTime(LocalDateTime.now());
        response.setMessage("Company turnover is less than 10 Cr.");
        ResponseEntity<Object> entity = new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        return entity;
    }
}