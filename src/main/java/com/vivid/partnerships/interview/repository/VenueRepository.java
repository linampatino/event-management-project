package com.vivid.partnerships.interview.repository;

import java.util.List;

import com.vivid.partnerships.interview.model.Venue;

public interface VenueRepository extends Repository {

	public void create(String name, String city, String state);
	public List<Venue>listVenues();
}

