package dao;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import vo.CustomerManagerVO;

public interface CustomerManagerDAO {
	
	public int addCustomer(CustomerManagerVO customerVO);
	
	public List<CustomerManagerVO> getCustomerList(HashMap hashMap);
	
	public CustomerManagerVO getCustomerView(String cu_id);
	
	public int deleteCustomer(String cu_id);
	
	public int updateCustomer(CustomerManagerVO customerVO);
	
	public List<CustomerManagerVO> getCustomerCompanyList(CustomerManagerVO customerVo);
	
	public int getCustomerTotalCount();
}