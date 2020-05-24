package dtu.cdio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dtu.cdio.dao.GuestDAO;
import dtu.cdio.model.Guest;

@Service
@Transactional
public class GuestService {
	
	@Autowired
	private GuestDAO guestDAO;
	
	public int addItem(Guest guest) {
		return guestDAO.addItem(guest);
	}
}
