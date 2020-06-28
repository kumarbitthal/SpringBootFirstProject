package com.exceptions;

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

import com.topic.UserNotFoundException;

@RestController
@ControllerAdvice
public class ExceptionHandlerCustomized extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
			GenericException gexc = new GenericException(ex.getMessage(), new Date(), request.getDescription(false));
		return new ResponseEntity(gexc, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request) {
			GenericException gexc = new GenericException(ex.getMessage(), new Date(), request.getDescription(false));
		return new ResponseEntity(gexc, HttpStatus.NOT_FOUND);
	}
	
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		GenericException gexc = new GenericException(ex.getBindingResult().toString(), new Date(), request.getDescription(false));
		return new ResponseEntity(gexc, HttpStatus.BAD_REQUEST);
	}

}
