package dtu.cdio.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dtu.cdio.dao.GuideOrderDAO;
import dtu.cdio.model.Guide;

@Service
public class GuideOderService {
	
	@Autowired
	private GuideOrderDAO guideOrderDAO;
	
	public int book(int guide_id,int user_id,Date from_day,Date thro_date,String place,int cost) {
		return guideOrderDAO.book(guide_id, user_id, from_day, thro_date, place, cost);
	}
	public int confirm_order(int order_id,int guide_id) {
		return guideOrderDAO.confirm(order_id,guide_id);
	}
	public int guide_cancel_order(int order_id,int guide_id) {
		return guideOrderDAO.guide_cancel(order_id,guide_id);
	}
	public int success_tour(int order_id) {
		return guideOrderDAO.success_tour(order_id);
	}
	public List<Guide> guide_history_book(int guide_id){
		return guideOrderDAO.guide_history_book(guide_id);
	}
}
