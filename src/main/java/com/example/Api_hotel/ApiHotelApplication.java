package com.example.Api_hotel;

import java.util.TimeZone;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiHotelApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiHotelApplication.class, args);
                TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    
	}

}
