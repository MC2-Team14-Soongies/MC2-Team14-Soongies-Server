package com.appledeveloperacademy.soongies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SoongiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoongiesApplication.class, args);
	}

}
