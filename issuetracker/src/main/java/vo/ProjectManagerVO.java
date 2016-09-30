package vo;

import lombok.Data;


/**
 * @FileName  : ProjectManagerVO.java
 * @Project   : issuetracker
 * @Date      : 2014. 5. 19. 
 * @author    : bush
 */

@Data
public class ProjectManagerVO {

	private String pj_id;
	private String pj_co_name;
	private String pj_address;
	private String pj_name;
	private String pj_st_date;
	private String pj_en_date;
	private int pj_cost;
	private String pj_sales;
	private String responsibility;
	private String pj_content;
	private String pj_reg_date;
	private String[] pj_company;
}
