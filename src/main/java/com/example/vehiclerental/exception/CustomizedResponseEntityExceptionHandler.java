
package com.example.vehiclerental.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler {
	// Intentionally left blank (no framework-specific code)
	@ExceptionHandler(InvalidRentalPlanException.class)
	public ResponseEntity<ExceptionResponse> handleNotFound(InvalidRentalPlanException e, HttpServletRequest request) {
		ExceptionResponse response = new ExceptionResponse(LocalDateTime.now(), e.getMessage(),
				request.getRequestURI());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ExceptionResponse> handleMethodArgumentNotValid(MethodArgumentNotValidException e,
			HttpServletRequest request) {
		ExceptionResponse response = new ExceptionResponse(LocalDateTime.now(), e.getMessage(),
				request.getRequestURI());
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse> handleAllExceptions(Exception e, HttpServletRequest request) {
		ExceptionResponse response = new ExceptionResponse(LocalDateTime.now(), e.getMessage(),
				request.getRequestURI());
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
