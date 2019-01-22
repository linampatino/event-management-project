package com.vivid.partnerships.interview.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vivid.partnerships.interview.model.Event;
import com.vivid.partnerships.interview.model.Venue;
import com.vivid.partnerships.interview.repository.EventJDBCTemplate;
import com.vivid.partnerships.interview.repository.EventRepository;

import java.util.Date;
import java.util.List;

@Service
public class EventService {
    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
    
    public void create(String name, Date date, Venue venue) {
    	this.eventRepository.create(name, date, venue);
    }

     public List<Event> getEvents() {
         return this.eventRepository.listEvents();
    }
}
