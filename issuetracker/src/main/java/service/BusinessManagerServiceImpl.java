package service;

import java.util.HashMap;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.BusinessManagerDAO;

import support.ParamMap;
import vo.BusinessManagerVO;
import vo.ZipCode;

/**
 * @FileName  : BusinessManagerService.java
 * @Project   : issuetracker
 * @Date      : 2014. 6. 02. 
 * @author    : Perter parker
 */

@Service
public class BusinessManagerServiceImpl implements BusinessManagerService{
	
	@Autowired
	private BusinessManagerDAO businessManagerDAO;
	
	@Override
	public int addBusiness(BusinessManagerVO businessVO) {
		
		return businessManagerDAO.addBusiness(businessVO);
	}

	@Override
	public List getBusinessList(ParamMap map) {
		
		HashMap hashMap = new HashMap();
		hashMap.put("startNum", map.getStartNum());
		hashMap.put("endNum", map.getEndNum());
		hashMap.put("co_name", map.get("co_name"));
		
		return businessManagerDAO.getBusinessList(hashMap);
	}

	@Override
	public BusinessManagerVO getBusinessView(String co_id) {
		
		return businessManagerDAO.getBusinessView(co_id);
	}

	@Override
	public int deleteBusiness(String co_id) {
		
		return businessManagerDAO.deleteBusiness(co_id);
	}

	@Override
	public int updateBusiness(BusinessManagerVO businessVO) {
		
		return businessManagerDAO.getBusinessUpdate(businessVO);
	}

	@Override
	public int getBusinessTotalCount(ParamMap map) {
		
		HashMap hashMap = new HashMap();
		hashMap.put("co_name", map.get("co_name"));
		
		return businessManagerDAO.getBusinessTotalCount(hashMap);
	}

	@Override
	public List getZipCode(ZipCode zipCodeVO) {
		
		return businessManagerDAO.getZipCode(zipCodeVO);
	}
	

}
