<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
	<link href="/issuetracker/css/bootstrap.min.css" rel="stylesheet" type="text/css" >
	<link href="/issuetracker/css/etc.css" rel="stylesheet" type="text/css" >
	<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
	<script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
	<script src="/issuetracker/js/bootstrap.min.js" ></script>

<form id="searchZip" name="searchZip">
   <table>
      <tr>
         <td>읍/면/동</td>
         <td><input type="text" id="searchText" name="searchText" size="10"></td>
         <td><input type="button" id="searchBtn" name="searchBtn" value="검색"></td>
      </tr>
   </table>
</form><hr/>

   <div>
      <table border="1px">
         <tr align="center">
            <th>우편번호</th>
            <th>시도</th>
            <th>시군구</th>
            <th>읍면동</th>
            <th>리</th>
            <th>번지</th>
            <th>아파트/건물명</th>
         </tr>

         <c:forEach var="zipList" items="${zipList}">
            <tr>
               <td><a href="javascript:sendAdd('${zipList.zipcode}')">${zipList.zipcode} </a></td>
               <td>${zipList.sido}</td>
               <td>${zipList.gugun}</td>
               <td>${zipList.dong}</td>
               <td>${zipList.ri}</td>
               <td>${zipList.bunji}</td>
               <td>${zipList.building}</td>
               <input type="hidden" id="${zipList.zipcode}" value="${zipList.totalAddress}">
            </tr>
         </c:forEach>
      </table>
   </div>   
   
<script>
   
   $("#searchBtn").on("click", function() {
      
      var searchZip = $("#searchZip");
      if($("#searchText").val() == "") {
         alert("동이름 을 입력하세요.");
         $("#searchText").focus();
      } else {
         searchZip.submit();
      }
   });
   
   function sendAdd(zipcode){
	   //alert("부모값 전달");
	   //opener.document.getElementById("co_postcode1").value=zipcode;
	   var totalAddress = "#"+zipcode;
	   $("#co_postcode", opener.document).val(zipcode);
	   $("#co_address1", opener.document).val($(totalAddress).val());
	   
	   //$("#co_address1", opener.document).val(gugun);
	   //$("#co_address1", opener.document).val(dong);
	   //$("#co_address1", opener.document).val(ri);
	   //$("#co_address1", opener.document).val(bunji);
	   //$("#co_address1", opener.document).val(building);
	   window.close();
   }
   
   
</script>