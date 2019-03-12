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
	#depositLiDiv{margin-top:30px}
	#depositLiTa{margin-top:30px}
</style>
</head>
<body>
<%@include file="menu.jspf" %><br/>
<script>
	$(function(){
		$("#search3").on("keyup",function(){
			//입력한 검색어를 구해와야 한다.
			var value = $("#search3").val().toUpperCase(); // $(this).val();
			
			$("#depositList tr").filter(function(){
				$(this).toggle($(this).text().toUpperCase().indexOf(value) > -1);
			});
		
		});
	});
</script>
<h2>배송목록</h2>
<div id="depositLiDiv">
	<input class="form-control" type="text" id="search3" placeholder="검색어 입력 하세요." value="${vo.searchWord }"/>
	<span>* 검색방법: 아이디, 주문번호(예: 20190304A48B), 주문날짜(예: 2019-09-15) </span>
	<table id="depositLiTa"class="table table-bordered table-striped">
			<thead>
			<tr style="background:lightblue">
				<td>아이디</td>
				<td>주문번호</td>
				<td>상품코드</td>
				<td>결제금액</td>
				<td>입금확인</td>
				<td>배송확인</td>
				<td>주문날짜</td>
				<td>결제날짜</td>
				<td>배송날짜</td>
			</tr>
			</thead>
			<tbody id="depositList">
			<c:forEach var="OrderListVO" items="${list}">
					<tr>
						<td>${OrderListVO.m_id }</td>
						<td>${OrderListVO.o_num }</td>
						<td>${OrderListVO.i_code }</td>
						<td>${OrderListVO.o_payment }</td>
						<c:if test="${OrderListVO.o_deposit=='미결제' }">
							<td style="color:red">${OrderListVO.o_deposit }</td>
						</c:if>
						<c:if test="${OrderListVO.o_deposit=='결제완료' }">
							<td style="color:blue">${OrderListVO.o_deposit }</td>
						</c:if>
						<c:if test="${OrderListVO.o_delivery=='배송준비중' }">
							<td><a style="color:red" href="${ctx }search/deliveryOk.do?i_code=${OrderListVO.i_code }&m_id=${OrderListVO.m_id }&o_num=${OrderListVO.o_num }">${OrderListVO.o_delivery }</a></td>
						</c:if>
						<c:if test="${OrderListVO.o_delivery=='배송완료' }">
							<td><a style="color:blue" href="${ctx }search/deliveryOk.do?i_code=${OrderListVO.i_code }&m_id=${OrderListVO.m_id }&o_num=${OrderListVO.o_num }">${OrderListVO.o_delivery }</a></td>
						</c:if>
						<td>${OrderListVO.o_date }</td>
						<td>${OrderListVO.o_fix }</td>
						<td>${OrderListVO.o_deliverydate }</td>						
					</tr>
			</c:forEach>
			</tbody>
		</table>
</div>
</body>
</html>