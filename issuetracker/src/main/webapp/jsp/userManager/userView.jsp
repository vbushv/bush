<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% pageContext.setAttribute("crcn", "\r\n"); %>

<tiles:insertDefinition name="base.definition">
	<tiles:putAttribute name="body">
	
	<script type="text/javascript">
		$(document).ready(function(){
			
			$("button#userList").on("click", function(){
				urlMove("userList.do");
			});
			
			$("button#userEdit").on("click", function(){
				urlMove("userEdit.do?userId="+$("#userId").val());
			});
			
			$("button#userDel").on("click", function(){
				if(confirm("삭제하시겠습니까?")){
					urlMove("userDel.do?userId="+$("#userId").val());
				}
			});
			
		});
	</script>	
	
		<form id="userFrm" class="form-horizontal" role="form">
			<input type="hidden" id="userId" value="<c:out value='${userVO.user_id}' />">
			<div class="form-group">
				<label for="inputUserId" class="col-sm-2 control-label">사용자 ID</label>
				<div class="col-lg-6">
					<p class="form-control-static"><c:out value="${userVO.user_id}" /></p>
				</div>
			</div>
			<div class="form-group">
				<label for="inputUserName" class="col-sm-2 control-label">사용자명</label>
				<div class="col-lg-6">
					<p class="form-control-static"><c:out value="${userVO.user_name}" /></p>
				</div>
			</div>
			<div class="form-group">
				<label for="inputUserCompany" class="col-sm-2 control-label">회사명</label>
				<div class="col-lg-6">
					<p class="form-control-static"><c:out value="${userVO.user_company}" /></p>
				</div>
			</div>						
			<div class="form-group">
				<label for="inputUserAuthority" class="col-sm-2 control-label">권한</label>
				<div class="col-lg-6">
					<p class="form-control-static"><c:out value="${userVO.user_authority}" /></p>
				</div>
			</div>
			<div class="form-group">
				<label for="inputUserPsCall" class="col-sm-2 control-label">핸드폰번호</label>
				<div class="col-lg-6">
					<p class="form-control-static"><c:out value="${userVO.user_ps_call}" /></p>
				</div>
			</div>
			<div class="form-group">
				<label for="inputUserCoCall" class="col-sm-2 control-label">직장전화번호</label>
				<div class="col-lg-6">
					<p class="form-control-static"><c:out value="${userVO.user_co_call}" /></p>
				</div>
			</div>
			<div class="form-group">
				<label for="inputUserEmail" class="col-sm-2 control-label">이메일</label>
				<div class="col-lg-6">
					<p class="form-control-static"><c:out value="${userVO.user_email}" /></p>
				</div>
			</div>	
			<div class="form-group">
				<label for="inputUserEtc" class="col-sm-2 control-label">기타</label>
				<div class="col-lg-6">
					<c:set var="user_etc" value="${fn:replace(userVO.user_etc, crcn, '<br/>')}" />
					<p class="form-control-static">${user_etc}</p>
				</div>
			</div>
			<br />
			<br />
			<br />
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="button" id="userList" class="btn btn-info">목록</button>
					<button type="button" id="userEdit" class="btn btn-warning">수정</button>
					<button type="button" id="userDel" class="btn btn-danger">삭제</button>
				</div>
			</div>
		</form>	

	</tiles:putAttribute>
</tiles:insertDefinition>