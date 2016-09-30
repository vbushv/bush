<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<tiles:insertDefinition name="base.definition">
	<tiles:putAttribute name="title" value="businessManager" />

	<tiles:putAttribute name="body">

  
  <div class="col-md-12">
		<form id="businessFrm" class="form-inline">
		<input type="hidden" name="pageNum" value="${pageNum}">
		
			<div class="form-group">
				<input class="form-confrol" id="serchBusinessName" onKeyPress="javascript:spaceKeyCheck();"
					name="serchBusinessName" type="text" size="15px" value="${serchBusinessName}" placeholder="거래처명 입력">
			</div>
			
			<div class="form-group">
				<input class="btn btn-default" id="searchBtn" type="button" value="검색">
			</div>
		
		</form>
	</div>

	<div>
		<table class="table table-hover table-condenced">
			<tr class="active">
				<th class="col-md-1 text-center">거래처명</th>
				<th class="col-md-1 text-center">대표전화</th>
				<th class="col-md-1 text-center">등록일</th>
			</tr>
		
			<c:forEach var="businessList" items="${businessList}">
			<tr class="userView text-center initialism">
				<td><a href="/issuetracker/businessManager/businessView.do?co_id=${businessList.co_id}&pageNum=${pageNum}">${businessList.co_name}</a></td>
				<td><c:out value="${businessList.co_call}"/></td>
				<td><c:out value="${businessList.co_reg_date}"/></td>
			</tr>
			</c:forEach>	
			
			
		</table>
			
		<div class="text-center">
			<small>${pager}</small>
		</div>
		
		<!-- left menu에 추가하여 삭제예정(06.09)<div class="col-sm-offset-2 col-sm-10 text-right">
			<button type="button" id="businessWrite" class="btn btn-default">등록</button>
		</div>-->	
	

	<script>
	
		var pageNum = "#p"+$("input[name=pageNum]").val();
		$(pageNum).addClass("active");
		
		$("input#searchBtn").on("click", function() {
			
			$("input[name=pageNum]").val(1);
			$("#businessFrm").attr("method","post").attr("action","/issuetracker/businessManager/businessList.do");
			$("#businessFrm").submit();
			
		});
		
		$("button#businessWrite").on("click", function() {
			var url = "/issuetracker/businessManager/businessWrite.do";
			$(location).attr("href", url);
		});
		
		function pageMove(pageNum){
			var url;
			if(pageNum == 0) url = "#";
			else url = "/issuetracker/businessManager/businessList.do?pageNum="+pageNum;
			urlMove(url);
		}
		
		function spaceKeyCheck(){
			if(event.keyCode == 13){
				alert("enter 사용 금지. 검색을 클릭하세요.");
				event.returnValue = false;
				return;
			}
		}
	</script>

		</tiles:putAttribute>
</tiles:insertDefinition>   