package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HellWorldController {

	@RequestMapping("/helloWorld")
	public String helloWorld(
			ModelMap modelMap
			){
		
		String msg = "HelloWorld!!!";
		
		modelMap.addAttribute("msg", msg);
		
		return "helloWorld";
	}	
}
/*RedirectAttributes redirectAttributes*/