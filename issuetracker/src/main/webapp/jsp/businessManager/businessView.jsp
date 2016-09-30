<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% pageContext.setAttribute("crcn", "\r\n"); %>	
	
<tiles:insertDefinition name="view.definition">
	
	<tiles:putAttribute name="body">	
	
	<form id="businessFrm" name="businessFrm" method="post" 
	action="/issuetracker/businessManager/businessDeleteSubmit.do?co_id=${businessView.co_id }">
		<input type="hidden" id="co_id" value="<c:out value='${businessView.co_id }'/>">
		
		<table class="table table-hover table-condenced">
		
			<tr>
				<th class="active"><label class="control-label">거래처명</label></th>
					<td><p class="form-control-static"><c:out value="${businessView.co_name}"/></p></td>
			</tr>
			
			<tr>
				<th class="active"><label class="control-label">주소</label></th>
					<td><p class="form-control-static">${businessView.co_address1} ${businessView.co_address2}</p></td>
			</tr>
			
			<tr>
				<th class="active"><label class="control-label">대표전화</label></th>
					<td>
						<p class="form-control-static"><c:out value="${co_call[0]}"/> - <c:out value="${co_call[1]}"/> - <c:out value="${co_call[2]}"/></p>    				
						</td>
			</tr>
				
			<tr>
				<th class="active"><label class="control-label">기타</label></th>
					<td><p class="form-control-static">${businessView.co_etc}</p></td>
			</tr>
			
			<hr/>
			
			<tr align="center"><td colspan="4">
				<input class="btn btn-info" type="button" id="list" value="목록">
				<input class="btn btn-warning" type="button" id="modify" value="수정">
				<input class="btn btn-danger" type="button" id="delete" value="삭제">
			</td></tr>
			
		</table>
	</form>
	</div>
	
	<script type="text/javascript">
	
		$("form#businessFrm table tbody tr td input#list").on("click", function() {
			var url = "/issuetracker/businessManager/businessList.do?pageNum=${pageNum}";
			urlMove(url);
		});
		
		$("form#businessFrm table tbody tr td input#modify").on("click", function() {
			var url = "/issuetracker/businessManager/businessModify.do?co_id=${businessView.co_id}";
			urlMove(url);
		});
	
		$("#delete").on("click", function(){
			if(!confirm("정말 삭제하시겠습니까? 다시 복구 되지 않습니다.")){
				return;
			}else{
				document.location.href="/issuetracker/businessManager/businessDeleteSubmit.do?co_id=${businessView.co_id }";
				document.list.submit();
			}	
		});
	
	</script>
	</tiles:putAttribute>
	
	
	<tiles:putAttribute name="content1">
		<div id="content_business">
			<table class="table table-hover table-condenced">
				<tr class="active">
					<th class="col-md-1 text-center">고객명</th>
					<th class="col-md-1 text-center">직장명</th>
					<th class="col-md-1 text-center">직책</th>
					<th class="col-md-1 text-center">핸드폰</th>
					<th class="col-md-1 text-center">직장전화</th>
					<th class="col-md-1 text-center">등록일</th>					
				</tr>	
				
				<c:forEach var="cusSearch" items="${customerList}">
				<tr class="userView text-center initialism">
					<td><input type="hidden" value="${cusSearch.cu_id}"><a href="#"><c:out value="${cusSearch.cu_name}"/></a></td>
					<td><c:out value="${cusSearch.cu_company}"/></td>
					<td><c:out value="${cusSearch.cu_position}"/></td>
					<td><c:out value="${cusSearch.cu_ps_call}"/></td>
					<td><c:out value="${cusSearch.cu_co_call}"/></td>
					<td><c:out value="${cusSearch.cu_reg_date}"/></td>
				</c:forEach>
			</table>
		</div>
		
		<script>
			$("#content_business a").on("click", function(){
				window.open("/issuetracker/businessManager/businessPopup.do?cu_id=" + $(this).prev().val(), "_blank",
				"width=500, height=300, menubar=no, toolbar=no, scrollbars=no, copyhistory=no, resizable=no");
			});
		</script>
		
	</tiles:putAttribute>
</tiles:insertDefinition>   	