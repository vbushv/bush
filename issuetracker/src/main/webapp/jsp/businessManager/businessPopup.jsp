<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% pageContext.setAttribute("crcn", "\r\n"); %>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
	<link href="/issuetracker/css/bootstrap.min.css" rel="stylesheet" type="text/css" >
	<link href="/issuetracker/css/etc.css" rel="stylesheet" type="text/css" >
	<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
	<script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
	<script src="/issuetracker/js/bootstrap.min.js" ></script>

	<table class="table table-hover table-condenced">
			<tr>
				<th class="active"><label class="control-label">고객명</label></th>
				<td><p class="form-control-static"><c:out value="${customerView.cu_name}" /></p></td>
				<th class="active"><label class="control-label">직장명</label></th>
				<td><p class="form-control-static"><c:out value="${customerView.cu_company}" /></p></td>
			</tr>
			
			<tr>
				<th class="active"><label class="control-label">직책</label></th>
				<td><p class="form-control-static"><c:out value="${customerView.cu_position}" /></p></td>
				<th class="active"><label class="control-label">부서</label></th>
				<td><p class="form-control-static"><c:out value="${customerView.cu_department}" /></p></td>
			</tr>
			
			<tr>
				<th class="active"><label class="control-label">핸드폰</label></th>
				<td><p class="form-control-static"><c:out value="${cu_ps_call[0]}" /> - <c:out value="${cu_ps_call[1]}" /> - <c:out value="${cu_ps_call[2]}" /></p></td>
				<th class="active"><label class="control-label">직장전화</label></th>
				<td><p class="form-control-static"><c:out value="${cu_co_call[0]}" /> - <c:out value="${cu_co_call[1]}" /> - <c:out value="${cu_co_call[2]}" /></p></td>
			</tr>
			
			<tr>
				<th class="active"><label class="control-label">eMail</label></th>
				<td colspan="3"><p class="form-control-static"><c:out value="${cu_email[0]}" /> @ <c:out value="${cu_email[1]}" /></p></td>
			</tr>
			
			<tr>
				<th class="active"><label class="control-label">기타</label></th>
				<td colspan="3">
					<div>
						<c:set var="cu_etc" value="${fn:replace(customerView.cu_etc, crcn, '<br/>')}" />
						<p class="form-control-static">${cu_etc}</p>
					</div>
				</td>
			</tr>
		
			<tr align="center"><td colspan="2">
			<input class="btn btn-info" id="popupClose" type="button" value="닫기">
		</td></tr>
			
		</table>

	<script>
		$(document).ready(function() {
			$("#popupClose").on("click", function() {
				window.close();
			});
		});
	</script>