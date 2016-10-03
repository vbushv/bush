package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import service.BlueService;
import service.HelloService;

@Controller
public class HellWorldController {

	//여기서 Service 호출하려면 어떻게 해야되죠?
	//HelloService service = new HelloServiceImpl(); //Servlet 방식
	@Autowired // <-- 알아서 주입해줌 그냥 가갖다쓰면 됨
	private HelloService service; // <-- 이거랑 위에꺼랑 똑같음
	
	@Autowired
	private BlueService blueService;
	
	@RequestMapping("/hello/helloWorld") //url 주소를 만들어주는곳 RequestMapping 이건 스프링 문법중에 하나 url 만들어주는거 WebServlet 이랑 비슷한 개념
	public String helloWorld(
			ModelMap modelMap
			){
		
		String msg = "HelloWorld!!!";
		
		//modelMap.addAttribute("msg", msg); // 쪼금 바ㅜ뀌었음 나머진 거의 동일하죠?
		modelMap.addAttribute("msg", service.msg()); // 쪼금 바ㅜ뀌었음 나머진 거의 동일하죠?
		modelMap.addAttribute("message", service.message()); // 쪼금 바ㅜ뀌었음 나머진 거의 동일하죠?
		
		return "hello/helloWorld"; //jsp 경로를 지정해주는곳
		// 나머지는 컨테이너(스프링) 에서 알아서 다 해줌 
	}
	
	@RequestMapping("/dooga/blue0546") //url 주소를 만들어주는곳
	public String dooga(
			ModelMap modelMap
			){
		
		String msg = "안녕!! 공부 재미있지???";
		
		modelMap.addAttribute("msg", msg); // 쪼금 바ㅜ뀌었음 나머진 거의 동일하죠?
		
		return "dooga/blue0546"; //jsp를 지정해줌 그러니까 jsp에 위 로직을 전부 보내줌 이것만 알면 되요
		// 나머지는 컨테이너(스프링) 에서 알아서 다 해줌 
	}
	
	@RequestMapping("/blue0546/dooga") //url 주소를 만들어주는곳
	public String blue0546(
			ModelMap modelMap
			){
		
		String msg = "안녕!! 공부 재미있지???";
		
		modelMap.addAttribute("msg", blueService.msg()); // 쪼금 바ㅜ뀌었음 나머진 거의 동일하죠?
		
		return "blue0546/dooga"; //jsp를 지정해줌 그러니까 jsp에 위 로직을 전부 보내줌 이것만 알면 되요
		// 나머지는 컨테이너(스프링) 에서 알아서 다 해줌 
	}		
	
}
