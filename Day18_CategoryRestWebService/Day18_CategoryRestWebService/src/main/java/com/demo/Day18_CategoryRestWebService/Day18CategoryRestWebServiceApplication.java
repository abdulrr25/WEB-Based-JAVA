package com.demo.Day18_CategoryRestWebService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Day18CategoryRestWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Day18CategoryRestWebServiceApplication.class, args);
	}

}
