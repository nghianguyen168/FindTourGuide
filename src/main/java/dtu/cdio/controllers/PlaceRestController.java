package dtu.cdio.controllers;

import java.util.List;

import javax.servlet.annotation.MultipartConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFormat;

import dtu.cdio.model.Place;
import dtu.cdio.service.PlaceService;

@CrossOrigin(origins = "*")
@MultipartConfig
@RestController
@RequestMapping("place")
@JsonFormat
public class PlaceRestController {

	@Autowired
	private PlaceService placeService;

	@GetMapping("index")
	public List<Place> findAll(){
		return placeService.findAll();
	}
	
	@GetMapping("top")
	public List<Place> getTop(){
		return placeService.getTopPlace();
	}
}
