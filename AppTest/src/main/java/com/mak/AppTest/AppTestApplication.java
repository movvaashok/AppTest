package com.mak.AppTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppTestApplication {
	public static void main(String[] args) {
		Logger log = LoggerFactory.getLogger(AppTestApplication.class);
		SpringApplication.run(AppTestApplication.class, args);
		log.trace("Application is up and running!");
	}

}
