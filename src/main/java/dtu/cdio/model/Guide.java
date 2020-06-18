package dtu.cdio.model;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Guide {
	private int guide_id;
	private String username;
	private String password;
	private String fullname;
	private String image;
	private Timestamp birthday;
	private String idCard_before;
	private String idCard_after;
	private String gender;
	private int experience;
	private int cost;
	private String decription;
	private String phone;
	private String email;
	private String country;
	private String city_id;
	private int status;
	private int tour_sum;
	
	
}
