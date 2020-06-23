package dtu.cdio.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dtu.cdio.model.Guide;
import dtu.cdio.model.GuideMapper;
import utils.DefineUtil;

@Repository
public class GuideDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Guide> findAll() {
		List<Guide> guiList = new ArrayList<Guide>();
		final String SQL = "SELECT guide.*,city.* FROM guide INNER JOIN city ON guide.city_id = city.city_id WHERE status=0 AND lock_status=0 ORDER BY tour_sum DESC";
		return jdbcTemplate.query(SQL, new BeanPropertyRowMapper<>(Guide.class));

	}

	public List<Guide> findAllByPage(int offset) {
		List<Guide> guiList = new ArrayList<Guide>();
		final String SQL = "SELECT guide.*,city.* FROM guide INNER JOIN city ON guide.city_id = city.city_id WHERE status=0 AND lock_status=0 ORDER BY tour_sum DESC LIMIT ?,?";
		return jdbcTemplate.query(SQL, new BeanPropertyRowMapper<>(Guide.class), offset, DefineUtil.NUMBER_PER_PAGE);
	}

	// ok
	public List<Guide> getItemByPlace(String city_id) {
		final String SQL = "SELECT * FROM guide WHERE city_id=? AND status=0 AND lock_status=0";
		return jdbcTemplate.query(SQL, new GuideMapper(), city_id);
	}
	public List<Guide> getItemByLAng(String lang) {
		final String SQL = "SELECT * FROM guide INNER JOIN guide_lang ON guide.guide_id=guide_lang.guide_id WHERE lang_name=? AND status=0 AND lock_status=0";
		return jdbcTemplate.query(SQL, new BeanPropertyRowMapper<>(Guide.class), lang);
	}

	public List<Guide> searchGuide(String city, Date startDate, Date endDate, String lang, String country) {
		
		final String sql = "SELECT g.* FROM guide AS g INNER JOIN guide_lang AS gl on g.guide_id = gl.guide_id INNER JOIN guide_time AS gt ON g.guide_id=gt.guide_id WHERE gl.lang_name=? AND g.country=?  AND g.city_id=? \r\n"
				+ "AND gt.from_date <= ? AND gt.thro_day>=? AND g.status	=0 AND g.lock_status=0";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Guide.class),lang,country,city,startDate,endDate);

	}
	public static void main(String[] args) {
		System.out.println( new GuideDAO().searchGuide("", null, null, "", ""));
	}
	// ok
	public List<Guide> getItemByGender(String gender) {
		final String SQL = "SELECT * FROM guide WHERE gender=? AND status=0 AND lock_status=0";
		return jdbcTemplate.query(SQL, new GuideMapper(), gender);
	}

	// ok
	public int addItem(Guide guide) {
		final String SQL = "INSERT INTO guide(username,password,fullname,image,birthday,idCard,gender,experience,cost,"
				+ "description,phone,email,country,city_id) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		return jdbcTemplate.update(SQL, guide.getUsername(), guide.getPassword(), guide.getFullname(), guide.getImage(),
				guide.getBirthday(), guide.getIdCard(), guide.getGender(), guide.getExperience(), guide.getCost(),
				guide.getDescription(), guide.getPhone(), guide.getEmail(), guide.getCountry(), guide.getCity_id());
	}

	public int editItem(Guide guide) {
		final String SQL = "UPDATE guide SET username=?,password=?,fullname=?,image=?,birthday=?,idCard=?,gender=?,experience=?,cost=?,"
				+ "description=?,phone=?,email=?,country=?,city_id=? WHERE guide_id=?";
		return jdbcTemplate.update(SQL, guide.getUsername(), guide.getPassword(), guide.getFullname(), guide.getImage(),
				guide.getBirthday(), guide.getIdCard(), guide.getGender(), guide.getExperience(), guide.getCost(),
				guide.getDescription(), guide.getPhone(), guide.getEmail(), guide.getCountry(), guide.getCity_id(),
				guide.getGuide_id());
	}

	// ok
	public Guide getItemById(int guide_id) {
		final String SQL = "SELECT * FROM guide WHERE guide_id=? ";
		return jdbcTemplate.queryForObject(SQL, new BeanPropertyRowMapper<>(Guide.class), guide_id);
	}
	public Guide getItemByName(String username) {
		final String SQL = "SELECT * FROM guide WHERE username=? ";
		return jdbcTemplate.queryForObject(SQL, new BeanPropertyRowMapper<>(Guide.class), username);
	}


	// ok
	public int LockAccount(int guide_id) {
		String SQL = "UPDATE guide SET status=0 WHERE guide_id=" + guide_id;
		return jdbcTemplate.update(SQL, guide_id);
	}

	// ok
	public int UnlockAccount(int guide_id) {
		String SQL = "UPDATE guide SET lock_status=0 WHERE guide_id=?";
		return jdbcTemplate.update(SQL, guide_id);
	}

	// ok
	public int delGuide(int guide_id) {
		final String SQL = "DELECT FROM guide WHERE guide_id=?";
		return jdbcTemplate.update(SQL, guide_id);
	}

	// ok
	public int up_Tour_Ofguide(int guide_id) {
		final String SQL = "UPDATE guide SET tour_sum=tour_sum+1 WHERE guide_id=?";
		return jdbcTemplate.update(SQL, guide_id);
	}

	public Guide guideLogin(String username, String password) {
		final String sql = "SELECT * FROM guide WHERE username=? AND password=? AND lock_status=0";
		try {
			return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Guide.class), username, password);
		} catch (Exception e) {
			return null;
		}
	}

	public Boolean checkMail(String mail) {
		Guide checkMail = null;
		final String sql = "SELECT * FROM guide WHERE email=?";
		try {
			jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Guide.class), mail);
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	public Boolean checkUsername(String username) {
		Guide checkMail = null;
		final String sql = "SELECT * FROM guide WHERE username=?";
		try {
			jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Guide.class), username);
		} catch (Exception e) {
			return false;
		}

		return true;
	}
	public Boolean checkIdCard(String idCard) {
		Guide checkMail = null;
		final String sql = "SELECT * FROM guide WHERE idCard=?";
		try {
			jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Guide.class), idCard);
		} catch (Exception e) {
			return false;
		}

		return true;
	}
	
	public List<Guide> topGuide(){
		List<Guide> topGuideList = new ArrayList<Guide>();
		final String sql = "SELECT guide.*,city.* FROM guide INNER JOIN city ON guide.city_id = city.city_id WHERE status=0 AND lock_status=0 ORDER BY guide.tour_sum DESC LIMIT 10 ";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Guide.class));
	}


}
