package com.spring.mongodb.home.customer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value=HttpStatus.SERVICE_UNAVAILABLE,reason="MONGOD INSTANCE NOT AVAIL")
public class BackEndException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
