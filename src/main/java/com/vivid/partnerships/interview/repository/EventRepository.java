/**
 * 
 */
package com.vivid.partnerships.interview.repository;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.vivid.partnerships.interview.model.Event;

/**
 * This Interface define operations related with the event table
 * @author lina.patino
 *
 */

@CrossOrigin(origins = "http://localhost:4200")
public interface EventRepository {

	public Event create(Event event);
	public List<Event>listEvents();
}

