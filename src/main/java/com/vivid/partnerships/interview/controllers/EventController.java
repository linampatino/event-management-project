package com.vivid.partnerships.interview.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vivid.partnerships.interview.controllers.vo.EventVO;
import com.vivid.partnerships.interview.model.Event;
import com.vivid.partnerships.interview.model.Venue;
import com.vivid.partnerships.interview.services.EventService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EventController {
    
    private final EventService eventService;

    @Autowired
    public EventController(final EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/events")
    public List<Event> getEvents() {
        return this.eventService.getEvents();
    }
    
    @PostMapping("/event")
    public Event createEvent(@RequestBody EventVO eventVO) {
    	Venue venue = new Venue();
    	venue.setName(eventVO.getVenue().getName());
    	venue.setCity(eventVO.getVenue().getCity());
    	venue.setState(eventVO.getVenue().getState());
    	
        Event event = new Event();
        event.setEventId(eventVO.getEventId());
        event.setName(eventVO.getName());
        event.setDate(eventVO.getDate());
        event.setVenue(venue);
        
        return this.eventService.create(event);
    }
}
