package dtu.cdio.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dtu.cdio.model.Guest;

@Service
@Transactional
public class GuestDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	public int addItem(Guest guest) {
		String SQL = "INSERT INTO guest(username,password,fullname,date_of_birth,image,country,email,phone,status )"
				+ "VALUES(?,?,?,?,?,?,?,?,?)";
		return jdbcTemplate.update(SQL,guest.getUsername(),guest.getPassword(),guest.getFullname(),guest.getDate_Of_Birth(),guest.getImage(),guest.getCountry()
				,guest.getEmail(),guest.getPhone(),guest.getStatus());
	}

}














 

