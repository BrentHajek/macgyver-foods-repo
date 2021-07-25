package com.macgyverfoods.pickyeater;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PickyEaterApplication {

	public static void main(String[] args) {
		SpringApplication.run(PickyEaterApplication.class, args);

		System.out.println("Server Side is wired up!");
	}

}
