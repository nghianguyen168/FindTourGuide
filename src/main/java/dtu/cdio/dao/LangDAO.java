package dtu.cdio.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dtu.cdio.model.GuideLanguage;

@Repository
@Transactional
public class LangDAO {

	@Autowired
	 JdbcTemplate jdbcTemplate;
	
	public  int addItem(GuideLanguage guideLanguage) {
		return jdbcTemplate.update(
			    "INSERT INTO guide_lang(guide_id, lang_name) VALUES (?, ?)",
			    guideLanguage.getGuide_id(), guideLanguage.getLang_name()
			);
		
	}
}
