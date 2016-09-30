<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<tiles:insertDefinition name="base.definition">
	<tiles:putAttribute name="title" value="userManager" />

	<tiles:putAttribute name="body">

<script type="text/javascript">
	$(document).ready(function(){
		
		$("button#userWrite").on("click", function(){
			var url = "/issuetracker/userManager/userWrite.do";
			urlMove(url);
		});		
		
		var pageNum = "#p"+$("input[name=pageNum]").val();
		$(pageNum).addClass("active");
		
		$(".userView").on("click", function(){
			var url = "/issuetracker/userManager/userView.do?userId="+$(this).attr("id");
			urlMove(url);
		});
		
	});
	
	function pageMove(pageNum){
		if(pageNum == 0) urlMove("#");
		else $("input[name=pageNum]").val(pageNum);	$("#searchFrm").submit();
	}
	
</script>

		<div class="col-md-12" style="height:400px;">

			<form id="searchFrm" class="form-inline" role="form" method="post" action="/issuetracker/userManager/userList.do">
			<input type="hidden" name="pageNum" value="${pageNum}">
				<div class="form-group">
					<label class="sr-only" for="InputIdSearch">Id</label><input type="text" class="form-control" id="IdSearch" name="IdSearch" value="<c:out value='${IdSearch}' />" placeholder="Id Search">
				</div>			
				<div class="form-group">
					<label class="sr-only" for="InputNameSearch">Name</label><input type="text" class="form-control" id="NameSearch" name="NameSearch" value="<c:out value='${NameSearch}' />" placeholder="Name Search">
				</div>
				<button type="submit" class="btn btn-default">검색</button>
			</form>

			<table class="table table-hover table-condensed">
				<tr class="active">
					<th class="col-md-1 text-center">아이디</th>
					<th class="col-md-1 text-center">이름</th>
					<th class="col-md-1 text-center">회사명</th>
					<th class="col-md-1 text-center">핸드폰번호</th>
					<th class="col-md-1 text-center">전화번호</th>
					<th class="col-md-1 text-center">이메일</th>
				</tr>

				<c:forEach var="ul" items="${userList}">
					<tr id="${ul.user_id}" class="userView text-center initialism">
						<td><c:out value="${ul.user_id}" /></td>
						<td><c:out value="${ul.user_name}" /></td>
						<td><c:out value="${ul.user_company}" /></td>
						<td><c:out value="${ul.user_ps_call}" /></td>
						<td><c:out value="${ul.user_co_call}" /></td>
						<td><c:out value="${ul.user_email}" /></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="text-center">
			<small>${pager}</small>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10 text-right">
				<button type="button" id="userWrite" class="btn btn-default">등록</button>
			</div>
		</div>

		<br />
		<br />

	</tiles:putAttribute>
</tiles:insertDefinition>