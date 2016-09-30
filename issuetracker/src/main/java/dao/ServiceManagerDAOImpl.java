package dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import support.ParamMap;
import vo.ServiceManagerVO;

@Repository
public class ServiceManagerDAOImpl implements ServiceManagerDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public int getServiceTotalCount(HashMap hashMap) {
		return sqlSession.selectOne("getServiceTotalCount", hashMap);
	}
	
	public List<ServiceManagerVO> getServiceList(HashMap hashMap) {
		return sqlSession.selectList("getServiceList", hashMap);
	}
}