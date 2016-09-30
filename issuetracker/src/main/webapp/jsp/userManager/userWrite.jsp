<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<tiles:insertDefinition name="base.definition">
	<tiles:putAttribute name="body">

<script type="text/javascript">

	$(document).ready(function(){
		
		$(".user_authority").on("click", function(){
			$(this).addClass("active").siblings().removeClass("active");
			$("#user_authority").val($(this).attr("id"));
		});
		
		$("#user_insert").on("click", function() {
	 		if (nullCheck("user_id", "아이디") == false) {
	 			alert((this).attr("class"));
				return;
			} else if (nullCheck("user_name", "사용자명") == false) {
				return;
			} else if (nullCheck("user_company", "회사명") == false) {
				return;
			} else if (nullCheck("user_pass", "비밀번호") == false) {
				return;
			} else if (nullCheck("user_pass_chk", "비밀번호 확인") == false) {
				return;
			} else if ($("input[name=user_pass]").val() != $("input[name=user_pass_chk]").val()){
				alert("비밀번호가 다릅니다");
				return;
			} else if (nullCheck("user_authority", "권한") == false) {
				return;				
			} else if (nullCheck("user_ps_call1", "핸드폰번호") == false) {
				return;
			} else if (nullCheck("user_ps_call2", "핸드폰번호") == false) {
				return;
			} else if (nullCheck("user_ps_call3", "핸드폰번호") == false) {
				return;
			} else if (nullCheck("user_co_call1", "직장전화번호") == false) {
				return;					
			} else if (nullCheck("user_co_call2", "직장전화번호") == false) {
				return;					
			} else if (nullCheck("user_co_call3", "직장전화번호") == false) {
				return;					
			} else if (nullCheck("user_email1", "이메일") == false) {
				return;					
			} else if (nullCheck("user_email2", "이메일") == false) {
				return;									
			} else if (emailCheck("user_email1","user_email2") == false) {
				return;
			} else {
				var userFrm = $("#userFrm");
				userFrm.attr("method", "post").attr("action","/issuetracker/userManager/userSubmit.do");
				userFrm.submit();
			}
	
		});
	});

	
</script>

		<form id="userFrm" class="form-horizontal" role="form">
			<div class="form-group">
				<label for="inputUserId" class="col-sm-2 control-label">사용자 ID</label>
				<div class="col-lg-6">
					<input type="text" class="form-control" id="user_id" name="user_id" placeholder="User Id">
				</div>
			</div>
			<div class="form-group">
				<label for="inputUserName" class="col-sm-2 control-label">사용자명</label>
				<div class="col-lg-6">
					<input type="text" class="form-control" id="user_name" name="user_name" placeholder="User Name">
				</div>
			</div>
			<div class="form-group">
				<label for="inputUserCompany" class="col-sm-2 control-label">회사명</label>
				<div class="col-lg-6">
					<input type="text" class="form-control" id="user_company" name="user_company" placeholder="Company Name">
				</div>
			</div>						
			<div class="form-group">
				<label for="inputUserPassword" class="col-sm-2 control-label">비밀번호</label>
				<div class="col-lg-6">
					<input type="password" class="form-control" id="user_pass" name="user_pass" placeholder="Password">
				</div>
			</div>
			<div class="form-group">
				<label for="inputUserPasswordChk" class="col-sm-2 control-label">비밀번호 확인</label>
				<div class="col-lg-6">
					<input type="password" class="form-control" id="user_pass_chk" name="user_pass_chk" placeholder="Password Check">
				</div>
			</div>
			<div class="form-group">
				<label for="inputUserAuthority" class="col-sm-2 control-label">권한</label>
				<div class="row">
					<div class="col-lg-2">
						<!-- <input type="checkbox" name="user_authority" value="admin_role" />
						<input type="hidden" name="!user_authority" value="user_role" /> -->
						<input type="hidden" id="user_authority" name="user_authority" value="">
						<div class="btn-group btn-group-sm">
						  	<button type="button" id="admin_role" class="btn btn-default user_authority">ADMIN</button>
						  	<button type="button" id="user_role" class="btn btn-default user_authority">USER</button>
						</div>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label for="inputUserPsCall" class="col-sm-2 control-label">핸드폰번호</label>
				<div class="col-lg-6">
					<div class="input-group">
						<input type="text" class="form-control" id="user_ps_call1" onfocus="numCheck(this.id)" maxlength="3" name="user_ps_call1" placeholder="CellPhone">
						<span class="input-group-addon">-</span>
						<input type="text" class="form-control" id="user_ps_call2" onfocus="numCheck(this.id)" maxlength="4" name="user_ps_call2" placeholder="CellPhone">
						<span class="input-group-addon">-</span>
						<input type="text" class="form-control" id="user_ps_call3" onfocus="numCheck(this.id)" maxlength="4" name="user_ps_call3" placeholder="CellPhone">
					</div>
				</div>
			</div>
			<div class="form-group">
				<label for="inputUserCoCall" class="col-sm-2 control-label">직장전화번호</label>
				<div class="col-lg-6">
					<div class="input-group">
						<input type="text" class="form-control" id="user_co_call1" onfocus="numCheck(this.id)" maxlength="3" name="user_co_call1" placeholder="WorkPhone">
						<span class="input-group-addon">-</span>
						<input type="text" class="form-control" id="user_co_call2" onfocus="numCheck(this.id)" maxlength="4" name="user_co_call2" placeholder="WorkPhone">
						<span class="input-group-addon">-</span>
						<input type="text" class="form-control" id="user_co_call3" onfocus="numCheck(this.id)" maxlength="4" name="user_co_call3" placeholder="WorkPhone">
					</div>
				</div>
			</div>
			<div class="form-group">
				<label for="inputUserEmail" class="col-sm-2 control-label">이메일</label>
				<div class="col-lg-6">
					<div class="input-group">
						<input type="email" class="form-control" id="user_email1" name="user_email1" placeholder="Email">
	  					<span class="input-group-addon">@</span>
	  					<input type="email" class="form-control" id="user_email2" name="user_email2" placeholder="Email.com">
					</div>
				</div>
			</div>	
			<div class="form-group">
				<label for="inputUserEtc" class="col-sm-2 control-label">기타</label>
				<div class="col-lg-6">
					<textarea class="form-control" rows="5" name="user_etc" placeholder="Etc"></textarea>
				</div>
			</div>
			<br />
			<br />
			<br />
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="button" id="user_insert" class="btn btn-primary">등록</button>
					<button type="button" class="btn btn-default" onclick="javascript:history.go(-1);">취소</button>
				</div>
			</div>
		</form>

	</tiles:putAttribute>
</tiles:insertDefinition>