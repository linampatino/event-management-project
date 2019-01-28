package com.vivid.partnerships.interview.controllers.vo;

import java.util.Date;



public class EventVO {
	private Integer eventId;
	private String name;
	private Date date;
	private VenueVO venue;
	
	public Integer getEventId() {
		return eventId;
	}
	public void setEventId(Integer eventId) {
		this.eventId = eventId;
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
	public VenueVO getVenue() {
		return venue;
	}
	public void setVenue(VenueVO venue) {
		this.venue = venue;
	}
}
