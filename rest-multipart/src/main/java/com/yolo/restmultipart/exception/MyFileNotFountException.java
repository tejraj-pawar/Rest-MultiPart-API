package com.yolo.restmultipart.exception;

import java.net.MalformedURLException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MyFileNotFountException extends Exception {

	public MyFileNotFountException(String exceptionMessage) {
		super(exceptionMessage);
	}

	public MyFileNotFountException(String exceptionMessage, MalformedURLException e) {
		super(exceptionMessage, e);
	}
	
}
