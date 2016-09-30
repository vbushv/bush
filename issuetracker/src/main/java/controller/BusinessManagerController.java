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
import support.Pager;
import support.ParamMap;
import vo.BusinessManagerVO;
import vo.CustomerManagerVO;
import vo.ZipCode;


/**
 * @FileName  : BusinessManagerController.java
 * @Project   : issuetracker
 * @Date      : 2014. 6. 02. 
 * @author    : Perter parker
 */

@Controller
@RequestMapping("/businessManager")
public class BusinessManagerController {

	private Logger logger = Logger.getLogger(getClass());

	//service 연결
	@Autowired
	private BusinessManagerService businessManagerService;
	
	@Autowired
	private CustomerManagerService customerManagerService;
	
// businessManager List start
	@RequestMapping("/businessList")
	public String getBusinessList(
			@RequestParam(value="pageNum", required=false, defaultValue="1") Integer pageNum,
			@RequestParam(value="serchBusinessName", required=false) String serchBusinessName,
			ModelMap modelMap,
			BusinessManagerVO businessVO
			){
		
		List<BusinessManagerVO> businessList;
		
		
		// PAGE DEFAULT SETTING
				int pageNumCount = 3; 
				int pageListCount = 5; 
				
				ParamMap map = new ParamMap(pageNum, pageListCount, pageNumCount);
				
				// GET LIST COUNT
				map.put("co_name", serchBusinessName);
				
				int totalCount = businessManagerService.getBusinessTotalCount(map);
				
				// PAGE SETTING
				Pager pager = new Pager(pageNum, pageListCount, pageNumCount, totalCount);
				modelMap.put("pager", pager.makePaging());
				modelMap.put("pageNum", pageNum);
				
				
				try {
					
					// LIST SEARCH BUTTON VO SETTING
					// 변경하면서 GET LIST COUNT 에 vo setting 됨.(14.6.02)
					
					
					// CUSTOMER LIST SERVICE EXECUTE
					businessList = businessManagerService.getBusinessList(map);
				} catch(Exception e) {
					
					return "redirect:/jsp/login/login.jsp";
				}
				
				try {
					// MODEL INSERT
					modelMap.put("businessList", businessList);
					modelMap.put("serchBusinessName", serchBusinessName);

				} catch(Exception e) {
					
					return "redirect:/jsp/login/login.jsp";
				}
		
		return "/businessManager/businessList";
	}
// businessManager List end	
	
// businessManager View start
	@RequestMapping("/businessView")
	public String getBusinessView(
			@RequestParam(value="co_id", required=true) String co_id,
			@RequestParam(value="pageNum", required=true) String pageNum,
			ModelMap modelMap,
			BusinessManagerVO businessVO,
			CustomerManagerVO customerVO){
		
		businessVO = businessManagerService.getBusinessView(co_id);
		
		
		List<CustomerManagerVO> customerList;
		ParamMap map = new ParamMap(1, 10, 3);
		map.put("cu_company", businessVO.getCo_name());
		customerList = customerManagerService.getCustomerList(map);
		modelMap.put("customerList", customerList);
		
		String co_call[] = new String[3];
		
		co_call = businessVO.getCo_call().split("-");
		
		logger.info("============>" + co_call);
		
		modelMap.put("businessView", businessVO);
		modelMap.put("pageNum", pageNum);
		/*modelMap.put("co_call1", co_call[0]);
		modelMap.put("co_call2", co_call[1]);
		modelMap.put("co_call3", co_call[2]);*/
		modelMap.put("co_call", co_call);
		
		return "/businessManager/businessView";
	}
// businessManager View end
	
// businessManager Write start	
	@RequestMapping("/businessWrite")
	public String getBusinessWrite(){
		
		return "/businessManager/businessWrite";
	}
// businessManager Write end

// businessManager Submit(addBusinessWrite) start
	@RequestMapping(value="/businessSubmit", method=RequestMethod.POST)
	public String addBusinessWrite(
			@ModelAttribute BusinessManagerVO businessVO, //이게무슨 의미냐면 @ModelAttribute ==> 해당 변수를 몽땅 받아온다 기준은 BusinessManagerVO 여기에 등록된 변수만
/*			@RequestParam(value="co_name", required=true) String co_name,
			@RequestParam(value="co_address1", required=false) String co_address1,
			@RequestParam(value="co_address2", required=false) String co_address2,*/
			@RequestParam(value="bu_co_call1", required=false) String co_call1,
			@RequestParam(value="bu_co_call2", required=false) String co_call2,
			@RequestParam(value="bu_co_call3", required=false) String co_call3,
			ModelMap modelMap
			){
		
		logger.info("Co_name=============>"+businessVO.getCo_name());
		logger.info("Co_address1=============>"+businessVO.getCo_address1());
		logger.info("Co_address2=============>"+businessVO.getCo_address2());
		logger.info("Co_postcode=============>"+businessVO.getCo_postcode());
		logger.info("co_call1=============>"+co_call1);
		logger.info("co_call2=============>"+co_call2);
		logger.info("co_call3=============>"+co_call3);
		logger.info("Co_etc============>"+businessVO.getCo_etc());
		
		//DB에 정보를 입력하기 위한 변환하는 구문.
		try {
			
			Random rand = new Random();
			//여기에서 부터 하나로 된 전화번호가 불리 되어 정보가 넘어감.
			String co_call = co_call1 + "-" + co_call2 + "-" + co_call3;
			
			//VO 설정
			businessVO.setCo_id("co" + rand.nextInt(1000)); // co_id 랜덤 생성
			businessVO.setCo_call(co_call);
			
			logger.info(businessVO.getCo_id());
			logger.info(businessVO.getCo_call());
			
			//쿼리 적용(?)
			int result = businessManagerService.addBusiness(businessVO);
		
			logger.info("result===============>"+result);
			
		} catch (Exception e) {
			logger.info("Failed to INSERT Exception : " + e.getMessage());
			return "redirect:/businessManager/businessWrite.do";
		}
		
			return "redirect:/businessManager/businessList.do";
	}
// businessManager Submit(addBusinessWrite) end

// businessManager Modify start 뷰페이지의 수정내용을 보낼 때 사용하는 구문.
	@RequestMapping("/businessModify")
	public String getBusinessModify(
			@RequestParam(value="co_id", required=true)	String co_id,
			ModelMap modelMap,
			BusinessManagerVO businessVO
			){
			
		try {
			
			businessVO = businessManagerService.getBusinessView(co_id);
			
		} catch (Exception e) {
			
			return "redirect:/businessManager/businessView.do?co_id=" + co_id;
		}
			
			String co_call[] = new String[3];
			
			co_call = businessVO.getCo_call().split("-");
			
		try {
			
			modelMap.put("businessView", businessVO);
			modelMap.put("co_call", co_call);
			
		} catch (Exception e) {
			return "redirect:/businessManager/businessView.do?co_id=" + co_id;
		}	
				return "/businessManager/businessModify";
			
	}
// businessManager Modify end 	
	
// businessManager Update start
	@RequestMapping("/businessUpdateSubmit")
	public String updataBusiness(
			@RequestParam(value="co_id", required=true) String co_id,
			@RequestParam(value="co_name", required=false) String co_name,
			@RequestParam(value="co_address1", required=false) String co_address1,
			@RequestParam(value="co_address2", required=false) String co_address2,
			@RequestParam(value="co_postcode", required=false) String co_postcode,
			@RequestParam(value="bu_co_call1", required=false) String bu_co_call1,
			@RequestParam(value="bu_co_call2", required=false) String bu_co_call2,
			@RequestParam(value="bu_co_call3", required=false) String bu_co_call3,
			@RequestParam(value="co_etc", required=false) String co_etc,
			ModelMap modelMap,
			BusinessManagerVO businessVO
			){
			
		String co_call = bu_co_call1 + "-" + bu_co_call2 + "-" + bu_co_call3;
		
		businessVO.setCo_id(co_id);
		businessVO.setCo_name(co_name);
		businessVO.setCo_address1(co_address1);
		businessVO.setCo_address2(co_address2);
		businessVO.setCo_postcode(co_postcode);
		businessVO.setCo_call(co_call);
		businessVO.setCo_etc(co_etc);
		
		try {
			businessManagerService.updateBusiness(businessVO);
		} catch (Exception e) {
			return "redirect:/businessManager/businessView.do?co_id=" + co_id;
		}
		
		return "redirect:/businessManager/businessView.do?co_id=" + co_id;
	}
	
// businessManager Update end	
	
	
// businessManager Delete start.
	@RequestMapping("/businessDeleteSubmit")
	public String delectBusiness(
			@RequestParam(value="co_id", required=true) String co_id,
			ModelMap modelMap,
			BusinessManagerVO businessVO
			) {
				
			try {
				businessManagerService.deleteBusiness(co_id);
			} catch (Exception e) {
				return "redirect:/businessManager/businessView.do?co_id=" + co_id;
			}
		
		
		return "redirect:/businessManager/businessList.do";
		
	}
//businessManaber Delete end.

	
// businessManaber Zipcode search start
@RequestMapping("/zipCode")	
	public String businessZip(
			@RequestParam(value="searchText", required=false, defaultValue="0") String searchText,
			ModelMap modelMap,
			ZipCode zipCodeVO
			) {
	
		if(searchText.equals("") == true) {
			return "redirect:/businessManager/zipCode.do";
			} else {
				List<ZipCode> zipList;
				zipCodeVO.setDong(searchText);
				zipList = businessManagerService.getZipCode(zipCodeVO);
				modelMap.put("zipList", zipList);
			}
		return "/businessManager/zipCode";
	}
//businessManaber Zipcode search end

//businessManaber Popup start
@RequestMapping("/businessPopup")
	public String businessPopup (
			@RequestParam(value="cu_id", required=true) String cu_id,
			ModelMap modelMap,
			CustomerManagerVO customerVO
			
			){

		customerVO = customerManagerService.getCustomerView(cu_id);
		String cu_co_call[] = new String[3];
		String cu_ps_call[] = new String[3];
		String cu_email[] = new String[2];
		
		cu_co_call = customerVO.getCu_co_call().split("-");
		cu_ps_call = customerVO.getCu_ps_call().split("-");
		cu_email = customerVO.getCu_email().split("@");
		
		modelMap.put("customerView", customerVO);
		modelMap.put("cu_co_call", cu_co_call);
		modelMap.put("cu_ps_call", cu_ps_call);
		modelMap.put("cu_email", cu_email);
		return "/businessManager/businessPopup";

	}
}
//businessManaber Popup end




////businessManager List start
//	@RequestMapping("/businessList")
//	public String getBusinessList(
//			ModelMap modelMap,
//			BusinessManagerVO businessVO){
//		
//		List<BusinessManagerVO> businessList = businessManagerService.getBusinessList(businessVO);
//		
//		
//		modelMap.put("businessList", businessList);
//		
//		return "/businessManager/businessList";
//	}
////businessManager List end	
	
