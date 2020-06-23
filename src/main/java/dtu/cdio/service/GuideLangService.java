package dtu.cdio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dtu.cdio.dao.LangDAO;
import dtu.cdio.model.GuideLanguage;
import dtu.cdio.model.Language;

@Service
@Transactional
public class GuideLangService {
	
	@Autowired
	private LangDAO langDAO;
	
	public int addItem(GuideLanguage guideLanguage) {
		System.out.println(guideLanguage.getLang_name());
		return langDAO.addItem(guideLanguage);
	}
	public List<Language> findAll(){
		return langDAO.findAll();
	}
}
