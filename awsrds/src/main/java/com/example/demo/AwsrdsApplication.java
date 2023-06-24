package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component("com.example")
public class AwsrdsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwsrdsApplication.class, args);
	}

}
