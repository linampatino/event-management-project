package com.vivid.partnerships.interview;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vivid.partnerships.interview.repository.EventJDBCTemplate;
import com.vivid.partnerships.interview.repository.EventRepository;
import com.vivid.partnerships.interview.services.EventService;


@SpringBootApplication
public class InterviewApplication /*implements CommandLineRunner*/ {
	private static final Logger LOGGER = LoggerFactory.getLogger(InterviewApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(InterviewApplication.class, args);
		LOGGER.info("Running app");
	}
	
	/*public void run(String... strings) throws Exception {
		System.out.println("metodo run");
		
		EventRepository eventRepository = new EventJDBCTemplate();
		
		EventService service = new EventService(eventRepository);
		List<Event> events = 
	}*/


}
