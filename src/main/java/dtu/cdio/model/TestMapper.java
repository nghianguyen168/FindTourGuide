package dtu.cdio.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TestMapper implements RowMapper<Test>{


	public Test mapRow(ResultSet rs, int rowNum) throws SQLException {
		Test test = new  Test();
		test.setId(rs.getInt("id"));
		test.setUsername(rs.getString("username"));
		test.setPassword(rs.getString("password"));
		return test;
	}
	
}
