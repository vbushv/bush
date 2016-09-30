package controller;

import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import service.BusinessManagerService;
import service.CustomerManagerService;
import service.ProjectManagerService;
import support.Pager;
import support.ParamMap;
import vo.BusinessManagerVO;
import vo.CustomerManagerVO;
import vo.ProjectManagerVO;
import vo.ZipCode;


@Controller
@RequestMapping("/customerManager")
public class CustomerManagerController {
	
private Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private CustomerManagerService customerManagerService;
	
	@Autowired
	private BusinessManagerService businessManagerService;
	
	@Autowired
	private ProjectManagerService projectManagerService;
	
	@RequestMapping("/customerList")
	public String getList(
			@RequestParam(value="pageNum", required=false, defaultValue="1") Integer pageNum,
			@RequestParam(value="serchCustomerName", required=false) String serchCustomerName,
			@RequestParam(value="serchCustomerCompany", required=false) String serchCustomerCompany,
			ModelMap modelMap,
			CustomerManagerVO customerVO
			){
		
		/****************
		 *	SELECT LIST	*
		 ****************/
		
		List<CustomerManagerVO> customerList;
		
		// PAGE DEFAULT SETTING
		int pageNumCount = 5; //한페이지당 페이징갯수
		int pageListCount = 10; //한페이지당 리스트갯수
		
		ParamMap map = new ParamMap(pageNum, pageListCount, pageNumCount);
		
		// GET LIST COUNT
		int totalCount = customerManagerService.getCustomerTotalCount();
		
		// PAGE SETTING
		Pager pager = new Pager(pageNum, pageListCount, pageNumCount, totalCount);
		modelMap.put("pager", pager.makePaging());
		modelMap.put("pageNum", pageNum);
		
		try {
			
			// LIST SEARCH BUTTON VO SETTING
			//customerVO.setCu_name(serchCustomerName);
			//customerVO.setCu_company(serchCustomerCompany);
			map.put("cu_name", serchCustomerName);
			map.put("cu_company", serchCustomerCompany);
			
			// LOG PRINT
			logger.info("serchCustomerName==>"+serchCustomerName);
			logger.info("serchCustomerCompany==>"+serchCustomerCompany);
			
			// CUSTOMER LIST SERVICE EXECUTE
			customerList = customerManagerService.getCustomerList(map);
		} catch(Exception e) {
			logger.info("Failed to Select Query Exception : " + e.getMessage());
			return "redirect:/jsp/login/login.jsp";
		}
		
		try {
			// MODEL INSERT
			modelMap.put("customerList", customerList);
			modelMap.put("serchCustomerName", serchCustomerName);
			modelMap.put("serchCustomerCompany", serchCustomerCompany);
		} catch(Exception e) {
			logger.info("Failed to ModelMap put Exception : " + e.getMessage());
			return "redirect:/jsp/login/login.jsp";
		}
		
		return "/customerManager/customerList";
	}
	
	@RequestMapping("/customerWrite")
	public String getWrite(
			ModelMap modelMap,
			CustomerManagerVO customerVO,
			BusinessManagerVO businessVO
			) {
		
		List<BusinessManagerVO> companyList;
		ParamMap map = new ParamMap(1, 9999, 1);
		
		// EXECUTE QUERY
		try {
			companyList = businessManagerService.getBusinessList(map);
			// 아직 거래처 검색 기능 없음
		} catch(Exception e) {
			logger.info("Failed to SELECT Exception : " + e.getMessage());
			return "redirect:/customerManager/customerList.do";
		}
		
		try {
			// MODEL INSERT
			modelMap.put("companyList", companyList);
		} catch(Exception e) {
			logger.info("Failed to ModelMap put Exception : " + e.getMessage());
			return "redirect:/customerManager/customerList.do";
		}
		
		return "/customerManager/customerWrite";
	}
	
