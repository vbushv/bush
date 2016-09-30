<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<tiles:insertDefinition name="base.definition">
	<tiles:putAttribute name="title" value="businessManager" />

	<tiles:putAttribute name="body">

    <form class="form-horizontal" id="businessFrm" name="businessFrm" method="post" 
    	  action="/issuetracker/businessManager/businessUpdateSubmit.do">
    	
    	<input type="hidden" name="co_id" value=${businessView.co_id} />
    
    <div class="form-group">		
    	<div class="form-group">
    		<label for="co_name" class="col-sm-1 control-label">거래처명</label>
    		<div class="col-sm-4">
    			<input type="text" id="co_name" name="co_name" value="${businessView.co_name}" >
    		</div>
    	</div>	
    </div>
    	
    <div class="form-group">	
    	<div class="form-group">	
    			<label for="co_postcode" class="col-sm-1 control-label">우편번호</label>
    			<div class="col-sm-4">
    				<input type="text" id="co_postcode" name="co_postcode" 
    				 value=${businessView.co_postcode} size="8" maxlength="6" readonly="readonly">
    				
    				<input type="button" id="searchBtn" name="searchBtn" value="검색">
    			</div>
    	</div>	
    </div>		
    		<div class="form-group">
    			<label for="co_address1" class="col-sm-1 control-label">주소</label>
    			
    			<div class="col-sm-4">
    			<input type="text" id="co_address1" name="co_address1" size="50" value="${businessView.co_address1}">
    			</div>
    				
    		</div>
			
			<div class="form-group">
				<label for="co_address2" class="col-sm-1 control-label">세부주소</label>
				
				<div class="col-sm-4">
    			<input type="text" id="co_address2" name="co_address2" value="${businessView.co_address2}">
    			</div>
    		</div>    	
    	
			
			<div class="form-group">
				<label class="col-sm-1 control-label">대표전화</label>
			  <div class="col-sm-4">	
				<div class="input-group">    		
    			
    				<input id="bu_co_call_selected" type="hidden" value="${co_call[0]}">
    				<select class="form-control" id="bu_co_call1" name="bu_co_call1">
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
    				<input class="form-control" type="text" id="bu_co_call2" name="bu_co_call2" size="4" maxlength="4" value="${co_call[1]}">
    				<span class="input-group-addon">-</span>
    				<input class="form-control" type="text" id="bu_co_call3" name="bu_co_call3" size="4" maxlength="4" value="${co_call[2]}">
    			</div>
    		  </div>			
    		</div>
    		
    		<div class="form-group">
    			<div class="form-group">
    			<label for="co_etc" class="col-sm-1 control-label">기타</label>
    			<div class="col-sm-9">
    				<textarea class="form-control" rows="10" cols="80" id="co_etc" name="co_etc">${businessView.co_etc}</textarea>
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
    
    <script type="text/javascript">
    
    	$("form#businessFrm table tbody tr td input#businessList").on("click", function(){
    		var url = "/issuetracker/businessManager/businessList.do";
    		urlMove(url);
    	});
    	
    	$("input#searchBtn").on("click", function() {
    			//alert("우편번호 검색 호출");
    			win_post=window.open('/issuetracker/businessManager/zipCode.do', "zipList", "toolbar=no, width=750, height=450, directories=no," + 
    					              "status=yes, scrollbars=yes, menubar=no");
    	});
    	
    	$("#bu_co_call1").val($("#bu_co_call_selected").val()).attr("selected", "selected");
    	
    </script>
    
	</tiles:putAttribute>
</tiles:insertDefinition>