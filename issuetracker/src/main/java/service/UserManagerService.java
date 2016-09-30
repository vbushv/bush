package service;

import java.util.List;

import support.ParamMap;
import vo.UserManagerVO;

/**
 * @FileName  : UserManagerService.java
 * @Project   : issuetracker
 * @Date      : 2014. 4. 30. 
 * @author    : bush
 */
public interface UserManagerService {
	
	public int getUserTotalCount(ParamMap map);
	
	public int addUser(UserManagerVO userVO);
	
	public List getUserList(ParamMap map);
	
	public UserManagerVO getUserView(String userId);
	
	public int editUser(UserManagerVO userVO);
	
	public int deleteUser(String userId);
}
