package com.microservices.microservices.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.microservices.microservices.bean.CustomException;

@ControllerAdvice
@RestController
public class CustomResponseEntityException extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {

		CustomException ce = new CustomException(ex.getMessage(), request.getDescription(false), new Date());
		return new ResponseEntity(ce, HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		CustomException ce = new CustomException(ex.getBindingResult().toString(), request.getDescription(false), new Date());
		return  new ResponseEntity(ce, HttpStatus.BAD_REQUEST);
	}

}
