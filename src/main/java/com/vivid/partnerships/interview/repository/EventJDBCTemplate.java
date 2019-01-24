/**
 * 
 */
package com.vivid.partnerships.interview.repository;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.vivid.partnerships.interview.model.Event;
import com.vivid.partnerships.interview.model.Venue;

/**
 * @author lina.patino
 *
 */
@Repository
public class EventJDBCTemplate implements EventRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Event create(Event event) {
		event.getVenue().setVenueId(insertVenue(event.getVenue()));
		event.setEventId(insertEvent(event));
		return event;
	}
	
	private int insertVenue(Venue venue) {
		this.jdbcTemplate.update("INSERT INTO venues(name, city, state) VALUES (?,?,?)", venue.getName(), venue.getCity(), venue.getState());
		return this.jdbcTemplate.queryForObject("select max(venue_id) from venues where name = ? and city = ? and state = ?", new Object[] {venue.getName(), venue.getCity(), venue.getState()}, Integer.class );
	}
	
	private int insertEvent(Event event) {
		this.jdbcTemplate.update("INSERT INTO events(name, date, venues_id) VALUES (?,?,?)", event.getName(), event.getDate(), event.getVenue().getVenueId());
		return this.jdbcTemplate.queryForObject("select max(event_id) from events where name = ? and date = ? and venues_id= ?", new Object[] {event.getName(), event.getDate(), event.getVenue().getVenueId()}, Integer.class );
	}

	@Override
	public List<Event> listEvents() {
		String query = 
				"select e.event_id eventId,"
			  + "		e.name  eventName, "
			  + "		e.date  eventDate, "
			  + "		v.venue_id	venueId,"		
			  + "		v.name  venueName, "
			  + "		v.city  venueCity, "
			  + "		v.state venueState"
			  + "  from events e, venues v "
			  + " where e.venues_id = v.venue_id"
			  + " order by e.date desc";
		
		return this.jdbcTemplate.query(query, new EventRowMapper());
	}

}
