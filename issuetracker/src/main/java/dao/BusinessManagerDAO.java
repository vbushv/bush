package dao;

import java.util.HashMap;
import java.util.List;



import vo.BusinessManagerVO;
import vo.ZipCode;

public interface BusinessManagerDAO {

	
	public List <BusinessManagerVO> getBusinessList(HashMap hashMap);

	public BusinessManagerVO getBusinessView(String co_id);
	
	public int addBusiness(BusinessManagerVO businessVO);

	public int deleteBusiness(String co_id);

	public int getBusinessUpdate(BusinessManagerVO businessVO);

	public int getBusinessTotalCount(HashMap hashMap);

	public List<ZipCode> getZipCode(ZipCode zipCodeVO);

	
}