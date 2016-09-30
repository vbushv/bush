<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<tiles:insertDefinition name="base.definition">
	<tiles:putAttribute name="body">

<script type="text/javascript">

	$(document).ready(function(){
		
		/* $(".user_authority").on("click", function(){
			$(this).addClass("active").siblings().removeClass("active");
			$("#user_authority").val($(this).attr("id"));
		}); */
		
		$("#project_insert").on("click", function() {
	 		/* if (nullCheck("user_id", "아이디") == false) {
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
			} else { */
				$("#projectFrm").attr("method", "post").attr("action","/issuetracker/projectManager/projectSubmit.do");
				$("#projectFrm").submit();
			//}
	
		});
		
		$("#pj_st_date").datepicker({
			//showOn : "both",
			buttonImageOnly: true,
			showOtherMonths: true,
		    selectOtherMonths: true,
		    dateFormat: "yy-mm-dd"
		});
		
		$("#pj_en_date").datepicker({
			//showOn : "both",
			buttonImageOnly: true,
			showOtherMonths: true,
		    selectOtherMonths: true,
		    dateFormat: "yy-mm-dd"
		});		
		
	});

	
</script>
		<form id="projectFrm" class="form-horizontal" role="form">
			<input type="hidden" id="mode" name="mode" value="write">
			<input type="hidden" id="pj_id" name="pj_id" value="projcetId">
			<input type="hidden" id="test1" name="test1" value="TEST11">
			<input type="hidden" id="test2" name="test2" value="TEST22">
			<input type="hidden" id="test3" name="test3" value="TEST33">
			<div class="panel panel-default">
				<div class="panel-heading">거래처 정보</div>
				<div class="panel-body">
					<div class="form-group">
						<label for="inputCustomerName" class="col-sm-2 control-label">거래처명</label>
						<div class="col-lg-2">
							<input type="text" class="form-control" id="pj_co_name" name="pj_co_name" readonly placeholder="거래처명" value="거래처명">
						</div>
						<button type="submit" class="btn btn-info">검색</button>
						<div class="col-lg-2 checkbox">
							<label>
								대표 거래처 <input type="checkbox" id="pj_rep_customer" name="pj_rep_customer" checked>
							</label>
						</div>
					</div>
					<div class="form-group">
						<label for="inputCustomerAddress" class="col-sm-2 control-label">주소</label>
						<div class="col-lg-6">
							<input type="text" class="form-control" id="pj_address" name="pj_address" readonly placeholder="주소" value="서울시 강남구 도곡동">
						</div>
					</div>
				</div>
			</div>

			<div class="panel panel-default">
				<div class="panel-heading">프로젝트 정보</div>
				<div class="panel-body">
					<div class="form-group">
						<label for="inputProjectName" class="col-sm-2 control-label">프로젝트명</label>
						<div class="col-lg-6">
							<input type="text" class="form-control" id="pj_name" name="pj_name" placeholder="프로젝트명" value="프로젝트이름">
						</div>
					</div>
					<div class="form-group">
						<label for="inputProjectDate" class="col-sm-2 control-label">프로젝트 기간</label>
						<div class="col-lg-4">
							<div class="input-group">
								<input type="text" class="form-control" id="pj_st_date" name="pj_st_date" readonly placeholder="프로젝트기간" value="2014-05-28">
								<span class="input-group-addon">-</span>
								<input type="text" class="form-control" id="pj_en_date" name="pj_en_date" readonly placeholder="프로젝트기간" value="2014-06-01">
							</div>
						</div>						
					</div>
					<div class="form-group">
						<label for="inputProjectCost" class="col-sm-2 control-label">계약금액</label>
						<div class="col-lg-4">
							<div class="input-group">
								<input type="text" class="form-control" id="pj_cost" name="pj_cost" placeholder="계약금액" value="10000">
								<span class="input-group-addon">원</span>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="inputProjectSales" class="col-sm-2 control-label">영업담당자</label>
						<div class="col-lg-4">
							<input type="text" class="form-control" id="pj_sales" name="pj_sales" readonly placeholder="영업담당자" value="유큐브">
						</div>
						<button type="submit" class="btn btn-info">검색</button>
					</div>
					<div class="form-group">
						<label for="inputProjectResponsibility" class="col-sm-2 control-label">업무담당자</label>
						<div class="col-lg-4">
							<input type="text" class="form-control" id="pj_responsibility" name="pj_responsibility" readonly placeholder="업무담당자" value="SS사업단">
						</div>
						<button type="submit" class="btn btn-info">검색</button>
					</div>
					<div class="form-group">
						<label for="inputProjectContent" class="col-sm-2 control-label">프로젝트 내용</label>
						<div class="col-lg-6">
							<textarea class="form-control" rows="5" name="pj_content" placeholder="프로젝트 내용">플젝내용.....</textarea>
						</div>
					</div>
				</div>
			</div>			
			
			<div class="panel panel-default">
				<div class="panel-heading">관련 거래처 정보<span class="badge pull-right">추가</span></div>
				<div class="panel-body">
					<div class="form-group">
						<label for="inputCustomerName" class="col-sm-2 control-label">거래처명</label>
						<div class="col-lg-4">
							<input type="text" class="form-control" id="pj_company" name="pj_company" placeholder="거래처명" value="삼성SDS">
						</div>
						<button type="submit" class="btn btn-info">검색</button>
						<button type="submit" class="btn btn-default">삭제</button>
						<br />
						<label for="inputCustomerName" class="col-sm-2 control-label"></label>
						<div class="col-lg-4">
							<input type="text" class="form-control" id="pj_company" name="pj_company" placeholder="거래처명" value="LG전자">
						</div>
						<button type="submit" class="btn btn-info">검색</button>
						<button type="submit" class="btn btn-default">삭제</button>						
					</div>
				</div>
			</div>			
			
			<br />
			<br />
			<br />
			<div class="text-right">
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="button" id="project_insert" class="btn btn-primary">등록</button>
						<button type="button" class="btn btn-default" onclick="javascript:history.go(-1);">취소</button>
					</div>
				</div>
			</div>
		</form>

	</tiles:putAttribute>
</tiles:insertDefinition>