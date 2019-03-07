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
	#orderLiDiv{margin-top:30px}
	#orderLiTa{margin-top:30px}
</style>
</head>
<body>
<%@include file="menu.jspf" %><br/>
<script>
	$(function(){
		$("#search2").on("keyup",function(){
			//입력한 검색어를 구해와야 한다.
			var value = $("#search2").val().toUpperCase();
		
			
			$("#orderList tr").filter(function(){
				$(this).toggle($(this).text().toUpperCase().indexOf(value) > -1);
			});
		
		});
	});
</script>
<h2>주문목록</h2>
<div id="orderLiDiv">
	<input class="form-control" type="text" id="search2" placeholder="검색어 입력 하세요." value="${vo.searchWord }"/>
	<span>* 검색방법: 아이디, 주문번호(예: 20190304A48B), 상품코드(예: A7588BTF), 주문날짜(예: 2019-09-15) </span>
	<table id="orderLiTa" class="table table-bordered table-striped">
			<thead>
			<tr style="background:lightblue">
				<td>아이디</td>
				<td>주문번호</td>
				<td>상품코드</td>
				<td>선택옵션</td>
				<td>상품가격</td>
				<td>옵션적용가격</td>
				<td>결제금액</td>
				<td>우편번호</td>
				<td>주소</td>
				<td>주문날짜</td>
			</tr>
			</thead>
			<tbody id="orderList">
				<c:forEach var="OrderListVO" items="${list}">
					<tr>
						<td>${OrderListVO.m_id }</td>
						<td><a href="${ctx }search/depositList.do?searchWord=${OrderListVO.o_num }">${OrderListVO.o_num }</a></td>
						<td><a href="${ctx }search/depositList.do?searchWord=${OrderListVO.i_code }">${OrderListVO.i_code }</a></td>
						<td>
							옵션: ${OrderListVO.o_selectOpt }<br/>
							수량: ${OrderListVO.o_count }
						</td>
						<td>${OrderListVO.i_price }</td>
						<td>${OrderListVO.o_price }</td>
						<td>${OrderListVO.o_payment }</td>
						<td>${OrderListVO.m_zipCode }</td>
						<td>
							${OrderListVO.m_addr }<br/>
							${OrderListVO.m_addrDetail }
						</td>
						<td>${OrderListVO.o_date }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</div>
</body>
</html>