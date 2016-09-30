package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vo.CustomerManagerVO;

@Repository
public class CustomerManagerDAOImpl implements CustomerManagerDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	@Transactional
	public int addCustomer(CustomerManagerVO customerVO) {
		return sqlSession.insert("addCustomer", customerVO);
	}
	
	@Override
	public List<CustomerManagerVO> getCustomerList(HashMap hashMap) {
		return sqlSession.selectList("getCustomerList", hashMap);
	}
	
	@Override
	public CustomerManagerVO getCustomerView(String cu_id) {
		return sqlSession.selectOne("getCustomerView", cu_id);
	}
	
	@Override
	@Transactional
	public int deleteCustomer(String cu_id) {
		return sqlSession.delete("deleteCustomer", cu_id);
	}
	
	@Override
	@Transactional
	public int updateCustomer(CustomerManagerVO customerVO) {
		return sqlSession.update("updateCustomer", customerVO);
	}
	
	@Override
	public List<CustomerManagerVO> getCustomerCompanyList(CustomerManagerVO customerVO) {
		return sqlSession.selectList("getCustomerCompanyList", customerVO);
	}
	
	@Override
	public int getCustomerTotalCount() {
		return sqlSession.selectOne("getCustomerTotalCount");
	}
}