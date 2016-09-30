package dao;

import java.util.HashMap;
import java.util.List;

import support.ParamMap;
import vo.ServiceManagerVO;

public interface ServiceManagerDAO {
	
	public int getServiceTotalCount(HashMap hashMap);
	
	public List<ServiceManagerVO> getServiceList(HashMap hashMap);
	
}