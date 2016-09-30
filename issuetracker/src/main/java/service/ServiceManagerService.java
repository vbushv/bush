package service;

import java.util.HashMap;
import java.util.List;

import support.ParamMap;

public interface ServiceManagerService {

	public List getServiceList(ParamMap map);
	
	public int getServiceTotalCount(HashMap hashMap);
}