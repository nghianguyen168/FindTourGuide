package dtu.cdio.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class GuestMapper implements RowMapper<Guest> {

	@Override
	public Guest mapRow(ResultSet rs, int rowNum) throws SQLException {
		Guest guest = new Guest();
		guest.setGuest_Id(rs.getInt("id"));
		guest.setUsername(rs.getString("username"));;
		guest.setPassword(rs.getString("password"));
		guest.setFullname(rs.getString("fullname"));
		guest.setDate_Of_Birth(rs.getTimestamp("date_of_birth"));
		guest.setImage(rs.getString("image"));
		guest.setCountry(rs.getString("country"));
		guest.setEmail(rs.getString("email"));
		guest.setPhone(rs.getString("phone"));
		guest.setStatus(rs.getInt("status"));
		return guest;
	}
}
