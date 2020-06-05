package dtu.cdio.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dtu.cdio.model.Guest;
import dtu.cdio.model.GuestMapper;

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
	public Guest guestLogin(String username,String password) {
		String SQL ="SELECT * FROM guest WHERE username=? AND password=?";
		return jdbcTemplate.queryForObject(SQL, new GuestMapper(), username,password);
	}
	
	public Guest checkGuest(String username) {
		String SQL ="SELECT * FROM guest WHERE username=?";
		return jdbcTemplate.queryForObject(SQL, new GuestMapper(), username);
	}
	public int editItem(Guest guest) {
		String SQL ="UPDATE guest SET username=?,password=?,fullname=?,date_of_birth=?,image=?,country=?,email=?,phone=?,status=? WHERE guest_id=?";
		return jdbcTemplate.update(SQL,guest.getUsername(),guest.getPassword(),guest.getFullname(),guest.getDate_Of_Birth(),guest.getImage(),guest.getCountry()
				,guest.getEmail(),guest.getPhone(),guest.getPassword(),guest.getGuest_Id());
	}
	public int LockAccount(int guest_id) {
		String SQL="UPDATE guest SET status=0 WHERE guest_id=?";
		return jdbcTemplate.update(SQL,guest_id);
	}
	public int UnlockAccount(int guest_id) {
		String SQL="UPDATE guest SET status=1 WHERE guest_id=?";
		return jdbcTemplate.update(SQL,guest_id);
	}

}














 

