<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<tiles:insertDefinition name="base.definition">
	<tiles:putAttribute name="title" value="projectManager" />

	<tiles:putAttribute name="body">

<script type="text/javascript">
	$(document).ready(function(){
		
		$("button#projectWrite").on("click", function(){
			var url = "/issuetracker/projectManager/projectWrite.do?mode=write";
			urlMove(url);
		});		
		
		var pageNum = "#p"+$("input[name=pageNum]").val();
		$(pageNum).addClass("active");
		
		$(".projectView").on("click", function(){
			var url = "/issuetracker/projectManager/projectView.do?projectId="+$(this).attr("id");
			urlMove(url);
		});
		
	});
	
	function pageMove(pageNum){
		var url;
		if(pageNum == 0) url = "#";
		else url = "/issuetracker/projectManager/projectList.do?pageNum="+pageNum;
		urlMove(url);
	}
	
</script>

		<%-- <div class="col-md-12" style="height:400px;">

			<form class="form-inline" role="form" method="post" action="/issuetracker/projectManager/projectList.do">
				<div class="form-group">
					<label class="sr-only" for="InputIdSearch">Id</label><input type="text" class="form-control" id="IdSearch" name="IdSearch" value="<c:out value='${IdSearch}' />" placeholder="Id Search">
				</div>			
				<div class="form-group">
					<label class="sr-only" for="InputNameSearch">Name</label><input type="text" class="form-control" id="NameSearch" name="NameSearch" value="<c:out value='${NameSearch}' />" placeholder="Name Search">
				</div>
				<button type="submit" class="btn btn-default">검색</button>
			</form>

			<input type="hidden" name="pageNum" value="${pageNum}">
			<table class="table table-hover table-condensed">
				<tr class="active">
					<th class="col-md-1 text-center">아이디</th>
					<th class="col-md-1 text-center">이름</th>
					<th class="col-md-1 text-center">회사명</th>
					<th class="col-md-1 text-center">핸드폰번호</th>
					<th class="col-md-1 text-center">전화번호</th>
					<th class="col-md-1 text-center">이메일</th>
				</tr>

				<c:forEach var="ul" items="${projectList}">
					<tr id="${ul.project_id}" class="projectView text-center initialism">
						<td><c:out value="${ul.project_id}" /></td>
						<td><c:out value="${ul.project_name}" /></td>
						<td><c:out value="${ul.project_company}" /></td>
						<td><c:out value="${ul.project_ps_call}" /></td>
						<td><c:out value="${ul.project_co_call}" /></td>
						<td><c:out value="${ul.project_email}" /></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="text-center">
			<small>${pager}</small>
		</div> --%>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10 text-right">
				<button type="button" id="projectWrite" class="btn btn-default">등록</button>
			</div>
		</div>

		<br />
		<br />

	</tiles:putAttribute>
</tiles:insertDefinition>