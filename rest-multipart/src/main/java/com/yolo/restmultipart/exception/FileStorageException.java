package com.yolo.restmultipart.exception;

public class FileStorageException extends RuntimeException {
	
	public FileStorageException(String exceptionMessage)
	{
		super(exceptionMessage);
	}

	public FileStorageException(String exceptionMessage, Exception e) {
		super(exceptionMessage, e);
	}

}
