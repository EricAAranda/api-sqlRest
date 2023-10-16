package com.sqlrest.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AutoConfiguration
public class SqlRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SqlRestApplication.class, args);
	}

}
