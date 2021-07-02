package com.adi.springboot.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.adi.springboot.model.Response;

@ControllerAdvice
//public class ExceptionHandlerClass extends ResponseEntityExceptionHandler{
public class ExceptionHandlerClass{
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<Object> handleNullPointerException(NullPointerException ex) {
		System.out.println("*********** handleNullPointerException ******");
			Response res=new Response();
			res.setResponseCode(501);
			res.setResponseMessage("NullPointer Exception aayi hai!!");
			System.out.println("*********** handleNullPointerException After ******");
			//return handleExceptionInternal(ex, res, new HttpHeaders(), HttpStatus.CONFLICT, null);
			return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
			
	}
	


}
