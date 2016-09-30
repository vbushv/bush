package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vo.BusinessManagerVO;
import vo.ZipCode;


@Repository
public class BusinessManagerDAOImpl implements BusinessManagerDAO {

	@Autowired
	private SqlSession sqlSession;
	
	//등록시 사용.
	@Override
	@Transactional
	public int addBusiness(BusinessManagerVO businessVO) {
		
		return sqlSession.insert("addBusiness", businessVO);
	}

	@Override
	public List<BusinessManagerVO> getBusinessList(HashMap hashMap) {
		
		return sqlSession.selectList("getBusinessList", hashMap);
	}
	
	@Override
	public int getBusinessTotalCount(HashMap hashMap){
		return sqlSession.selectOne("getBusinessTotalCount" , hashMap);
	}

	@Override
	public BusinessManagerVO getBusinessView(String co_id) {
		
		return sqlSession.selectOne("getBusinessView", co_id);
	}

	@Override
	@Transactional
	public int deleteBusiness(String co_id) {
		
		return sqlSession.delete("deleteBusiness", co_id);
	}

	@Override
	public int getBusinessUpdate(BusinessManagerVO businessVO) {
		
		return sqlSession.update("getBusinessUpdate", businessVO);
	}

	@Override
	public List<ZipCode> getZipCode(ZipCode zipCodeVO) {
	
		return sqlSession.selectList("getZipCode", zipCodeVO);
	}

}