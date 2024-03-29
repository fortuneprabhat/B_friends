package com.nagarro.B_friends.controller;

import javax.xml.bind.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.nagarro.B_friends.util.ErrorMessage;

@ControllerAdvice
public class ControllerExceptionHandler {
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler
	ErrorMessage exceptionHandler(ValidationException ex) {
		
		return new ErrorMessage("400", ex.getMessage());
	}
}
