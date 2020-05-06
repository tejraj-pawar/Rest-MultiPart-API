package com.yolo.restmultipart;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//this will bind properties from application.properties with prefix "file" with variables of this class.
@ConfigurationProperties(prefix = "file")
@Component
public class FileStorageProperties {

	private String uploadDir;

	public String getUploadDir() {
		return uploadDir;
	}

	public void setUploadDir(String uploadDir) {
		this.uploadDir = uploadDir;
	} 
	
}
