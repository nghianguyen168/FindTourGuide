package dtu.cdio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dtu.cdio.dao.LangDAO;
import dtu.cdio.dao.PlaceDAO;
import dtu.cdio.model.GuideLanguage;
import dtu.cdio.model.Place;

@Service
@Transactional
public class PlaceService {
	
	@Autowired
	private PlaceDAO placeDAO;
	
	public List<Place> findAll(){
		return placeDAO.findAll();
	}
	
	public List<Place> getTopPlace(){
		return placeDAO.getTopPlace();
	}
}
