package controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import service.UserManagerService;
import support.Pager;
import support.ParamMap;
import vo.UserManagerVO;

/**
 * @FileName  : UserManagerController.java
 * @Project   : issuetracker
 * @Date      : 2014. 4. 30. 
 * @author    : bush
 */
@Controller
@RequestMapping("/userManager")
@SessionAttributes("userVO")
public class UserManagerController {

	private Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private UserManagerService userManagerService;
	
	@RequestMapping("/userWrite")
	public String getWrite(
			ModelMap modelMap,
			UserManagerVO userVO
			){
		
		modelMap.addAttribute("userVO", userVO);
		
		return "/userManager/userWrite";
	}
	
	@RequestMapping(value="/userSubmit", method=RequestMethod.POST)
	public String addUser(
			@ModelAttribute UserManagerVO userVO,
			@RequestParam(value="user_ps_call1", required=false) String user_ps_call1,
			@RequestParam(value="user_ps_call2", required=false) String user_ps_call2,
			@RequestParam(value="user_ps_call3", required=false) String user_ps_call3,
			@RequestParam(value="user_co_call1", required=false) String user_co_call1,
			@RequestParam(value="user_co_call2", required=false) String user_co_call2,
			@RequestParam(value="user_co_call3", required=false) String user_co_call3,
			@RequestParam(value="user_email1", required=false) String user_email1,
			@RequestParam(value="user_email2", required=false) String user_email2,
			SessionStatus sessionStatus,
			ModelMap modelMap
			){
		
		userVO.setUser_ps_call(user_ps_call1+"-"+user_ps_call2+"-"+user_ps_call3);
		userVO.setUser_co_call(user_co_call1+"-"+user_co_call2+"-"+user_co_call3);
		userVO.setUser_email(user_email1+"@"+user_email2);
		
		int result = userManagerService.addUser(userVO);
		logger.info("============>"+result);
		
		if(result == 1) sessionStatus.setComplete();
		
		return "redirect:/userManager/userList.do";
	}
	
	@RequestMapping("/userList")
	public String getUserList(
			@RequestParam(value="pageNum", required=false, defaultValue="1") Integer pageNum,
			@RequestParam(value="IdSearch", required=false) Integer IdSearch,
			@RequestParam(value="NameSearch", required=false) Integer NameSearch,
			ModelMap modelMap,
			UserManagerVO userVO
			){

		
		int pageNumCount = 5; //한페이지당 페이징갯수
		int pageListCount = 10; //한페이지당 리스트갯수
		
		ParamMap map = new ParamMap(pageNum, pageListCount, pageNumCount);
		
		map.put("IdSearch", IdSearch);
		map.put("NameSearch", NameSearch);
		
		List<UserManagerVO> userList = userManagerService.getUserList(map);
		modelMap.put("userList", userList);
		
		int totalCount = userManagerService.getUserTotalCount(map);
		
		Pager pager = new Pager(pageNum, pageListCount, pageNumCount, totalCount);
		modelMap.put("pager", pager.makePaging());
		modelMap.put("IdSearch", IdSearch);
		modelMap.put("NameSearch", NameSearch);		
		modelMap.put("pageNum", pageNum);
		
		return "/userManager/userList";
	}
	
	@RequestMapping("/userView")
	public String getUserView(
			@RequestParam(value="userId", required=true) String userId,
			ModelMap modelMap,
			UserManagerVO userVO
			){
		
		userVO = userManagerService.getUserView(userId);
		
		logger.debug("userVO ==> "+userVO);
		
		modelMap.put("userVO", userVO);
		
		return "/userManager/userView";
	}
	
	@RequestMapping(value="/userEdit", method=RequestMethod.GET)
	public String getUserModify(
			@RequestParam(value="userId", required=true) String userId,
			ModelMap modelMap,
			UserManagerVO userVO
			){
		
		userVO = userManagerService.getUserView(userId);
		
		modelMap.put("userVO", userVO);
		
		return "/userManager/userEdit";
		
	}
	
	@RequestMapping(value="/userEditSubmit", method=RequestMethod.POST)
	public String editUser(
			@ModelAttribute UserManagerVO userVO,
			@RequestParam(value="user_ps_call1", required=false) String user_ps_call1,
			@RequestParam(value="user_ps_call2", required=false) String user_ps_call2,
			@RequestParam(value="user_ps_call3", required=false) String user_ps_call3,
			@RequestParam(value="user_co_call1", required=false) String user_co_call1,
			@RequestParam(value="user_co_call2", required=false) String user_co_call2,
			@RequestParam(value="user_co_call3", required=false) String user_co_call3,
			@RequestParam(value="user_email1", required=false) String user_email1,
			@RequestParam(value="user_email2", required=false) String user_email2,
			SessionStatus sessionStatus,
			ModelMap modelMap
			){
		
		userVO.setUser_ps_call(user_ps_call1+"-"+user_ps_call2+"-"+user_ps_call3);
		userVO.setUser_co_call(user_co_call1+"-"+user_co_call2+"-"+user_co_call3);
		userVO.setUser_email(user_email1+"@"+user_email2);
		
		int result = userManagerService.editUser(userVO);
		
		if(result == 1) sessionStatus.setComplete();
		
		logger.info(result);
		
		return "redirect:/userManager/userView.do?userId="+userVO.getUser_id();
	}
	
	@RequestMapping("/userDel")
	public String delUser(
			@RequestParam(value="userId", required=true) String userId,
			ModelMap modelMap
			){
		
		int result = userManagerService.deleteUser(userId);
		
		logger.info(result);
		
		return "redirect:/userManager/userList.do";
	}
	
}
