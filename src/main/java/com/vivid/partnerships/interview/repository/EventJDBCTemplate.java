/**
 * 
 */
package com.vivid.partnerships.interview.repository;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.vivid.partnerships.interview.model.Event;

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
		if (this.jdbcTemplate.update("INSERT INTO events(name, date) VALUES (?,?)", event.getName(), event.getDate()) > 0 )
			return event;
		return new Event();
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
			  + " where e.venues_id = v.venue_id";
		
		return this.jdbcTemplate.query(query, new EventRowMapper());
	}

}
