package dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.ProjectManagerVO;

/**
 * @FileName  : ProjectManagerDAOImpl.java
 * @Project   : issuetracker
 * @Date      : 2014. 5. 21. 
 * @author    : bush
 */
@Repository
public class ProjectManagerDAOImpl implements ProjectManagerDAO{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int getProjectTotalCount(HashMap hashMap){
		return sqlSession.selectOne("getProjectTotalCount", hashMap);
	}
	
	@Override
	public List getProjectList(HashMap hashMap) {
		return sqlSession.selectList("getProjectList", hashMap);
	}

	@Override
	public ProjectManagerVO getProjectView(String pj_id) {
		return sqlSession.selectOne("getProjectView", pj_id);
	}

	@Override
	public int addProject(ProjectManagerVO projectVO) {
		return sqlSession.insert("addProject", projectVO);
	}

	@Override
	public int editProject(ProjectManagerVO projectVO) {
		return sqlSession.update("editProject", projectVO);
	}

	@Override
	public int delProject(String pj_id) {
		return sqlSession.delete("delProject", pj_id);
	}

}
