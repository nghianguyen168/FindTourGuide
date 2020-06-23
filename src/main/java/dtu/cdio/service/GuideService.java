package dtu.cdio.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dtu.cdio.dao.GuideDAO;
import dtu.cdio.model.Guide;

@Service
@Transactional
public class GuideService {

	@Autowired
	private GuideDAO guideDAO;

	public int addItem(Guide guide) {
		return guideDAO.addItem(guide);
	}

	public int editItem(Guide guide) {
		return guideDAO.editItem(guide);
	}

	public Guide getItemByID(int guide_id) {
		return guideDAO.getItemById(guide_id);
	}

	public int lockAccount(int guide_id) {
		return guideDAO.LockAccount(guide_id);
	}

	public int unlockAccount(int guide_id) {
		return guideDAO.UnlockAccount(guide_id);
	}

	public int delGuide(int guide_id) {
		return guideDAO.delGuide(guide_id);
	}

	public int up_Tour_Ofguide(int guide_id) {
		return guideDAO.up_Tour_Ofguide(guide_id);
	}
	public List<Guide> findAll(){
		return guideDAO.findAll();
	}
	public List<Guide> findAllByPage(int offset){
		return guideDAO.findAllByPage(offset);
	}
	public List<Guide> searchGuide(String city,Date startDate,Date endDate,String lang,String country){
		return guideDAO.searchGuide(city, startDate, endDate, lang, country);
	
	}
	
	public Guide getGuideById(int guide_id) {
		return  guideDAO.getItemById(guide_id);
	}
	public List<Guide> getItemByGender(String gender){
		return guideDAO.getItemByGender(gender);
	}
	public List<Guide> getItemByPlace(String city_id){
		return guideDAO.getItemByPlace(city_id);
	}
	public int lockAccountGuide(int guide_id) {
		return guideDAO.LockAccount(guide_id);
	}
	public int unlockAccountGuide(int guide_id) {
		return guideDAO.UnlockAccount(guide_id);
	}
	public Guide guideLogin(String username,String password) {
		return guideDAO.guideLogin(username, password);
	}
	
	public Boolean checkUsername(String username) {
		return guideDAO.checkUsername(username);
	}
	
	public Boolean checkMail(String mail) {
		return guideDAO.checkMail(mail);
		
	}
	public Boolean checkIdCard(String idCard) {
		return guideDAO.checkIdCard(idCard);
	}
	public List<Guide> getTopGuideList(){
		return guideDAO.topGuide();
	}
	
	
	


}
