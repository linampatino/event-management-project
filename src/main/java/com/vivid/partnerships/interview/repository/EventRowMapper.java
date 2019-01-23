package com.vivid.partnerships.interview.repository;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import com.vivid.partnerships.interview.model.Event;
import com.vivid.partnerships.interview.model.Venue;

import java.sql.ResultSet;
import java.sql.SQLException;


public class EventRowMapper implements RowMapper<Event> {
    @Nullable
    @Override
    public Event mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        
    	final Venue venue = new Venue();
        venue.setVenueId(resultSet.getInt("venueId"));
        venue.setName(resultSet.getString("venueName"));
        venue.setCity(resultSet.getString("venueCity"));
        venue.setState(resultSet.getString("venueState"));
    	
    	final Event event = new Event();
        event.setEventId(resultSet.getInt("eventId"));
        event.setDate(resultSet.getDate("eventDate"));
        event.setName(resultSet.getString("eventName"));
        event.setVenue(venue);
        
       return event;
    }
}
