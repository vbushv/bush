package support;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Required;

/**
 * @FileName  : ParamMap.java
 * @Project   : issuetracker
 * @Date      : 2014. 5. 13. 
 * @author    : bush
 */
public class ParamMap extends HashMap{
	
	private Integer pageNum; // 페이징번호
	private Integer pageListCount; // 한페이지에 나타날 리스트 갯수
	private Integer pageNumCount; // 한페이지에 나타낼 페이징번호 갯수
	private Integer startNum;
	private Integer endNum;
	
    public Integer getPageNum(){
    	pageNum = Integer.parseInt(this.get("pageNum").toString());
    	return pageNum;
    }

    @Required
	public void setPageNum(Integer pageNum){
    	this.pageNum = pageNum;
    	this.put("pageNum", pageNum);
    }	

    public Integer getPageListCount(){
    	pageListCount = Integer.parseInt(this.get("pageListCount").toString());
    	return pageListCount;
    }
    
    public void setPageListCount(Integer pageListCount){
    	this.pageListCount = pageListCount;
    	this.put("pageListCount", pageListCount);
    }
    
	public Integer getPageNumCount(){
		pageNumCount = Integer.parseInt(this.get("pageNumCount").toString());
		return pageNumCount;
	}
	
	@Required
	public void setPageNumCount(Integer pageNumCount){
		this.pageNumCount = pageNumCount;
		this.put("pageNumCount", pageNumCount);
	}
	
	public ParamMap(){
		setPageNum(pageNum);
		setPageNumCount(pageNumCount);
		setPageListCount(pageListCount);
	}

    public ParamMap(Integer pageNum , Integer pageListCount, Integer pageNumCount) {
        setPageNum(pageNum);
        setPageNumCount(pageNumCount);
        setPageListCount(pageListCount);
    }

	public Integer getStartNum() {
		startNum = ((pageNum - 1) * pageListCount) + 1;
		return startNum;
	}

	public void setStartNum(Integer startNum) {
		this.startNum = startNum;
	}

	public Integer getEndNum() {
		endNum = pageNum * pageListCount;
		return endNum;
	}

	public void setEndNum(Integer endNum) {
		this.endNum = endNum;
	}
	
}
