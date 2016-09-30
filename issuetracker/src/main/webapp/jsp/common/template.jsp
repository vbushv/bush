<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="Page-Enter" content="progid:DXImageTransform.Microsoft.Fade(Duration=.5)"/>
	<title><tiles:insertAttribute name="title" ignore="true" /></title>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
	<link href="/issuetracker/css/bootstrap.min.css" rel="stylesheet" type="text/css" >
	<link href="/issuetracker/css/etc.css" rel="stylesheet" type="text/css" >
	<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
	<script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
	<script src="/issuetracker/js/bootstrap.min.js" ></script>
	
	<tiles:insertAttribute name="head.jsfunc"/>
	
</head>
<body>

	<tiles:insertAttribute name="header" flush="false" />

	<br /><br /><br />

	<div class="col-md-2 user-status">
	
		<div class="col-xs-12 user-status thumbnail" id="user-status">
			<form id="userCtrl">
				<table width="100%">
					<tr><th align="center" colspan="2" style="text-align:center"><h5><strong><%=session.getAttribute("userName")%></strong> 님 환영합니다</h5></th></tr>
					
					<tr>
						<td align="center"><input id="logOut" type="button" class="btn btn-default" value="Log Out"></td>
						<td align="center"><input id="userEdit" type="button" class="btn btn-default" value="정보수정"></td>
					</tr>
				</table>
			</form>
		</div>
		
		<tiles:insertAttribute name="left.menu" flush="false" />
	
	</div>
	
	<div class="col-xs-10 ">
	
		<div class="col-xs-12 thumbnail" id="contents">
			<p>list view</p>
			
			<tiles:insertAttribute name="body" flush="false" />
			
		</div>
	</div>

	<tiles:insertAttribute name="footer" flush="false" />
</body>
</html>