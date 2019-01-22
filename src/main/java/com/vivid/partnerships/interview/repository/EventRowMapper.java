package com.vivid.partnerships.interview.repository;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import com.vivid.partnerships.interview.model.Event;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EventRowMapper implements RowMapper<Event> {
    @Nullable
    @Override
    public Event mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        final Event event = new Event();
        event.setId(resultSet.getInt("id"));
        event.setDate(resultSet.getDate("date"));
        event.setName(resultSet.getString("name"));
        event.setVenue(null);
        return event;
    }
}
