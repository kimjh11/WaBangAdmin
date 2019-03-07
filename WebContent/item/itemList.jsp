<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1"> 
<title>상품리스트</title>
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
<%@include file="../search/menu.jspf" %><br/>
<script>
	$(function(){
		$("#search1").on("keyup",function(){
			//입력한 검색어를 구해와야 한다.
			var value = $("#search1").val().toUpperCase(); // $(this).val();
			
			$("#itemList tr").filter(function(){
				$(this).toggle($(this).text().toUpperCase().indexOf(value) > -1);
			});
		});
		$("tr").click(function(){
			alert($(this).find('td:eq(0)').text());
			location.href="${ctx}item/itemView.do?code="+$(this).find('td:eq(0)').text();
		})
	});
</script>
<h2>상품목록</h2>
<div id="memberLiDiv">
	<input class="form-control" type="text" id="search1" name="searchWord" placeholder="검색어 입력 하세요."/>
	<span>* 검색방법: 상품코드,상품명</span>
	<table id="itemTbl" class="table table-bordered table-striped table-hover">
		<thead>
			<tr style="background:lightblue">
				<td>상품코드</td>
				<td>상품명</td>
				<!-- <td>카테고리</td>
				<td>내용</td>
				<td>옵션</td>
				<td>색깔</td> -->
				<td>판매금액</td>
				<td>할인율</td>
				<!-- <td>썸네일</td> -->
				<td>등록일</td>
			</tr>
		</thead>
		<tbody id="itemList">
			<c:forEach var="item" items="${list}">
				<tr>
					<td>${item.code}</td>
					<td>${item.name}</td>
					<%-- <td>${item.category}</td>
					<td>${item.detail}</td>
					<td>${item.option}</td>
					<td>${item.color}</td> --%>
					<td>${item.price}</td>
					<td>${item.discount}</td>
					<%-- <td>${item.thumbnail}</td> --%>
					<td>${item.regdate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</div>
</body>
</html>