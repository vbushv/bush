package controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import service.ProjectManagerService;
import vo.ProjectManagerVO;

/**
 * @FileName  : ProjectManagerController.java
 * @Project   : issuetracker
 * @Date      : 2014. 5. 21. 
 * @author    : bush
 */
@Controller
@SessionAttributes("projectVO")
@RequestMapping("/projectManager")
public class ProjectManagerController {

	@Autowired
	private ProjectManagerService projectManagerService;
	
	Logger logger = Logger.getLogger(getClass());
	
	@RequestMapping(value="/projectWrite", method=RequestMethod.GET)
	public String getProjectWrite(
			@ModelAttribute ProjectManagerVO projectVO,
			@RequestParam(value="mode", required=true) String mode,
			ModelMap modelMap
			){
	
		if("write".equals(mode)){
			
			modelMap.addAttribute("mode", "write");
			
		}else if("update".equals(mode)){

			projectVO = projectManagerService.getProjectView(projectVO.getPj_id());
			
			modelMap.addAttribute("mode", "update");
			modelMap.addAttribute("projectVO", projectVO);
			
		}
		
		return "/projectManager/projectWrite";
	}
	
	@RequestMapping(value="/projectSubmit.do", method=RequestMethod.POST)
	public String addProject(
			@ModelAttribute ProjectManagerVO projectVO,
			@RequestParam(value="mode", required=true) String mode,
			@RequestParam Map<String, String> pjMap,
			ModelMap modelMap,
			SessionStatus sessionStatus
			//BindingResult result
			){
		
		String returnUrl = "";
		
		/*if(result.hasErrors()){
			return "/projectManager/projectWrite";
		}*/
		
		if("write".equals(mode)){
			
			logger.info("mode ==>"+ pjMap.get("mode"));
			logger.info("test1 ==>"+ pjMap.get("test1"));
			logger.info("test2 ==>"+ pjMap.get("test2"));
			logger.info("test3 ==>"+ pjMap.get("test3"));
			logger.info("projectVO ==>"+ projectVO.toString());
			
			//int addResult = projectManagerService.addProject(projectVO);
			//sessionStatus.setComplete();
			
			//if(addResult == 1){
				returnUrl = "/projectManager/projectList";
			//}
			
		}else if("update".equals(mode)){
		
			int editResult = projectManagerService.editProject(projectVO);
			
			if(editResult == 1){
				returnUrl = "/projectManager/projectView.do?pj_id="+projectVO.getPj_id();
			}
			
		}

		return returnUrl;
	}
	
	@RequestMapping("/projectList")
	public String getProjectList(){
		
		return "/projectManager/projectList";
	}
	
	@RequestMapping("/projectDelete")
	public String delProject(
			@RequestParam(value="pj_id", required=true) String pj_id,
			ModelMap modelMap
			){
	
		int result = projectManagerService.delProject(pj_id);
		
		logger.info(result);
		
		return "redirect:/projectManager/projectList.do";
	}
	
}
