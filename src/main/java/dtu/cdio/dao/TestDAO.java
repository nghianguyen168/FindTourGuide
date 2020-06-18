package dtu.cdio.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dtu.cdio.model.Test;
import dtu.cdio.model.TestMapper;

@Repository
@Transactional
public class TestDAO {

	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Test> userList() {
		String sql = "SELECT * FROM test";
		return jdbcTemplate.query(sql, new TestMapper());
	}
}
