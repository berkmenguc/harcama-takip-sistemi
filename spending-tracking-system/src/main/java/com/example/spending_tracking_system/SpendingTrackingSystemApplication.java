package com.example.spending_tracking_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpendingTrackingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpendingTrackingSystemApplication.class, args);
	}

}
