package service;

import java.util.List;

import support.ParamMap;
import vo.CustomerManagerVO;

public interface CustomerManagerService {
	
	public int addCustomer(CustomerManagerVO customerVO);
	
	public List getCustomerList(ParamMap map);
	
	public CustomerManagerVO getCustomerView(String cu_id);
	
	public int deleteCustomer(String cu_id);
	
	public int updateCustomer(CustomerManagerVO customerVO);
	
	public List getCustomerCompanyList(CustomerManagerVO customerVO);
	
	public int getCustomerTotalCount();
}