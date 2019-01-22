/**
 * 
 */
package com.vivid.partnerships.interview.repository;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.vivid.partnerships.interview.model.Event;
import com.vivid.partnerships.interview.model.Venue;

/**
 * @author lina.patino
 *
 */
public class EventJDBCTemplate implements EventRepository {


	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;
	
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void create(String name, Date date, Venue venue) {
		this.jdbcTemplate.update("INSERT INTO events(name, date) VALUES (?,?)", name, date);
	}

	@Override
	public List<Event> listEvents() {
		return this.jdbcTemplate.query("SELECT * FROM events", new EventRowMapper());
	}

}
