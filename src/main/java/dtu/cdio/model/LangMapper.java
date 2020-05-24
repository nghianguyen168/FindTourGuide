package dtu.cdio.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class LangMapper implements RowMapper<GuideLanguage> {

	@Override
	public GuideLanguage mapRow(ResultSet rs, int rowNum) throws SQLException {
		GuideLanguage guideLang = new GuideLanguage();
		guideLang.setGuide_id(rs.getInt("id"));
		guideLang.setGuide_id(rs.getInt("guide_id"));
		guideLang.setLang_name(rs.getString("lang_name"));
		return guideLang;
	}
	

}
