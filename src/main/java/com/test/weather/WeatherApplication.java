package com.test.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.weather.controller.WeatherController;

@SpringBootApplication
@EnableCaching
@EnableScheduling
@ComponentScan(basePackageClasses = WeatherController.class, basePackages = "com.test.weather.*")
public class WeatherApplication {
	
	
	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.setSerializationInclusion(Include.NON_NULL);
		return mapper;
	}
	
	


	public static void main(String[] args) {
		SpringApplication.run(WeatherApplication.class, args);
		
	}
	
	

}
