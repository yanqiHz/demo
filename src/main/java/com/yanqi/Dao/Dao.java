package com.yanqi.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class Dao {

	@Autowired
	@Qualifier("jdbcTemplate")
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	@Qualifier("jdbcTemplate2")
	JdbcTemplate jdbcTemplate1;
	
	public String getUserName(String ID){
		String sql = "select name from test where id = ?";
		return jdbcTemplate.queryForObject(sql, String.class, new Object[]{ID});
	}
	
	public String getUserName1(String ID){
		String sql = "select name from test where id = ?";
		return jdbcTemplate1.queryForObject(sql, String.class, new Object[]{ID});
	}
}
