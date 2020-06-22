package dtu.cdio.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dtu.cdio.model.Place;

@Service
@Transactional
public class PlaceDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Place> findAll(){
		final String sql ="SELECT * FROM place";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Place.class));
	}
	
	public List<Place> getTopPlace(){
		final String sql ="SELECT * FROM place ORDER BY count_book DESC LIMIT 3";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Place.class));
	}
}
