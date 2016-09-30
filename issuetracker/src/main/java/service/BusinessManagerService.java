package service;

import java.util.List;

import support.ParamMap;
import vo.BusinessManagerVO;
import vo.ZipCode;

/**
 * @FileName  : BusinessManagerService.java
 * @Project   : issuetracker
 * @Date      : 2014. 6. 02. 
 * @author    : Perter parker
 */
public interface BusinessManagerService {
	
	public int addBusiness(BusinessManagerVO businessVO); 
	
	public List getBusinessList(ParamMap map);
	
	public BusinessManagerVO getBusinessView(String co_id);

	public int deleteBusiness(String co_id);

	public int updateBusiness(BusinessManagerVO businessVO);

	public List getZipCode(ZipCode zipCodeVO);

	public int getBusinessTotalCount(ParamMap map);

	
}
