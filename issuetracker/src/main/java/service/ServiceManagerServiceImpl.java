package service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ServiceManagerDAO;

import support.ParamMap;

@Service
public class ServiceManagerServiceImpl implements ServiceManagerService {
	
	@Autowired
	private ServiceManagerDAO serviceManagerDAO;
	
	@Override
	public List getServiceList(ParamMap map) {
		
		HashMap hashMap = new HashMap();
		hashMap.put("startNum", map.getStartNum());
		hashMap.put("endNum", map.getEndNum());
		/*hashMap.put("sm_name", map.get("sm_name"));
		hashMap.put("sm_company", map.get("sm_company"));
		hashMap.put("sm_status", map.get("sm_status"));*/
		
		return serviceManagerDAO.getServiceList(hashMap);
	}
	
	@Override
	public int getServiceTotalCount(HashMap hashMap) {
		return serviceManagerDAO.getServiceTotalCount(hashMap);
	}
}