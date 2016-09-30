<!DOCTYPE html>
<html lang="ko">

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>

<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="/issuetracker/js/bootstrap.min.js"></script>
    
<head>

	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<!-- Bootstrap -->
	<link href="/issuetracker/css/bootstrap.min.css" rel="stylesheet" type="text/css" >
	<link href="/issuetracker/css/etc.css" rel="stylesheet" type="text/css" >
	
	<style>
		#align {
			display:table;
			margin-left:0 auto;
		}
	</style>
	
</head>

<script lang="javascript">

	$(document).ready(function(){
				
		/* $("#loginCtrl").on("click", function() {
			var url="/bootstrap/view/index.jsp";
			$(location).attr("href", url)
		}); */
		
		$("#loginBtn").on("click", function() {
			var loginForm = $("#loginCtrl");
			loginForm.attr("method", "post").attr("action", "/issuetracker/j_spring_security_check");
			loginForm.submit();
		});
		
	});
</script>

<body>
	<div class="container theme-showcase">
		<div class="container jumbotron" style="margin-top:10%;">
			<h1 align="center">Service Management System</h1>
		</div>
		
		<div class="container" style="margin-top: 5%;" id="align">
			<div class="col-md-6">
				<form id="loginCtrl">
				<table>
					<tr>
						<td><label class="col-lg-2 control-label"><h3>ID</h3></label></td>
						<td><input type="text" name="j_username" class="form-control" tabindex="1"></td>
						<td><label class="col-md-2"></label></td>
						<td rowspan="2"><input type="button" id="loginBtn" class="btn btn-lg btn-default" value="Login" tabindex="3" /></td>
					</tr>
					<tr>
						<td><label class="col-lg-2 control-label"><h3>PW</h3></label></td>
						<td><input type="password" name="j_password" class="form-control" tabindex="2"></td>
						<td><label class="col-md-2"></label></td>
					</tr>
				</table>
				</form>
			</div>
			
			<div class="col-md-6">
				<table>
					<tr><td><a href="#"><h1><small style="color: blue;">사용자 등록 요청</small></h1></a></td></tr>
					<tr><td><a href="#"><h1><small style="color: blue;">비밀번호 문의</small></h1></a></td></tr>
				</table>
			</div>
		</div>
	</div>
	
</body>

</html>