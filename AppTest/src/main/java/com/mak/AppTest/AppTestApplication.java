package com.mak.AppTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.*;

@SpringBootApplication
public class AppTestApplication {
	public static void main(String[] args) {
		Logger log= LoggerFactory.getLogger(AppTestApplication.class);
		SpringApplication.run(AppTestApplication.class, args);
	}

}
