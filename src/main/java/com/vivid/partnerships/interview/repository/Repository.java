package com.vivid.partnerships.interview.repository;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public interface Repository {

	public void setDataSource(DataSource dataSource);
}
