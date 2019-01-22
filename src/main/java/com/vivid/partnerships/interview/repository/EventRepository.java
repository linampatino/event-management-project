/**
 * 
 */
package com.vivid.partnerships.interview.repository;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import com.vivid.partnerships.interview.model.Event;
import com.vivid.partnerships.interview.model.Venue;

/**
 * This Interface define operations related with the event table
 * @author lina.patino
 *
 */
public interface EventRepository /*extends Repository*/ {

	public void setDataSource(DataSource dataSource);
	public void create(String name, Date date, Venue venue);
	public List<Event>listEvents();
}

