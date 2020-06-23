package dtu.cdio.model;


import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Guide_Order {
	private int order_id;
	private int guide_id;
	private int guest_id;
	private Date from_day;
	private Date thro_day;
	private String place;
	private int cost;
	private int status;
	private String guestname;

}
