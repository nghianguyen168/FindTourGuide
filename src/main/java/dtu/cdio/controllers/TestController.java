package dtu.cdio.controllers;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import dtu.cdio.dao.TestDAO;
import dtu.cdio.model.Guest;
import dtu.cdio.model.GuideLanguage;
import dtu.cdio.model.Test;
import dtu.cdio.service.GuestService;
import dtu.cdio.service.GuideLangService;
import dtu.cdio.service.TestService;

@Controller
public class TestController {

	@Autowired
	private TestService testService;
	@Autowired 
	private GuideLangService guideLangService;
	@Autowired
	private GuestService guestService;
	@GetMapping("/test")
	public String test() {
		
		List<Test> testList = testService.testList();
		
		System.out.println(testList.size());
		
		GuideLanguage guideLanguage = new GuideLanguage(0, 1, "hihi");
		guideLangService.addItem(guideLanguage);
		
		Guest guest = new Guest(0, "NVN", "123", "hoohi",Timestamp.valueOf("2018-11-12 01:02:03.123456789"), "ad.jpg", "Viet Nam", "nfdhf@gmail.com", "0968997331", 1);
		guestService.addItem(guest);
		return "test";
	}
}