	@RequestMapping(value="/customerSubmit", method=RequestMethod.POST)
	public String addWrite(
			@ModelAttribute CustomerManagerVO customerVO,
			@RequestParam(value="cu_name", required=true) String cu_name,
			@RequestParam(value="cu_company", required=false) String cu_company,
			@RequestParam(value="cu_position", required=false) String cu_position,
			@RequestParam(value="cu_ps_call1", required=false) String cu_ps_call1,
			@RequestParam(value="cu_ps_call2", required=false) String cu_ps_call2,
			@RequestParam(value="cu_ps_call3", required=false) String cu_ps_call3,
			@RequestParam(value="cu_co_call1", required=false) String cu_co_call1,
			@RequestParam(value="cu_co_call2", required=false) String cu_co_call2,
			@RequestParam(value="cu_co_call3", required=false) String cu_co_call3,
			@RequestParam(value="cu_email1", required=false) String cu_email1,
			@RequestParam(value="cu_email2", required=false) String cu_email2,
			ModelMap modelMap
			) {
		
		/************
		 *  INSERT	*
		 ************/
		
		try {
			
			Random rand = new Random();
			
			// FORMAT CHANGE
			String cu_ps_call = cu_ps_call1 + "-" + cu_ps_call2 + "-" + cu_ps_call3;
			String cu_co_call = cu_co_call1 + "-" + cu_co_call2 + "-" + cu_co_call3;
			String cu_email = cu_email1 + "@" + cu_email2;
			
			// VO SETTING
			customerVO.setCu_id("cu" + rand.nextInt(1000000000)); // CREATE CU_ID
			customerVO.setCu_ps_call(cu_ps_call);
			customerVO.setCu_co_call(cu_co_call);
			customerVO.setCu_email(cu_email);
			
			// EXECUTE QUERY
			customerManagerService.addCustomer(customerVO);

		} catch(Exception e) {
			logger.info("Failed to INSERT Exception : " + e.getMessage());
			return "redirect:/customerManager/customerWrite.do";
		}
		
		return "redirect:/customerManager/customerList.do";
	}
	
	@RequestMapping("/customerView")
	public String getView(
			@RequestParam(value="cu_id", required=true) String cu_id,
			ModelMap modelMap,
			CustomerManagerVO customerVO,
			BusinessManagerVO businessVO,
			ProjectManagerVO projectVO
			) {
		
		/****************
		 *	SELECT ONE	*
		 ****************/
		
		try {
			// EXECUTE QUERY
			customerVO = customerManagerService.getCustomerView(cu_id);
		} catch(Exception e) {
			logger.info("Failed to SELECT ONE Exception : " + e.getMessage());
			return "redirect:/customerManager/customerList.do";
		}
		
		// ANOTHER LIST - BUSINESS LIST
		List<BusinessManagerVO> businessList;
		ParamMap map1 = new ParamMap(1, 10, 3);
		map1.put("co_name", customerVO.getCu_company());
		businessList = businessManagerService.getBusinessList(map1);
		modelMap.put("businessList", businessList);
		
		// ANOTHER LIST - PROJECT LIST
		/*List<ProjectManagerVO> projectList;
		ParamMap map2 = new ParamMap(1, 10, 3);
		map2.put("pj_co_name", customerVO.getCu_company());
		projectList = projectManagerService.getProjectList(map2);
		modelMap.put("projectList", projectList);*/

		// FORMAT CHANGE
		String cu_ps_call[] = new String[3];
		String cu_co_call[] = new String[3];
		String cu_email[] = new String[2];
		
		cu_ps_call = customerVO.getCu_ps_call().split("-");
		cu_co_call = customerVO.getCu_co_call().split("-");
		cu_email = customerVO.getCu_email().split("@");
			
		// LOG PRINT
		logger.info("============>" + customerVO);
		logger.info("============>" + cu_ps_call);
		logger.info("============>" + cu_co_call);
		logger.info("============>" + cu_email);
		
		try {
			// MODEL INSERT
			modelMap.put("customerView", customerVO);
			modelMap.put("cu_ps_call", cu_ps_call);
			modelMap.put("cu_co_call", cu_co_call);
			modelMap.put("cu_email", cu_email);
		} catch(Exception e) {
			logger.info("Failed to ModelMap put Exception : " + e.getMessage());
			return "redirect:/customerManager/customerList.do";
		}
		return "/customerManager/customerView";
	}
	
