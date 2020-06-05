package dtu.cdio.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dtu.cdio.model.GuestMapper;
import dtu.cdio.model.Guide;
import dtu.cdio.model.GuideMapper;
import utils.DefineUtil;

@Repository
public class GuideDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Guide> findAll(){
		List<Guide> guiList = new ArrayList<Guide>();
		final String SQL="SELECT guide.*,city.* FROM guide INNER JOIN city ON guide.city_id = city.city_id ORDER BY tour_sum DESC";
		return jdbcTemplate.query(SQL, new BeanPropertyRowMapper<>(Guide.class));
		
	}public List<Guide> findAllByPage(int offset){
		List<Guide> guiList = new ArrayList<Guide>();
		final String SQL="SELECT guide.*,city.* FROM guide INNER JOIN city ON guide.city_id = city.city_id ORDER BY tour_sum DESC LIMIT ?,?";
		return jdbcTemplate.query(SQL, new BeanPropertyRowMapper<>(Guide.class),offset,DefineUtil.NUMBER_PER_PAGE);
		
	}
	//ok
	public List<Guide> getItemByPlace(String city_id) {
		final String SQL="SELECT * FROM guide WHERE city_id=?";
		return jdbcTemplate.query(SQL, new GuideMapper(), city_id);
	}
	
	public List<Guide> searchGuide(String location,Date startDate,Date endDate,String lang){
		final String sql="	SELECT * FROM guide AS g INNER JOIN guide_lang AS gl on g.guide_id = gl.guide_id INNER JOIN guide_time AS gt WHERE gl.lang_name=? AND g.city_id=? \r\n" + 
				"AND gt.from_date <=? AND gt.thro_day>=?";
		return jdbcTemplate.query(sql,new BeanPropertyRowMapper(Guide.class),lang,location,startDate,endDate);
	
	}
	
	//ok
	public List<Guide> getItemByGender(String gender) {
		final String SQL="SELECT * FROM guide WHERE gender=?";
		return jdbcTemplate.query(SQL,new GuideMapper(), gender);
	}
	
	//ok
	public int addItem(Guide guide) {
		final String SQL="INSERT INTO guide(username,password,fullname,image,birthday,idCard_before,idCard_after,gender,experience,cost,"
				+ "description,phone,email,country,city_id) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		return jdbcTemplate.update(SQL,guide.getUsername(),guide.getPassword(),guide.getFullname(),
				guide.getImage(),guide.getBirthday(),guide.getIdCard_before(),guide.getIdCard_after(),
				guide.getGender(),guide.getExperience(),guide.getCost(),guide.getDecription(),
				guide.getPhone(),guide.getEmail(),guide.getCountry(),guide.getCity_id());
	}
	
	
	public int editItem(Guide guide) {
		final String SQL="UPDATE guide SET username=?,password=?,fullname=?,image=?,birthday=?,idCard_before=?,idCard_after=?,gender=?,experience=?,cost=?,"
				+ "description=?,phone=?,email=?,country=?,city=? WHERE guide_id=?";
		return jdbcTemplate.update(SQL,guide.getUsername(),guide.getPassword(),guide.getFullname(),
				guide.getImage(),guide.getBirthday(),guide.getIdCard_before(),guide.getIdCard_after(),
				guide.getGender(),guide.getExperience(),guide.getCost(),guide.getDecription(),
				guide.getPhone(),guide.getEmail(),guide.getCountry(),guide.getCity_id(),guide.getGuide_id());
	}
	
	//ok
	public Guide getItemById(int guide_id) {
		final String SQL="SELECT * FROM guide WHERE guide_id=?";
		return jdbcTemplate.queryForObject(SQL, new GuideMapper(), guide_id);
	}
	
	//ok
	public int LockAccount(int guide_id) {
		String SQL="UPDATE guide SET status=0 WHERE guide_id=?";
		return jdbcTemplate.update(SQL,guide_id);
	}
	
	//ok
	public int UnlockAccount(int guide_id) {
		String SQL="UPDATE guide SET status=1 WHERE guide_id=?";
		return jdbcTemplate.update(SQL,guide_id);
	}
	
	//ok
	public int delGuide(int guide_id) {
		final String SQL="DELECT FROM guide WHERE guide_id=?";
		return jdbcTemplate.update(SQL,guide_id);
	}
	
	//ok
	public int up_Tour_Ofguide(int guide_id) {
		final String SQL="UPDATE guide SET tour_sum=tour_sum+1 WHERE guide_id=?";
		return jdbcTemplate.update(SQL,guide_id);	}
}
