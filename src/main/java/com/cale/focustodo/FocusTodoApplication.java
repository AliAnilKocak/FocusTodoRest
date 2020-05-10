package com.cale.focustodo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class FocusTodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FocusTodoApplication.class, args);
	}




}
