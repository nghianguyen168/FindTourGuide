package dtu.cdio.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class GuideMapper implements RowMapper<Guide> {

	@Override
	public Guide mapRow(ResultSet rs, int rowNum) throws SQLException {
		Guide guide = new Guide();
		guide.setGuide_id(rs.getInt("guide_id"));
		guide.setUsername(rs.getString("username"));
		guide.setPassword(rs.getString("password"));
		guide.setFullname(rs.getString("fullname"));
		guide.setImage(rs.getString("image")); 
		guide.setBirthday(rs.getDate("birthday"));
		guide.setIdCard(rs.getString("idCard"));
		guide.setGender(rs.getString("gender"));
		guide.setExperience(rs.getInt("experience"));
		guide.setCost(rs.getInt("cost"));
		guide.setDescription(rs.getString("description"));
		guide.setPhone(rs.getString("phone"));
		guide.setEmail(rs.getString("email"));
		guide.setCountry(rs.getString("country"));
		guide.setCity_id(rs.getString("city_id"));
		guide.setStatus(rs.getInt("status"));
		guide.setTour_sum(rs.getInt("tour_sum"));
		guide.setLock_status(rs.getInt("lock_status")); 
		return guide;
	}

}
