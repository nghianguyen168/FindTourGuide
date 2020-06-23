package dtu.cdio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFormat;

import dtu.cdio.model.Guest;
import dtu.cdio.model.Language;
import dtu.cdio.service.GuestService;
import dtu.cdio.service.GuideLangService;

@RestController
@JsonFormat
public class LangRestController{

	@Autowired
	private GuideLangService guideLangService;
	

	public LangRestController() {}
	

	// crud
	@RequestMapping(value = "lang", method = RequestMethod.GET) 
	public List<Language> findAll(){
		return guideLangService.findAll();
	}
	

}
