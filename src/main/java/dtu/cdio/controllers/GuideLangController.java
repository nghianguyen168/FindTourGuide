package dtu.cdio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFormat;

import dtu.cdio.model.Guest;
import dtu.cdio.model.GuideLanguage;
import dtu.cdio.service.GuestService;
import dtu.cdio.service.GuideLangService;

@RestController
@RequestMapping("guideLanguage")
@JsonFormat
public class GuideLangController {
	
	@Autowired
	private GuideLangService guideLangService;
	

	public GuideLangController() {}
	

	// crud
	@RequestMapping(value = "guideLang", method = RequestMethod.POST) 
	public int create(@ModelAttribute("GuideLanguage") GuideLanguage guideLanguage) {
		return guideLangService.addItem(guideLanguage);
	}
	
}
