package com.vivid.partnerships.interview.repository;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import com.vivid.partnerships.interview.model.Event;
import com.vivid.partnerships.interview.model.Venue;

import java.sql.ResultSet;
import java.sql.SQLException;


public class EventRowMapper implements RowMapper<Event> {
    @Nullable
    @Override
    public Event mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        final Event event = new Event();
        event.setEventId(resultSet.getInt("event_id"));
        event.setDate(resultSet.getDate("date"));
        event.setName(resultSet.getString("name"));
        //event.setVenue((Venue)resultSet.getObject("venues_id"));
        System.out.println("resultSet.getObject(\"venues_id\") ::: " + resultSet.getObject("venues_id"));
        return event;
    }
}
