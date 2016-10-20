package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.HelloDao;

// 이 파일이 서비스다! 라고 스프링에게 알려주면 되요
@Service
public class HelloServiceImpl implements HelloService{ // 인터페이스를 구현했음 

	//HelloDao dao = new HelloDao(); // 서블릿 방식
	
	@Autowired
	private HelloDao dao; //service에서 dao 빈을 못찾음 빈을 넣어줘야함
	
	@Override
	public String msg() {
		
		String msg = dao.msg();
		
		return msg;
	}

	@Override
	public String message() {
		
		String msg = dao.massage();
		
		return msg;
	}
	
	
}
