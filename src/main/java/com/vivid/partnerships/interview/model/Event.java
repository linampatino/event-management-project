package com.vivid.partnerships.interview.model;

import java.util.Date;

public class Event {
	private Integer eventId;
	private String name;
	private Date date;
	private Venue venue;
	
	public Integer getEventId() {
		return eventId;
	}
	public void setEventId(Integer id) {
		this.eventId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Venue getVenue() {
		return venue;
	}
	public void setVenue(Venue venue) {
		this.venue = venue;
	}
}
