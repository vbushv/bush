package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.BlueDao;

@Service
public class BlueServiceImpl implements BlueService{

	@Autowired
	private BlueDao blueDao;
	
	@Override
	public String msg() {
		return blueDao.msg();
	}

	
	
}
