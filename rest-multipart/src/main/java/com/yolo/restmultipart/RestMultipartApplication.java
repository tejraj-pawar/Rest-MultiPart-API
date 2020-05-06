package com.yolo.restmultipart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class RestMultipartApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestMultipartApplication.class, args);
	}

}
