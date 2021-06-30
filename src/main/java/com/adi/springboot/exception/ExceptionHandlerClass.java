package com.adi.springboot.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.adi.springboot.model.Response;

@ControllerAdvice
public class ExceptionHandlerClass {
	
	@ExceptionHandler(NullPointerException.class)
	public Response handleNullPointerException(NullPointerException ex) {
			Response res=new Response();
			res.setResponseCode(501);
			res.setResponseMessage("NullPointer Exception aayi hai!!");
			return res;
	}

}
