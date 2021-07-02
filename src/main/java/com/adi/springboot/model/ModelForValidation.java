package com.adi.springboot.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.UniqueElements;




public class ModelForValidation {
	
	//@NotEmpty(message = "userName can not be empty!!")
	//@NotNull(message = "userName can not be null!!")
	String password;
	    
	//@NotEmpty(message = "userName can not be empty!!")
	//@NotNull(message = "userName can not be null!!")
	//@UniqueElements
	String userName;

	@Override
	public String toString() {
		return "ModelForValidation [password=" + password + ", userName=" + userName + "]";
	}

	
	    

	    
}
