<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="col-xs-2">
			<img src="/issuetracker/images/ucube_ci.png" width="150px" height="50px" />
			</div>		
<%
			String url[] = request.getServletPath().split("/");
		%>
<script type="text/javascript">
	$(document).ready(function() {
		var url = $("input[name=url]").val();
		if(url == "serviceManager"){
			$("#service").addClass("active");
		}else if(url == "customerManager"){
			$("#customer").addClass("active");
		}else if(url == "userManager"){
			$("#user").addClass("active");
		}else if(url == "businessManager"){
			$("#business").addClass("active");
		}else if(url == "projectManager"){
			$("#project").addClass("active");
		}
	});
</script>
			<input type="hidden" name="url" value="<%=url[2]%>">
			<div class="collapse navbar-collapse col-xs-8" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li id="service"><a href="/issuetracker/serviceManager/serviceList.do">서비스 관리</a></li>
					<li id="customer"><a href="/issuetracker/customerManager/customerList.do">고객 관리</a></li>
					<li id="business"><a href="/issuetracker/businessManager/businessList.do">거래처 관리</a></li>
					<li id="project"><a href="/issuetracker/projectManager/projectList.do">프로젝트 관리</a></li>
					<li id="serviceReport"><a href="#">서비스 리포트</a></li>
					<li id="user"><a href="/issuetracker/userManager/userList.do">사용자 관리</a></li>
				</ul>
			</div>
		</div>
	</nav>