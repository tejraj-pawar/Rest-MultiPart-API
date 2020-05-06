package com.yolo.restmultipart.service;

import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.yolo.restmultipart.FileStorageProperties;
import com.yolo.restmultipart.exception.FileStorageException;
import com.yolo.restmultipart.exception.MyFileNotFountException;

@Service
public class FileStorageService {

	private Path fileStorageLocation = null;
	
	@Autowired
	public FileStorageService(FileStorageProperties fileStorageProperties)
	{
		this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();
		
		try
		{
			Files.createDirectories(this.fileStorageLocation);
		}
		catch (Exception e) 
		{
			throw new FileStorageException("Could not create the directory specified in application.properties: " + e.getMessage());
		}
		
	}
	
	public String storeFile(MultipartFile file) {
		// Normalize the fine name
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		
		try
		{
			if(fileName.contains(".."))
				throw new FileStorageException("File name is invalid");
			
			// Copy file to target location and override it is already present.
			Path targetLocation = this.fileStorageLocation.resolve(fileName);
		    Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
		
		    return fileName;
		}
		catch (Exception e) {
			throw new FileStorageException("Could not store file " + fileName + " Please Try again!!", e);
		}
		
	}

	public Resource loadFileAsResource(String fileName) throws MyFileNotFountException {
		try
		{
			Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
			Resource resource = new UrlResource(filePath.toUri());
			if(resource.exists())
				return resource;
			else
				throw new MyFileNotFountException("File not found: " + filePath);
		}
		catch (MalformedURLException e) {
			throw new MyFileNotFountException("File not found: " + fileName, e);
		}
	}

}











