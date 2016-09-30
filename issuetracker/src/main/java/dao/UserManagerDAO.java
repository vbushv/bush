package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import vo.UserManagerVO;


/**
 * @FileName  : UserManagerDAO.java
 * @Project   : issuetracker
 * @Date      : 2014. 4. 30. 
 * @author    : bush
 */
public interface UserManagerDAO {

	public int getUserTotalCount(HashMap hashMap);
	
	public List<UserManagerVO> getList(HashMap hashMap);
	
	public UserManagerVO getView(String userId);
	
	public HashMap getPwdByUserId(String userId);
	
	public int addUser(UserManagerVO userVO);
	
	public int editUser(UserManagerVO userVO);
	
	public int deleteUser(String userId);
	
}
