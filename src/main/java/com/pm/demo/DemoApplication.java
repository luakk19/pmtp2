package com.pm.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = {"com.pm.demo", "ar.edu.unnoba.mp2026.courses"})
@EntityScan(basePackages = {"com.pm.demo", "ar.edu.unnoba.mp2026.courses"})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
