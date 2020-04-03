package com.example.miniProjet.exceptionHandling;

import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.miniProjet.AuthTokenUtil.EmployeError;

@Order()
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
 
	
	 @Override
	   protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
	       String error = "Malformed JSON request";
	       return buildResponseEntity(new EmployeError(HttpStatus.BAD_REQUEST, error, ex));
	   }

	   private ResponseEntity<Object> buildResponseEntity(EmployeError employeError) {
	       return new ResponseEntity<>(employeError, employeError.getStatus());
	   }

	   @ExceptionHandler(EntityNotFoundException.class)
	   protected ResponseEntity<Object> handleEntityNotFound(
	           EntityNotFoundException ex) {
	       EmployeError apiError = new EmployeError(HttpStatus.NOT_FOUND);
	       apiError.setMessage(ex.getMessage());
	       return buildResponseEntity(apiError);
	   }
	   @ExceptionHandler(NoSuchElementException.class)
	   protected ResponseEntity<Object>  handleNoSuchElementException(
			   NoSuchElementException ex) {
	       EmployeError employeError = new EmployeError(HttpStatus.NOT_FOUND);
	       employeError.setMessage(ex.getMessage());
	       return buildResponseEntity(employeError);
	   }
}
