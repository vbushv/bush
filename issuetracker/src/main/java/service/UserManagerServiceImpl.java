package service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import support.ParamMap;
import vo.UserManagerVO;
import dao.UserManagerDAO;

/**
 * @FileName  : UserManagerServiceImpl.java
 * @Project   : issuetracker
 * @Date      : 2014. 4. 30. 
 * @author    : bush
 */
@Service
public class UserManagerServiceImpl implements UserManagerService{

	@Autowired
	private UserManagerDAO userManagerDAO;
	
	
	@Override
	public int addUser(UserManagerVO userVO){
		return userManagerDAO.addUser(userVO);
	}

	@Override
	public List getUserList(ParamMap map) {
				
		HashMap hashMap = new HashMap();
		hashMap.put("startNum", map.getStartNum());
		hashMap.put("endNum", map.getEndNum());
		hashMap.put("IdSearch", map.get("IdSearch"));
		hashMap.put("NameSearch", map.get("NameSearch"));
		
		List list = userManagerDAO.getList(hashMap);
		
		return list;
	}

	@Override
	public UserManagerVO getUserView(String userId) {
		return userManagerDAO.getView(userId);
	}

	@Override
	public int getUserTotalCount(ParamMap map) {
		
		HashMap hashMap = new HashMap();
		hashMap.put("IdSearch", map.get("IdSearch"));
		hashMap.put("NameSearch", map.get("NameSearch"));
		
		return userManagerDAO.getUserTotalCount(hashMap);
	}

	@Override
	public int editUser(UserManagerVO userVO) {
		return userManagerDAO.editUser(userVO);
	}

	@Override
	public int deleteUser(String userId) {
		return userManagerDAO.deleteUser(userId);
	}
}
