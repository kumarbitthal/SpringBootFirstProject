package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({" com.topic", "com.exceptions","com.documents"})
public class SpringFirstProjectMain {

	public static void main(String[] args) {
		SpringApplication.run(SpringFirstProjectMain.class, args);
	}
}
