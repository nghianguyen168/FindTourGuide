package dtu.cdio.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dtu.cdio.model.GuideLanguage;
import dtu.cdio.model.Language;

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
	
	public List<Language> findAll(){
		final String sql="SELECT * FROM language";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Language.class));
	}
}
