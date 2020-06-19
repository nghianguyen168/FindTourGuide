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
@RequestMapping("GuideLang")

public class GuideRestController {

	@Autowired
	private GuestService guestService;

	  
	    
	@RequestMapping("/guideLang")
	@ResponseBody
	public String welcome() {
		return "Welcome to guide language Example.";
	}
	
    @RequestMapping(value = "/addGuideLang", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public GuestService addGuest(@RequestBody GuideLanguage guideLanguage) { 
        return GuideLangService.addItem(guideLanguage);
    }
	
   
}
