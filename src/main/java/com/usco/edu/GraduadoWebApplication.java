package com.usco.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication
public class GraduadoWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraduadoWebApplication.class, args);
	}
	


}
