<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<tiles:insertDefinition name="base.definition">
	<tiles:putAttribute name="body">

	<form class="form-horizontal" id="customerFrm" name="customerFrm" method="post" action="/issuetracker/customerManager/customerUpdateSubmit.do">
	
		<input type="hidden" name="cu_id" value=${customerView.cu_id} />
		
		<div class="form-group">
			<div class="form-group">
			    <label for="cu_name" class="col-sm-1 control-label">고객명</label>
			    <div class="col-sm-4">
			      <input type="text" class="form-control" id="cu_name" name="cu_name" value="${customerView.cu_name}" placeholder="Customer Name">
			    </div>
	
			    <label for="cu_company" class="col-sm-1 control-label">직장명</label>
			    <div class="col-sm-3">
			      <input type="text" class="form-control" id="cu_company" name="cu_company" value="${customerView.cu_company}" placeholder="Customer Company" readonly>
			    </div>
			    <div class="col-sm-1">
					<input type="button" id="search_company" class="btn btn-default" value="검색">
			    </div>
		  	</div>
	  	</div>
	  	
	  	<div class="form-group">
			<div class="form-group">
			    <label for="cu_position" class="col-sm-1 control-label">직책</label>
			    <div class="col-sm-4">
			      <input type="text" class="form-control" id="cu_position" name="cu_position" value="${customerView.cu_position}" placeholder="Customer Position">
			    </div>
	
			    <label for="cu_department" class="col-sm-1 control-label">부서</label>
			    <div class="col-sm-4">
			      <input type="text" class="form-control" id="cu_department" name="cu_department" value="${customerView.cu_department}" placeholder="Customer Department">
			    </div>
		  	</div>
	  	</div>
	  	
	  	<div class="form-group">
	  		<div class="form-group">
				<label class="col-sm-1 control-label">핸드폰</label>
				<div class="col-sm-4">
					<div class="input-group">
						<%-- <input class="form-control" type="text" id="cu_ps_call1" name="cu_ps_call1" size="4" maxlength="3" value="${cu_ps_call[0]}" placeholder="Call No.1"> --%>
						<input id="cu_ps_call_selected" type="hidden" value="${cu_ps_call[0]}">
						<select class="form-control" id="cu_ps_call1" name="cu_ps_call1">
							<option value="010">010</option><option value="011">011</option><option value="017">017</option>
							<option value="018">018</option><option value="019">019</option>
						</select>
						<span class="input-group-addon">-</span> 
						<input class="form-control" type="text" id="cu_ps_call2" name="cu_ps_call2" size="4" maxlength="4" value="${cu_ps_call[1]}" placeholder="Call No.2">
						<span class="input-group-addon">-</span> 
						<input class="form-control" type="text" id="cu_ps_call3" name="cu_ps_call3" size="4" maxlength="4" value="${cu_ps_call[2]}" placeholder="Call No.3">
					</div>
				</div>
			
				<label class="col-sm-1 control-label">직장전화</label>
				<div class="col-sm-4">
				    <div class="input-group">
						<%-- <input class="form-control" type="text" id="cu_co_call1" name="cu_co_call1" size="4" maxlength="3" value="${cu_co_call[0]}" placeholder="Call No.1"> --%>
						<input id="cu_co_call_selected" type="hidden" value="${cu_co_call[0]}">
						<select class="form-control" id="cu_co_call1" name="cu_co_call1">
							<option value="02">02</option><option value="031">031</option>
							<option value="032">032</option><option value="033">033</option>
							<option value="041">041</option><option value="042">042</option>
							<option value="043">043</option><option value="051">051</option>
							<option value="052">052</option><option value="053">053</option>
							<option value="054">054</option><option value="055">055</option>
							<option value="061">061</option><option value="062">062</option>
							<option value="063">063</option><option value="064">064</option>
						</select> 
						<span class="input-group-addon">-</span>
						<input class="form-control" type="text" id="cu_co_call2" name="cu_co_call2" size="4" maxlength="4" value="${cu_co_call[1]}" placeholder="Call No.2"> 
						<span class="input-group-addon">-</span>
						<input class="form-control" type="text" id="cu_co_call3" name="cu_co_call3" size="4" maxlength="4" value="${cu_co_call[2]}" placeholder="Call No.3">
				    </div>
			    </div>
			</div>
	  	</div>
	  	
		<div class="form-group">
	  		<div class="form-group">
				<label class="col-sm-1 control-label">E-mail</label>
				<div class="col-sm-9">
					<div class="input-group">
						<input class="form-control" type="text" id="cu_email1" name="cu_email1" value="${cu_email[0]}" placeholder="Customer Email No.1">
						<span class="input-group-addon">@</span> 
						<input class="form-control" type="text" id="cu_email2" name="cu_email2" value="${cu_email[1]}" placeholder="Customer Email No.2">
					</div>
				</div>
			</div>
	  	</div>
		
		<div class="form-group">
			<div class="form-group">
			    <label for="cu_etc" class="col-sm-1 control-label">기타</label>
			    <div class="col-sm-9">
			      <textarea class="form-control" rows="10" cols="80" id="cu_etc" name="cu_etc">${customerView.cu_etc}</textarea>
			    </div>
		  	</div>
	  	</div>
	  	
	  	<div class="form-group">
	  		<div class="col-sm-10" align="center">
	  			<input type="submit" class="btn btn-info" value="수정">
	  			<input type="button" class="btn" id="list" name="list" value="취소" onClick="javascript:history.go(-1);">
	  		</div>
	  	</div>
			
	</form>
	
	<div id="popup" title="Search Company">
		<table class="thumbnail col-xs-12">
					
			<c:forEach var="companyList" items="${companyList}">
			<tr>
				<th>직장명</th>
				<td><a>${companyList.co_name}</a></td>
			</tr>
			</c:forEach>
				
		</table>
	</div>
	
	<script>
	$(document).ready(function() {
		
		$("#cu_ps_call1").val($("#cu_ps_call_selected").val()).attr("selected", "selected");
		$("#cu_co_call1").val($("#cu_co_call_selected").val()).attr("selected", "selected");
		
		$("#popup").hide();
		
		$("#search_company").on("click", function() {
			$("#popup").dialog({modal:true});
		});
		
		$("div#popup table tbody tr td a").on("click", function() {
			alert($(this).text());
			$("#cu_company").val($(this).text());
			$("#popup").dialog("close");
		});
	
	});
	</script>

	</tiles:putAttribute>
</tiles:insertDefinition>