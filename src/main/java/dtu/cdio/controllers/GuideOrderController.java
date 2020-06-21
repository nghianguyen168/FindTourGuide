package dtu.cdio.controllers;

import java.sql.Date;
import java.sql.Timestamp;

import javax.servlet.annotation.MultipartConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dtu.cdio.model.Guide_Order;
import dtu.cdio.service.GuideOderService;


@RestController
@RequestMapping("tour")
public class GuideOrderController {

	@Autowired
	private GuideOderService guideOderService;
	
	//0 => Cancel
	//1 => dang doi confirm
	//2 => confirm-> trong tour
	//3 =? Da xong
	@RequestMapping(value = "book",method = RequestMethod.POST)
	public int book(@ModelAttribute("guide_Oder") Guide_Order guide_Order) {
		return guideOderService.book(guide_Order.getGuest_id(), guide_Order.getGuest_id(), guide_Order.getFrom_day(), guide_Order.getThro_day(), guide_Order.getPlace(), guide_Order.getCost());
	}
	@RequestMapping(value = "confirm",method = RequestMethod.GET)
	public int confirm_Tour(@RequestParam("guide_id") int guide_id,@RequestParam("order_id") int order_id) {
		int confirm =guideOderService.confirm_order(order_id,guide_id);
		if(confirm>0) {
			
		}
		return  confirm;
	}
	
	@RequestMapping(value = "gcancel",method = RequestMethod.GET)
	public int guide_cancel_tour(@RequestParam("guide_id") int guide_id,@RequestParam("order_id") int order_id) {
		return guideOderService.guide_cancel_order(order_id, guide_id);
	}
	@RequestMapping(value = "success",method =RequestMethod.GET )
	public int success_tour(@RequestParam("order_id") int order_id) {
		return guideOderService.success_tour(order_id);
	}
	
	
}
