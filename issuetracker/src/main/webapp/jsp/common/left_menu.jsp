<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

		<div class="col-md-12 left-sidebar thumbnail" id="left-list">
			<ul class="nav nav-pills nav-stacked main-menu">
				<li class="active menu">
					<a href="#" id="project">서비스 관리</a>
					
					<!-- <ul style="display:block;"> -->
					<ul class="menu list-group">
						<li class="list-group-item"><a id="smInfo" href="#">서비스 정보</a></li>
						<li class="list-group-item"><a id="smWrite" href="#">서비스 등록</a></li>
					</ul>
				</li>
					
				<li class="menu">
					<a href="#" id="customer">고객 관리</a>
					
					<ul class="menu list-group">
						<li class="list-group-item"><a id="cuInfo" href="#">고객 정보</a></li>
						<li class="list-group-item"><a id="cuWrite" href="#">고객 등록</a></li>
					</ul>
				</li>
					
				<li class="menu">
					<a href="#" id="business">거래처 관리</a>
					
					<ul class="menu list-group">
						<li class="list-group-item"><a id="coInfo" href="/issuetracker/businessManager/businessList.do">거래처 정보</a></li>
						<li class="list-group-item"><a id="coWrite" href="/issuetracker/businessManager/businessWrite.do">거래처 등록</a></li>
					</ul>
				</li>
				
				<li class="menu">
					<a href="#" id="service">프로젝트 관리</a>
					
					<ul class="menu list-group">
						<li class="list-group-item"><a id="pjInfo" href="#">프로젝트 정보</a></li>
						<li class="list-group-item"><a id="pjWrite" href="#">프로젝트 등록</a></li>
					</ul>
				</li>
				
				<li class="menu">
					<a href="#" id="service">서비스 리포트</a>
					
					<ul class="menu list-group">
						
					</ul>
				</li>
				
				<li class="menu">
					<a href="#" id="service">사용자 관리</a>
					
					<ul class="menu list-group">
						<li class="list-group-item"><a id="userInfo" href="#">사용자 정보</a></li>
						<li class="list-group-item"><a id="userWrite" href="#">사용자 등록</a></li>
					</ul>
				</li>
			</ul>
		</div>