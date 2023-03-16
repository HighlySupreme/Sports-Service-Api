package com.sportsradar.sportsServiceApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SportServiceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportServiceApiApplication.class, args);
	}


}
