<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<title>제목</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
<style>
	h2{margin-top:30px}
	#memberLiDiv{margin-top:30px}
	#memberLiTa{margin-top:30px}
</style>
</head>

<body>
<%@include file="menu.jspf" %><br/>
<script>
	$(function(){
		$("#search1").on("keyup",function(){
			//입력한 검색어를 구해와야 한다.
			var value = $("#search1").val().toUpperCase(); // $(this).val();
			
			$("#memberList tr").filter(function(){
				$(this).toggle($(this).text().toUpperCase().indexOf(value) > -1);
			});
		
		});
	});
</script>
<h2>회원목록</h2>
<div id="memberLiDiv">
	<input class="form-control" type="text" id="search1" name="searchWord" placeholder="검색어 입력 하세요."/>
	<span>* 검색방법: 아이디, 이름, 날짜(예: 2019-09)</span>
	<table id="memberLiTa" class="table table-bordered table-striped">
		<thead>
			<tr style="background:lightblue">
				<td>아이디</td>
				<td>이름</td>
				<td>연락처</td>
				<td>이메일</td>
				<td>우편번호</td>
				<td>검색주소</td>
				<td>상세주소</td>
				<td>가입날짜</td>
			</tr>
		</thead>
		<tbody id="memberList">
			<c:forEach var="MemberListVO" items="${list}">
				<tr>
					<td><a href="${ctx }search/orderList.do?searchWord=${MemberListVO.m_id }">${MemberListVO.m_id }</a></td>
					<td>${MemberListVO.m_name }</td>
					<td>${MemberListVO.m_tel }</td>
					<td>${MemberListVO.m_email }</td>
					<td>${MemberListVO.m_zipCode }</td>
					<td>${MemberListVO.m_addr }</td>
					<td>${MemberListVO.m_addrDetail }</td>
					<td>${MemberListVO.m_regdate }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</div>
</body>
</html>