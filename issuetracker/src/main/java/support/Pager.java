package support;

/**
 * @FileName  : Pager.java
 * @Project   : issuetracker
 * @Date      : 2014. 5. 13. 
 * @author    : bush
 */
public class Pager{

	private int pageNum; // 현재페이지번호
	private int pageNumCount; // 한페이지당 번호갯수
	private int pageMaxNumCount; //최고번호
	
	private int totalCount; // 총 줄갯수
	private int pageListCount; // 한페이지당 줄 갯수
	
	private int startPage; // 페이징 시작번호
	private int endPage; // 페이징 마지막번호
	
	public int getPageNum(){
		return pageNum;
	}
	
	public void setPageNum(int pageNum){
		this.pageNum = pageNum;
	}
	
	public int getPageListCount() {
		return pageListCount;
	}
	
	public void setPageListCount(int pageListCount) {
		this.pageListCount = pageListCount;
	}
	
	public int getStartPage(){
		if(0 == startPage){
			setPageStartEnd();
		}
		return startPage;
	}
	
	public void setStartPage(int startPage){
		this.startPage = startPage;
	}
	
	public int getEndPage() {
		if(0 == endPage){
			setPageStartEnd();
		}		
		return endPage;
	}
	
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
	public int getTotalCount(){
		return totalCount;
	}
	
	public void setTotalCount(int totalCount){
		this.totalCount = totalCount;
	}
	
	public int getPageNumCount(){
		return pageNumCount;
	}
	
	public void setPageNumCount(int pageNumCount){
		this.pageNumCount = pageNumCount;
	}
	
	//최고번호 세팅
	public int getPageMaxNumCount(){
    	if(getTotalCount() < getPageListCount() || 0 == getPageListCount()){
    		pageMaxNumCount = 1;
    	}else{
    		if((getTotalCount() % getPageListCount()) == 0){
    			pageMaxNumCount = getTotalCount() / getPageListCount();
    		}else{
    			pageMaxNumCount = getTotalCount() / getPageListCount() + 1;
    		}
    	}
		return pageMaxNumCount;
	}

	public void setPageMaxNumCount(int pageMaxNumCount) {
		this.pageMaxNumCount = pageMaxNumCount;
	}

	public Pager(Integer pageNum, Integer pageListCount, Integer pageNumCount, Integer totalCount){
				
		setPageNum(pageNum);
		setPageListCount(pageListCount);
		setPageNumCount(pageNumCount);
		setTotalCount(totalCount);

	}
	
	// 시작번호, 끝번호 세팅
    public void setPageStartEnd(){
    	if(pageNum < (getPageNumCount()+1)){
    		startPage = 1;
    	}else{
    		if(0 == (getPageNum() % getPageNumCount())){
    			startPage = getPageNum() - (getPageNumCount() - 1);
    		}else{
    			startPage = getPageNum() - (getPageNum() % getPageNumCount()) + 1;
    		}
    	}

    	if(startPage + getPageNumCount() - 1 > getPageMaxNumCount()){
    		endPage = getPageMaxNumCount();
    	}else{
    		endPage = startPage + (getPageNumCount() - 1);
    	}
    }
// 페이징 처리 구문 strat
	public String makePaging(){
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("<ul class='pagination'>");
		
		if(getPageNum() != 1){
			sb.append("<li id='prev'><a href='javascript:pageMove("+1+")'>&lt;&lt;</a></li>");
			sb.append("<li id='prev'><a href='javascript:pageMove("+(getPageNum()-1)+")'>&lt;</a></li>");
		}else{
			sb.append("<li id='prev'><a href='javascript:pageMove(0)'>&lt;&lt;</a></li>");
			sb.append("<li id='prev'><a href='javascript:pageMove(0)'>&lt;</a></li>");
		}
		
		for(int i=getStartPage(); i<=getEndPage(); i++){
			sb.append("<li id='p"+i+"'><a href='javascript:pageMove("+i+");'>"+i+"</a></li>");	
		}
		
		if(getPageNum() != getPageMaxNumCount()){
			sb.append("<li id='prev'><a href='javascript:pageMove("+(getPageNum()+1)+")'>&gt;</a></li>");
			sb.append("<li id='prev'><a href='javascript:pageMove("+getPageMaxNumCount()+")'>&gt;&gt;</a></li>");
		}else{
			sb.append("<li id='prev'><a href='javascript:pageMove(0)'>&gt;</a></li>");
			sb.append("<li id='prev'><a href='javascript:pageMove(0)'>&gt;&gt;</a></li>");
		}
		
		sb.append("</ul>");
		
		return sb.toString();
		
	}
// 페이징 처리 구문 end	
}
