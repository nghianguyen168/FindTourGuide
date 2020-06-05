package dtu.cdio.controllers;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import dtu.cdio.dao.TestDAO;
import dtu.cdio.model.City;
import dtu.cdio.model.Guest;
import dtu.cdio.model.Guide;
import dtu.cdio.model.GuideLanguage;
import dtu.cdio.model.Test;
import dtu.cdio.service.GuestService;
import dtu.cdio.service.GuideLangService;
import dtu.cdio.service.GuideService;
import dtu.cdio.service.TestService;

@Controller
public class TestController {

	@Autowired
	private TestService testService;
	@Autowired 
	private GuideLangService guideLangService;
	@Autowired
	private GuestService guestService;
	@Autowired GuideService guideService;
	@GetMapping("/test")
	public String test() {
		
		List<Test> testList = testService.testList();
		
		System.out.println(testList.size());
		
		GuideLanguage guideLanguage = new GuideLanguage(0, 1, "hihi");
		guideLangService.addItem(guideLanguage);
		
		
		 Guest guest = new Guest(1, "nghia", "123",
		 "hoohi",Timestamp.valueOf("2018-11-12 01:02:03.123456789"), "ad.jpg",
		 "Viet Nam", "nfdhf@gmail.com", "0968997331", 1); 
		/* guestService.addItem(guest); */
		 
		/*
		 * Guest guest = new Guest(1, "nghia", "123", "Nguyen Van Nghia",
		 * Timestamp.valueOf("2018-11-12 01:02:03.123456789"), "nghia.jpg", "Viet Nam",
		 * "nghianguyen@gmail.com'," + "0968997331", 1);
		 */
		System.out.println(guestService.editItem(guest));
		/* System.out.println(guestService.guestLogin("NVN", "123")); */
		
		/*
		 * Guide guide = new Guide(0, "nghia", "123456", "Nguyen Van Nghia", "",
		 * Timestamp.valueOf("1997-08-16 01:02:03.12345678"), "", "", "male", 1, 20, "",
		 * "", "", "", new City("DN", "Da Nang"), 0,0);
		 * System.out.println(guideService.addItem(guide)); List<Guide> guideList =
		 * guideService.findAll();
		 */
		List<Guide> guideListByPlace = guideService.getItemByGender("female");
		System.out.println(guideListByPlace.size());
		int lockAccount = guideService.unlockAccount(5);
		return "test";
		
		
	}
}
