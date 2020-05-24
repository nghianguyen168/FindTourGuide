package dtu.cdio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dtu.cdio.dao.LangDAO;
import dtu.cdio.model.GuideLanguage;

@Service
@Transactional
public class GuideLangService {
	
	@Autowired
	private LangDAO langDAO;
	
	public int addItem(GuideLanguage guideLanguage) {
		System.out.println(guideLanguage.getLang_name());
		return langDAO.addItem(guideLanguage);
	}
}
