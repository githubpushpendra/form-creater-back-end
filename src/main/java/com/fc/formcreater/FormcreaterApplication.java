package com.fc.formcreater;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class FormcreaterApplication {

	public static void main(String[] args) {
		SpringApplication.run(FormcreaterApplication.class, args);
	}

}
