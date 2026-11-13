package com.pm.demo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import ar.edu.unnoba.mp2026.courses.util.JwtTokenUtil;
import ar.edu.unnoba.mp2026.courses.util.PasswordEncoder;

@SpringBootApplication(scanBasePackages = {"com.pm.demo", "ar.edu.unnoba.mp2026.courses"})
@EntityScan(basePackages = {"com.pm.demo", "ar.edu.unnoba.mp2026.courses"})
@EnableJpaRepositories(basePackages = {"com.pm.demo", "ar.edu.unnoba.mp2026.courses"})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new PasswordEncoder();
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public JwtTokenUtil jwtTokenUtil() {
		return new JwtTokenUtil();
	}
}
