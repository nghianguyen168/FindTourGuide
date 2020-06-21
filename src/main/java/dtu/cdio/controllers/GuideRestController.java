package dtu.cdio.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFormat;

import dtu.cdio.model.Guide;
import dtu.cdio.service.GuideService;
import utils.DefineUtil;
import utils.RandomPasswordUtils;
import utils.SendGmailUtil;
import utils.StringUtil;

@CrossOrigin( origins = "*" )
@RestController
@RequestMapping("guide")
@JsonFormat
public class GuideRestController {

	@Autowired
	private GuideService guideService;

	@RequestMapping("/rest")
	public String welcome() {
		return "Welcome to RestTemplate Example.";
	}
	

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public List<Guide> gistGuideList(@RequestParam("page") int curentPage) {
		int numberOfItems = guideService.findAll().size();
		int numberOfPages = (int) (numberOfItems / DefineUtil.NUMBER_PER_PAGE);
		if (numberOfPages * DefineUtil.NUMBER_PER_PAGE < guideService.findAll().size()) {
			numberOfPages += 1;
		}

		if (curentPage > numberOfPages || curentPage < 1) {
			curentPage = 1;
		}
		int offset = (curentPage - 1) * DefineUtil.NUMBER_PER_PAGE;
		System.out.println(curentPage);
		return guideService.findAllByPage(offset);
	}

	@CrossOrigin
	@RequestMapping(value = "search", method = RequestMethod.GET)
	public List<Guide> guideSearch(@RequestParam("location") String location, @RequestParam("country") String country,
			@RequestParam("startDate") Date startDate, @RequestParam("endDate") Date endDate,
			@RequestParam("language") String language) {
		return guideService.searchGuide(location, startDate, endDate, language, country);
	}

	@CrossOrigin
	@RequestMapping(value = "index/{place}", method = RequestMethod.GET)
	public List<Guide> listByPlace(@PathVariable("place") String place) {
		return guideService.getItemByPlace(place);
	}

	@CrossOrigin
	@RequestMapping(value = "gender/{gender}", method = RequestMethod.GET)
	public List<Guide> getListByGender(@PathVariable("gender") String gender) {
		return guideService.getItemByGender(gender);
	}

	@CrossOrigin
	@RequestMapping(value = "info/{guide_id}",method = RequestMethod.GET)
	public Guide  getGuideById(@PathVariable("guide_id") int guide_id) {
		return guideService.getGuideById(guide_id);
	}

	@CrossOrigin
	@RequestMapping(value = "add",method = RequestMethod.POST)
	public int addGuideUser(@ModelAttribute("guide") Guide guide) {
		return guideService.addItem(guide);
	}
	
	@CrossOrigin
	@RequestMapping(value = "create_guide/{guideId}",method = RequestMethod.GET)
	public int access_guide(@PathVariable int guideId) {
		Guide guide = guideService.getGuideById(guideId);
		String username =guide.getUsername();
		String password = RandomPasswordUtils.randomAlphaNumeric(8);
		guide.setPassword(StringUtil.md5(password));
		guideService.editItem(guide);
		String sub ="Successfully be a guide with FiGuide";
		String msg ="Your guide account is:"
				+ "\n Username: "+username+""
				+ "\n Password: "+password;
		SendGmailUtil.sendGmail(guide.getEmail(), sub, msg);
		return guideService.unlockAccountGuide(guideId);
	}
	
}
