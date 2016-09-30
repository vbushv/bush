<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% pageContext.setAttribute("crcn", "\r\n"); %>

<tiles:insertDefinition name="customer.definition">
	<tiles:putAttribute name="body">

	<form id="customerFrm" name="customerFrm" method="post" action="/issuetracker/customerManager/customerDeleteSubmit.do?cu_id=${customerView.cu_id}">
		<input type="hidden" id="cu_id" value="<c:out value='${customerView.cu_id}'/>">

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
		
			<tr align="center"><td colspan="4">
				<input class="btn btn-info" id="list" type="button" value="목록">
				<input class="btn btn-warning" id="modify" type="button" value="수정">
				<input class="btn btn-danger" type="submit" value="삭제">
			</td></tr>
			
		</table>
		
	</form>
	
	<script type="text/javascript">

		$("form#customerFrm table tbody tr td input#list").on("click", function() {
			var url = "/issuetracker/customerManager/customerList.do";
			urlMove(url);
		});
		
		$("form#customerFrm table tbody tr td input#modify").on("click", function() {
			var url = "/issuetracker/customerManager/customerModify.do?cu_id=${customerView.cu_id}";
			urlMove(url);
		});
		
			//window.open('','target_name','scrollbars=yes,toolbar=yes,resizable=yes,width=100,height=100,left=0,top=0');
		
	</script>

	</tiles:putAttribute>
	
	<tiles:putAttribute name="content1">
		<div id="content_service">
			<table class="table table-hover table-condenced">
				<tr class="active">
					<th class="col-md-1 text-center">거래처명</th>
					<th class="col-md-1 text-center">대표전화</th>
					<th class="col-md-1 text-center">등록일</th>
				</tr>
				
				<c:forEach var="busiSearch" items="${businessList}">
				<tr class="userView text-center initialism">
					<td><input type="hidden" value="${busiSearch.co_id}"><a href=""><c:out value="${busiSearch.co_name}" /></a></td>
					<td><c:out value="${busiSearch.co_call}" /></td>
					<td><c:out value="${busiSearch.co_reg_date}" /></td>
				</tr>
				</c:forEach>
				
			</table>
		</div>
	
	<script>
		$("#content_service a").on("click", function() {
			window.open("/issuetracker/customerManager/customerPopup.do?co_id=" + $(this).prev().val(), "_blank", "width=500, height=300, menubar=no, toolbar=no, scrollbars=no, copyhistory=no, resizable=no");
		});
	</script>
	</tiles:putAttribute>
	
	<tiles:putAttribute name="content2">
		<div id="content_project">
			<table class="table table-hover table-condenced">
				<tr class="active">
					<th class="col-md-1 text-center">프로젝트명</th>
					<th class="col-md-1 text-center">거래처명</th>
					<th class="col-md-1 text-center">계약기간</th>
					<th class="col-md-1 text-center">계약금액</th>
					<th class="col-md-1 text-center">등록일</th>
				</tr>
				
				<%-- <c:forEach var="projSearch" items="${projectList}">
				<tr class="userView text-center initialism">
					<td><input type="hidden" value="${projSearch.pj_id}"><a href=""><c:out value="${projSearch.pj_name}" /></a></td>
					<td><c:out value="${projSearch.pj_co_name}" /></td>
					<td><c:out value="${projSearch.pj_st_date}" /> ~ <c:out value="${projSearch.pj_en_date}" /></td>
					<td><c:out value="${projSearch.pj_cost}" /></td>
					<td><c:out value="${projSearch.pj_reg_date}" /></td>
				</tr>
				</c:forEach> --%>
				
			</table>
		</div>
	
	<script>
		$("#content_project a").on("click", function() {
			window.open("/issuetracker/customerManager/customerPopup.do?co_id=" + $(this).prev().val(), "_blank", "width=500, height=300, menubar=no, toolbar=no, scrollbars=no, copyhistory=no, resizable=no");
		});
	</script>
	</tiles:putAttribute>
	
</tiles:insertDefinition>