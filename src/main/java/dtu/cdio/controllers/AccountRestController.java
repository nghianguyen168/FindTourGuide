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
@RequestMapping("Guest")

public class GuideRestController {

	@Autowired
	private GuestService guestService;

	  
	    
	@RequestMapping("/guest")
	@ResponseBody
	public String welcome() {
		return "Welcome to RestTemplate Example.";
	}
	
    @RequestMapping(value = "/addGuest", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public GuestService addGuest(@RequestBody Guest guest) { 
        return guestService.addItem(emp);
    }
	
    
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public GuestService guestLogin(@RequestBody String username,String password) {

        return guestService.guestLogin(username,password);
    }
	
    @RequestMapping(value = "/checkGuest", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public GuestService checkGuest(@RequestBody String username) {
	
	return guestService.checkGuest(username);
	}
    
    @RequestMapping(value = "/editGuest", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public GuestService editGuest(@RequestBody Guest guest) {
	
	return guestService.editItem(guest);
	}

}
