package com.sai.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void createEmployee(String name, String desg) {
		jdbcTemplate.update
		("insert into employee(name,desg) values(?,?)",
		    new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1,name);
				ps.setString(2,desg);
			}
		});
	}

}
