package dtu.cdio.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Place {
	private int place_id;
	private String place_name;
	private int count_book;
	private String image;
	
}
