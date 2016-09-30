package service;

import java.util.List;

import support.ParamMap;
import vo.ProjectManagerVO;

/**
 * @FileName  : ProjectManagerService.java
 * @Project   : issuetracker
 * @Date      : 2014. 5. 21. 
 * @author    : bush
 */
public interface ProjectManagerService {

	public int getProjectTotalCount(ParamMap map);
	
	public List getProjectList(ParamMap map); 
	
	public ProjectManagerVO getProjectView(String pj_id);
	
	public int addProject(ProjectManagerVO projectVO);
	
	public int editProject(ProjectManagerVO projectVO);
	
	public int delProject(String pj_id);
}
