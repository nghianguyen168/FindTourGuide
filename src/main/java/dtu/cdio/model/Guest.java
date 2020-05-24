package dtu.cdio.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Guest {
	private int guest_Id;
	private String username;
	private String password;
	private String fullname;
	private Timestamp date_Of_Birth;
	private String image;
	private String country;
	private String email;
	private String phone;
	private int status;
	public Guest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
