<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script type="text/javascript">

$(document).ready(function(){
	
	/* 상단 네비개이션 */
	$("div#bs-example-navbar-collapse-1 ul li").on("click", function() {
		$(this).addClass("active").siblings().removeClass("active");
	});
	
	/* 사이드바 */
	$("div#left-list li").on("click", function() {
		$(this).addClass("active").siblings().removeClass("active");
	});
	
	/* 사이드바 에니메이션 */
	$(".menu>a").on("click", function() {
		var submenu = $(this).next("ul");
		
		if(submenu.is(":hidden")) {
			submenu.slideDown();
			submenu.parent().siblings("li").children("ul").slideUp();
			//submenu.parent().siblings("li").children("ul").hide();
		} else {
			submenu.slideUp();
		}
	});
			
	$("ul.panel li:not("+$("ul.nav-tabs li a.selected").attr("href")+")").hide();
	$("ul.nav-tabs li a").click(function(){
		$("ul.nav-tabs li a").removeClass("selected");
		$(this).addClass("selected");
		$("ul.panel li").hide();
		$($(this).attr("href")).show();
		$(this).parent().addClass("active").siblings().removeClass("active");
		return false;
	});
	
	/* 등록 버튼 클릭 */
	$("#write").on("click", function() {
		alert("등록버튼 눌렀음");
	});
	
	$("#logOut").on("click", function() {
		var url = "/issuetracker/j_spring_security_logout";
		$(location).attr("href", url);
	});
	
});

/* 숫자 유효성 체크 */	
function numCheck(columnName){
	var colName = "#" + columnName;
	$(colName).blur(function() {
		var number = $(this).val();
		
		if($(this).val() != "" ) {
			if($.isNumeric(number) == false) {
				alert("숫자를 입력하십시오.");
				$(this).focus();
				$(this).val("");
			}
		}
	});		
}

/* 필수 체크(빈 텍스트 체크) */
function nullCheck(columnId, columnName) {
	
	var colId = "#" + columnId;
	
	if($(colId).val().length > 0) {
		return true;
	} else {
		alert(columnName + "은(는) 필수 입력 항목입니다.");
		$(colId).focus();
		return false;	
	}
}

/* 필수 체크(이메일 체크) */
function emailCheck(email1, email2) {
	var em1 = "#" + email1;
	var em2 = "#" + email2;
	var fullEmail = $(em1).val() + "@" + $(em2).val();
	var RexEmail = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	if(RexEmail.test(fullEmail) == true) {
		return true;
	} else {
		alert("유효하지 않은 이메일 입니다.");
		$(em1).focus();
		return false;
	}
}

 /* url 이동 */
function urlMove(url) {
	$(location).attr("href", url);
}

</script>
