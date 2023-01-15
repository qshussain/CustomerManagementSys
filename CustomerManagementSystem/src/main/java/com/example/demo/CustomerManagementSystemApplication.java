package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication

public class CustomerManagementSystemApplication {

	public static void main(String[] args) {
		System.out.println("running..");
		SpringApplication.run(CustomerManagementSystemApplication.class, args);
	}

}
