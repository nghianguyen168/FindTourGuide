package dtu.cdio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dtu.cdio.dao.TestDAO;
import dtu.cdio.model.Test;

@Transactional
@Service
public class TestService {

	@Autowired
	private TestDAO testDAO;
	
	public List<Test> testList(){
		return testDAO.userList();
	}
}
