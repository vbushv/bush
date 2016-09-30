<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<tiles:insertDefinition name="base.definition">
	
	<tiles:putAttribute name="title" value="list" />
	
	<tiles:putAttribute name="body">
	
	
	
	<div class="col-md-12">
		<form id="customerFrm" class="form-inline">
		<input type="hidden" name="pageNum" value="${pageNum}">
			
			<div class="form-group">
				<input class="form-control" id="serchCustomerName" name="serchCustomerName" type="text" size="15px" value="${serchCustomerName}" placeholder="Customer Search">
			</div>
			<div class="form-group">
				<input class="form-control" id="serchCustomerCompany" name="serchCustomerCompany" type="text" size="15px" value="${serchCustomerCompany}" placeholder="Company Search">
			</div>
			<div class="form-group">
				<input class="btn btn-default" id="searchBtn" type="submit" value="검색">
			</div>
		</form>
	</div>

	<div>
		<table class="table table-hover table-condenced">
			<tr class="active">
				<th class="col-md-1 text-center">고객명</th>
				<th class="col-md-1 text-center">거래처명</th>
				<th class="col-md-1 text-center">직책</th>
				<th class="col-md-1 text-center">연락처</th>
				<th class="col-md-1 text-center">eMail</th>
				<th class="col-md-1 text-center">등록일</th>			
			</tr>

			<c:forEach var="customerList" items="${customerList}">
				<tr class="userView text-center initialism">
					<td><a href="/issuetracker/customerManager/customerView.do?cu_id=${customerList.cu_id}">${customerList.cu_name}</a></td>
					<td><c:out value="${customerList.cu_company}" /></td>
					<td><c:out value="${customerList.cu_position}" /></td>
					<td><c:out value="${customerList.cu_co_call}" /></td>
					<td><c:out value="${customerList.cu_email}" /></td>
					<td><c:out value="${customerList.cu_reg_date}" /></td>
				</tr>
			</c:forEach>
			
		</table>
	</div>	
	
	<div class="text-center">
		<small>${pager}</small>
	</div>
	
	<div class="col-sm-offset-2 col-sm-10 text-right">
		<button type="button" id="customerWrite" class="btn btn-default">등록</button>
	</div>

	<script>
	
		var pageNum = "#p"+$("input[name=pageNum]").val();
		$(pageNum).addClass("active");
			
		$("button#customerWrite").on("click", function() {
			var url = "/issuetracker/customerManager/customerWrite.do";
			urlMove(url);
		});
		
		function pageMove(pageNum){
			if(pageNum == 0) urlMove("#");
			else $("input[name=pageNum]").val(pageNum);$("#customerFrm").attr("method","post").attr("action","/issuetracker/customerManager/customerList.do");$("#customerFrm").submit();
		}
		
	</script>

	</tiles:putAttribute>
</tiles:insertDefinition>