	@RequestMapping("/customerModify")
	public String getModity(
			@RequestParam(value="cu_id", required=true) String cu_id,
			ModelMap modelMap,
			CustomerManagerVO customerVO,
			BusinessManagerVO businessVO
			) {
		
		/****************
		 *	SELECT ONE	* 
		 ****************/
		
		List<BusinessManagerVO> companyList;
		ParamMap map = new ParamMap(1, 9999, 1);
		companyList = businessManagerService.getBusinessList(map);
		modelMap.put("companyList", companyList);
		
		try {
			// EXECUTE QUERY
			customerVO = customerManagerService.getCustomerView(cu_id);
		} catch(Exception e) {
			logger.info("Failed to SELECT ONE Exception" + e.getMessage());
			return "redirect:/customerManager/customerView.do?cu_id=" + cu_id;
		}
		
		// FORMAT CHANGE
		String cu_ps_call[] = new String[3];
		String cu_co_call[] = new String[3];
		String cu_email[] = new String[2];
		
		cu_ps_call = customerVO.getCu_ps_call().split("-");
		cu_co_call = customerVO.getCu_co_call().split("-");
		cu_email = customerVO.getCu_email().split("@");
			
		// LOG PRINT
		logger.info("============>" + customerVO);
		logger.info("============>" + cu_ps_call);
		logger.info("============>" + cu_co_call);
		logger.info("============>" + cu_email);
		
		try {
			// MODEL INSERT
			modelMap.put("customerView", customerVO);
			modelMap.put("cu_ps_call", cu_ps_call);
			modelMap.put("cu_co_call", cu_co_call);
			modelMap.put("cu_email", cu_email);
		} catch(Exception e) {
			logger.info("Failed to ModelMap put Exception" + e.getMessage());
			return "redirect:/customerManager/customerView.do?cu_id=" + cu_id;
		}
		
		return "/customerManager/customerModify";
	}
	
	@RequestMapping("/customerDeleteSubmit")
	public String deleteCustomer(
			@RequestParam(value="cu_id", required=true) String cu_id,
			ModelMap modelMap,
			CustomerManagerVO customerVO
			) {
		
		/************
		 *	DELETE	*
		 ************/
		
		try {
			// EXECUTE QUERY
			customerManagerService.deleteCustomer(cu_id);
		} catch(Exception e) {
			logger.info("" + e.getMessage());
			return "redirect:/customerManager/customerView.do?cu_id=" + cu_id;
		}
		
		return "redirect:/customerManager/customerList.do";
	}
	
	@RequestMapping("/customerUpdateSubmit")
	public String updateCustomer(
			@RequestParam(value="cu_id", required=true) String cu_id,
			@RequestParam(value="cu_name", required=false) String cu_name,
			@RequestParam(value="cu_company", required=false) String cu_company,
			@RequestParam(value="cu_position", required=false) String cu_position,
			@RequestParam(value="cu_department", required=false) String cu_department,
			@RequestParam(value="cu_ps_call1", required=false) String cu_ps_call1,
			@RequestParam(value="cu_ps_call2", required=false) String cu_ps_call2,
			@RequestParam(value="cu_ps_call3", required=false) String cu_ps_call3,
			@RequestParam(value="cu_co_call1", required=false) String cu_co_call1,
			@RequestParam(value="cu_co_call2", required=false) String cu_co_call2,
			@RequestParam(value="cu_co_call3", required=false) String cu_co_call3,
			@RequestParam(value="cu_email1", required=false) String cu_email1,
			@RequestParam(value="cu_email2", required=false) String cu_email2,
			@RequestParam(value="cu_etc", required=false) String cu_etc,
			ModelMap modelMap,
			CustomerManagerVO customerVO
			) {
		
		/************
		 *	UPDATE	*
		 ************/
		
		logger.info("cu_id ===========> " + cu_id);
		
		// FORMAT CHANGE
		String cu_ps_call = cu_ps_call1 + "-" + cu_ps_call2 + "-" + cu_ps_call3;
		String cu_co_call = cu_co_call1 + "-" + cu_co_call2 + "-" + cu_co_call3;
		String cu_email = cu_email1 + "@" + cu_email2;
		
		// VE SETTING
		customerVO.setCu_id(cu_id);
		customerVO.setCu_name(cu_name);
		customerVO.setCu_company(cu_company);
		customerVO.setCu_position(cu_position);
		customerVO.setCu_department(cu_department);
		customerVO.setCu_ps_call(cu_ps_call);
		customerVO.setCu_co_call(cu_co_call);
		customerVO.setCu_email(cu_email);
		customerVO.setCu_etc(cu_etc);
		
		try {
			// EXECUTE QUERY
			customerManagerService.updateCustomer(customerVO);
		} catch(Exception e) {
			logger.info("Failed to UPDATE Excpetion : " + e.getMessage());
			return "redirect:/customerManager/customerView.do?cu_id=" + cu_id;
		}
		return "redirect:/customerManager/customerView.do?cu_id=" + cu_id;
	}
	
	@RequestMapping("/customerPopup")
	public String customerPopup (
			@RequestParam(value="co_id", required=true) String co_id,
			ModelMap modelMap,
			BusinessManagerVO businessVO
			) {
		
		businessVO = businessManagerService.getBusinessView(co_id);
		String co_call[] = new String[3];
		co_call = businessVO.getCo_call().split("-");
		modelMap.put("businessView", businessVO);
		modelMap.put("co_call", co_call);
		
		return "/customerManager/customerPopup";
	}
	
}