package dtu.cdio.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GuideLanguage {
	private int lang_id;
	private int guide_id;
	private String lang_name;
	public GuideLanguage() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
