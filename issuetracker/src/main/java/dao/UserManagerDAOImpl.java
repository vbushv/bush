package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vo.UserManagerVO;


/**
 * @FileName  : UserManagerDAOImpl.java
 * @Project   : issuetracker
 * @Date      : 2014. 4. 30. 
 * @author    : bush
 */
@Repository
public class UserManagerDAOImpl implements UserManagerDAO{

	@Autowired
	private SqlSession sqlSession;

	@Override
	public HashMap getPwdByUserId(String userId){
		return sqlSession.selectOne("getPwdByUserId", userId);
	}

	@Override
	@Transactional
	public int addUser(UserManagerVO userVO) {
		return sqlSession.insert("addUser", userVO);
	}

	@Override
	public List<UserManagerVO> getList(HashMap hashMap) {
		return sqlSession.selectList("getUserList", hashMap);
	}

	@Override
	public UserManagerVO getView(String userId) {
		return sqlSession.selectOne("getUserView", userId);
	}

	@Override
	public int getUserTotalCount(HashMap hashMap) {
		return sqlSession.selectOne("getUserTotalCount", hashMap);
	}

	@Override
	public int editUser(UserManagerVO userVO) {
		return sqlSession.update("editUser", userVO);
	}

	@Override
	public int deleteUser(String userId) {
		return sqlSession.delete("deleteUser", userId);
	}
	
}
