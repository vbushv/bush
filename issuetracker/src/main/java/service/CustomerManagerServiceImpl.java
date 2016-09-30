package service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CustomerManagerDAO;

import support.ParamMap;
import vo.CustomerManagerVO;

@Service
public class CustomerManagerServiceImpl implements CustomerManagerService {
	
	@Autowired
	private CustomerManagerDAO customerManagerDAO;
	
	@Override
	public int addCustomer(CustomerManagerVO customerVO) {
		return customerManagerDAO.addCustomer(customerVO);
	}
	
	@Override
	public List getCustomerList(ParamMap map) {
		
		HashMap hashMap = new HashMap();
		hashMap.put("startNum", map.getStartNum());
		hashMap.put("endNum", map.getEndNum());
		hashMap.put("cu_name", map.get("cu_name"));
		hashMap.put("cu_company", map.get("cu_company"));
		
		return customerManagerDAO.getCustomerList(hashMap);
	}
	
	@Override
	public CustomerManagerVO getCustomerView(String cu_id) {
		return customerManagerDAO.getCustomerView(cu_id);
	}
	
	@Override
	public int deleteCustomer(String cu_id) {
		return customerManagerDAO.deleteCustomer(cu_id);
	}
	
	@Override
	public int updateCustomer(CustomerManagerVO customerVO) {
		return customerManagerDAO.updateCustomer(customerVO);
	}
	
	@Override
	public List getCustomerCompanyList(CustomerManagerVO customerVO){
		return customerManagerDAO.getCustomerCompanyList(customerVO);
	}
	
	@Override
	public int getCustomerTotalCount() {
		return customerManagerDAO.getCustomerTotalCount();
	}
}