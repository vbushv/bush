<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<tiles:insertDefinition name="base.definition">
	
	<tiles:putAttribute name="title" value="list" />
	
	<tiles:putAttribute name="body">
	
	
	
	<div class="col-md-12">
		<form id="serviceFrm" class="form-inline">
		<input type="hidden" name="pageNum" value="${pageNum}">
			
			<div class="form-group">
				<input class="form-control" id="searchServiceName" name="searchServiceName" type="text" size="15px" value="${searchServiceName}" placeholder="Service Search">
			</div>
			<div class="form-group">
				<input class="form-control" id="searchBusinessCompany" name="searchBusinessCompany" type="text" size="15px" value="${searchBusinessCompany}" placeholder="Company Search">
			</div>
			<div class="form-group">
				<input class="form-control" id="searchStatus" name="searchStatus" type="text" size="15px" value="${searchStatus}" placeholder="Status Search">
			</div>
			<div class="form-group">
				<input class="btn btn-default" id="searchBtn" type="submit" value="검색">
			</div>
		</form>
	</div>

	<div>
		<table class="table table-hover table-condenced">
			<tr class="active">
				<th class="col-md-1 text-center">서비스명</th>
				<th class="col-md-1 text-center">서비스 유형</th>
				<th class="col-md-1 text-center">거래처명</th>
				<th class="col-md-1 text-center">접수일</th>
				<th class="col-md-1 text-center">처리상태</th>
				<th class="col-md-1 text-center">담당자</th>			
			</tr>

			<c:forEach var="serviceList" items="${serviceList}">
				<tr class="userView text-center initialism">
					<td><a href="/issuetracker/serviceManager/serviceView.do?sm_id=${serviceList.sm_id}">${serviceList.sm_name}</a></td>
					<td><c:out value="${serviceList.sm_type}" /></td>
					<td><c:out value="${serviceList.sm_company}" /></td>
					<td><c:out value="${serviceList.sm_re_date}" /></td>
					<td><c:out value="${serviceList.sm_status}" /></td>
					<td><c:out value="${serviceList.sm_responsibility}" /></td>
				</tr>
			</c:forEach>
			
		</table>
	</div>	
	
	<div class="text-center">
		<small>${pager}</small>
	</div>
	
	<div class="col-sm-offset-2 col-sm-10 text-right">
		<button type="button" id="serviceWrite" class="btn btn-default">등록</button>
	</div>

	<script>
	
		var pageNum = "#p"+$("input[name=pageNum]").val();
		$(pageNum).addClass("active");
			
		$("button#serviceWrite").on("click", function() {
			var url = "/issuetracker/serviceManager/serviceWrite.do";
			urlMove(url);
		});
		
		function pageMove(pageNum){
			if(pageNum == 0) urlMove("#");
			else $("input[name=pageNum]").val(pageNum);$("#serviceFrm").attr("method","post").attr("action","/issuetracker/serviceManager/serviceList.do");$("#serviceFrm").submit();
		}
		
	</script>

	</tiles:putAttribute>
</tiles:insertDefinition>