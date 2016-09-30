package dao;

import java.util.HashMap;
import java.util.List;

import vo.ProjectManagerVO;

/**
 * @FileName  : ProjectManagerDAO.java
 * @Project   : issuetracker
 * @Date      : 2014. 5. 21. 
 * @author    : bush
 */
public interface ProjectManagerDAO {

	public int getProjectTotalCount(HashMap hashMap);
	
	public List getProjectList(HashMap hashMap);
	
	public ProjectManagerVO getProjectView(String pj_id);
	
	public int addProject(ProjectManagerVO projectVO);
	
	public int editProject(ProjectManagerVO projectVO);
	
	public int delProject(String pj_id);
}
