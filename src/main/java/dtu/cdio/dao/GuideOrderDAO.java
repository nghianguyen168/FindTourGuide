package dtu.cdio.dao;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;



@Repository
public class GuideOrderDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public final String INSERT_SQL="INSERT INTO guide_order(guide_id,user_id,from_day,thro_day,place,cost) VALUES(?,?,?,?,?,?)";
	public final String CONFIRM_SQL ="UPDATE guide_order SET status = 2 WHERE order_id=? AND guide_id=?";
	public final String GUIDE_CANCEL_SQL="UPDATE guide_order SET status = 0 WHERE order_id=? AND guide_id=?";
	public final String SUCCESS_TOUR="UPDATE guide_order SET status = 3 WHERE order_id=?";
	
	public int book(int guide_id,int user_id,Date from_day,Date thro_date,String place,int cost) {
		return jdbcTemplate.update(INSERT_SQL,guide_id,user_id,from_day,thro_date,place,cost);
	}
	
	public int confirm(int order_id,int guide_id) {
		return jdbcTemplate.update(CONFIRM_SQL,order_id,guide_id);
	}
	
	public int guide_cancel(int order_id,int guide_id) {
		return jdbcTemplate.update(GUIDE_CANCEL_SQL,order_id,guide_id);
	}
	public int success_tour(int order_id) {
		return jdbcTemplate.update(SUCCESS_TOUR,order_id);
	}
	
	
}
