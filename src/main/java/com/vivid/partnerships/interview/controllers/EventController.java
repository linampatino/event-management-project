package com.vivid.partnerships.interview.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vivid.partnerships.interview.model.Event;
import com.vivid.partnerships.interview.services.EventService;

import java.util.List;

@RestController
public class EventController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EventController.class);

    private final EventService eventService;

    @Autowired
    public EventController(final EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/events")
    public List<Event> getEvents() {
        List<Event> events = eventService.getEvents();
        LOGGER.info("Returning {} events", events.size());
        return events;
    }
}