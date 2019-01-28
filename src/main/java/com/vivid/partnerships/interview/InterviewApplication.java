package com.vivid.partnerships.interview;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(
		scanBasePackages = {
				"com.vivid.partnerships",
				"com.vivid.partnerships.interview",
				"com.vivid.partnerships.interview.controllers",
				"com.vivid.partnerships.interview.model",
				"com.vivid.partnerships.interview.repository",
				"com.vivid.partnerships.interview.services"
				}
		)

public class InterviewApplication /*implements CommandLineRunner*/ {
	private static final Logger LOGGER = LoggerFactory.getLogger(InterviewApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(InterviewApplication.class, args);
		LOGGER.info("Running app");
	}
	
}
