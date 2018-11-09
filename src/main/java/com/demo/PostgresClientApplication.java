package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class PostgresClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostgresClientApplication.class, args);
	}
}