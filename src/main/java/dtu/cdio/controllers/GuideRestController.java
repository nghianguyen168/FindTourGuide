package dtu.cdio.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dtu.cdio.model.Guide;
import dtu.cdio.service.GuideService;
import utils.DefineUtil;

@RestController
@RequestMapping("guide")

public class GuideRestController {

	@Autowired
	private GuideService guideService;

	  
	    
	@RequestMapping("/rest")
	@ResponseBody
	public String welcome() {
		return "Welcome to RestTemplate Example.";
	}
	
	@RequestMapping(value = "/index",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Guide> gistGuideList(@RequestParam("page") int curentPage){
		int numberOfItems = guideService.findAll().size();
		int numberOfPages = (int)(numberOfItems/DefineUtil.NUMBER_PER_PAGE);
		if(numberOfPages*DefineUtil.NUMBER_PER_PAGE<guideService.findAll().size()) {
			numberOfPages+=1;
		}
		
		if(curentPage>numberOfPages || curentPage<1) {
			curentPage=1;
		}
		int offset = (curentPage  - 1)* DefineUtil.NUMBER_PER_PAGE;
		System.out.println(curentPage);
		return guideService.findAllByPage(offset);
	}
	
	@RequestMapping(value = "search",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Guide> guideSearch(@RequestParam("location") String location,@RequestParam("startDate") Date startDate,@RequestParam("endDate") Date endDate,@RequestParam("language") String language){
		return guideService.searchGuide(location, startDate, endDate, language);
	}
	@RequestMapping( value = "index/{place}",method =RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Guide> listByPlace(@PathVariable("place") String place){
		return guideService.getItemByPlace(place);
	}
	
	@RequestMapping(value = "gender/{gender}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Guide> getListByGender(@PathVariable("gender") String gender){
		return guideService.getItemByGender(gender);
	}
	@RequestMapping(value = "info/{guide_id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Guide  getGuideById(@PathVariable("guide_id") int guide_id) {
		return guideService.getGuideById(guide_id);
	}
	
}
