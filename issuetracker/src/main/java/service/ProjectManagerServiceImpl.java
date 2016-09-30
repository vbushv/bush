package service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import support.ParamMap;
import vo.ProjectManagerVO;
import dao.ProjectManagerDAO;

/**
 * @FileName  : ProjectManagerServiceImpl.java
 * @Project   : issuetracker
 * @Date      : 2014. 5. 21. 
 * @author    : bush
 */
@Service
public class ProjectManagerServiceImpl implements ProjectManagerService{

	@Autowired
	private ProjectManagerDAO projectManagerDAO;
	
	@Override
	public int getProjectTotalCount(ParamMap map) {
		
		HashMap hashMap = new HashMap();
		
		return projectManagerDAO.getProjectTotalCount(hashMap);
	}

	@Override
	public List getProjectList(ParamMap map) {

		HashMap hashMap = new HashMap();
		
		return projectManagerDAO.getProjectList(hashMap);
	}

	@Override
	public ProjectManagerVO getProjectView(String pj_id) {
		return projectManagerDAO.getProjectView(pj_id);
	}

	@Override
	public int addProject(ProjectManagerVO projectVO) {
		return projectManagerDAO.addProject(projectVO);
	}

	@Override
	public int editProject(ProjectManagerVO projectVO) {
		return projectManagerDAO.editProject(projectVO);
	}

	@Override
	public int delProject(String pj_id) {
		return projectManagerDAO.delProject(pj_id);
	}

}
