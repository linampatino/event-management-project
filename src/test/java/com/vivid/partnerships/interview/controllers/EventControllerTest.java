package com.vivid.partnerships.interview.controllers;

import static org.junit.Assert.*;

import java.util.ArrayList;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.http.MediaType.APPLICATION_JSON;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;

import com.vivid.partnerships.interview.model.Event;

@RunWith(SpringRunner.class)
@WebMvcTest(EventController.class)
public class EventControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private EventController eventController ;
	
	@Test
	public void getEvents() throws Exception{
		Event testEvent = new Event();
		testEvent.setName("Test Event");
		
		List<Event> allEvents = new ArrayList<>();
		allEvents.add(testEvent);
		
		given(eventController.getEvents()).willReturn(allEvents) ;
		
		mvc.perform(get(("http://localhost:8080/events"))
	               .contentType(APPLICATION_JSON))
	               .andExpect(status().isOk())
	               .andExpect(jsonPath("$", hasSize(1)))
	               .andExpect(jsonPath("$[0].name", is(testEvent.getName())));
	          
	}
	
	@Test	
	public void createEvent() throws Exception{
		String parameters = 
				"{"
				+"\"name\":\"Test Event\","
				+"\"date\":\"2019-03-03T16:11:00.000+0000\","
				+"\"venue\":{"
				+"	 \"name\":\"Pascual Guerrero Stadium\","
				+"	 \"city\":\"Cali\","
				+"	 \"state\":\"Valle\""
				+"  }"
				+"}";
		
				
		mvc.perform(post(("http://localhost:8080/event"))
	            .accept(APPLICATION_JSON)
	            .content(parameters)   
				.contentType(APPLICATION_JSON))
				.andExpect(jsonPath("$.name").exists())
				.andExpect(jsonPath("$.venue.name").exists());		
	}

}
