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
import dtu.cdio.service.GuestService;

@RestController
@RequestMapping("guest")
@JsonFormat
public class GuestController{

	@Autowired
	private GuestService guestService;
	

	public GuestController() {}
	

	// crud
	@RequestMapping(value = "guest", method = RequestMethod.POST) 
	public int create(@ModelAttribute("guest") Guest guest) {
		return guestService.addItem(guest);
	}
	
	
	@RequestMapping(value = "guest/{id}", method = RequestMethod.POST) 
	public int update(@PathVariable int id, @ModelAttribute("guest") Guest guest) {
		return guestService.editItem(guest);
	}
	
	
	@RequestMapping(value = "guest/{id}", method = RequestMethod.GET) 
	public Guest checkGuest(@RequestParam("username") String username) {
		return guestService.checkGuest(username);
	}
	
	
	@RequestMapping(value = "guest", method = RequestMethod.GET) 
	public Guest loginGuest(@RequestParam("username") String username,@RequestParam("password") String password) {
		return guestService.guestLogin(username, password);
	}
}
