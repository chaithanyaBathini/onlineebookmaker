package com.ebook.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler({InvalidUserException.class,
			IdNotFoundException.class,NoBookException.class,InvalidInputException.class,AlreadyExsistException.class,DataViolationException.class,DoesNotExistsException.class,TitleExistsException.class})
	public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(Exception res){
		String message=res.getMessage();
		ApiResponse apiResponse=new ApiResponse(message,false);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> handleMethodArgNotValidException(MethodArgumentNotValidException ex){
	    String defaultMessage = ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();
	    return new ResponseEntity<String>(defaultMessage, HttpStatus.BAD_REQUEST);
	}
	

}
