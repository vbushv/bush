package dao;

import org.springframework.stereotype.Repository;

//이게 DAO 라고 명명해주는거
@Repository
public class HelloDao {

	//dao의 역할은? data access object 
	// 모델을 조합하고 뭐 이런것들을 다 해주는 역할인데요
	// DB랑 연결해주고 DB 내용을 가져와서 모델에 넣어주고 뭐 이런 역할
	
	public String msg(){
		
		String msg = "service에서 가져왔음";
		
		return msg;
	}
	
	public String massage(){
		
		String msg = "service message 으로 가져왔음";
		
		return msg;
	}
	
}
