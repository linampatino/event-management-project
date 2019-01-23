package com.vivid.partnerships.interview.model;

public class Venue {
    private Integer venueId;
    private String name;
    private String city;
    private String state;
    
	public Integer getVenueId() {
		return venueId;
	}
	public void setVenueId(Integer id) {
		this.venueId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
