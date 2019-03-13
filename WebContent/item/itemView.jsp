<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1"> 
<title>상품 상세페이지</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
<%@ include file="../search/menu.jspf" %><br/>
<script>
	$(function(){
		$("#delete").click(function(){
			if(confirm("삭제하시겠습니까?")){
				location.href="${ctx}item/itemDelete.do?code=${vo.code}";				
			}
		})
	})
</script>
<style>
	*{text-align:left}
	h1{margin:1% 20%}
	#btns{margin:1% 20%}
</style>
</head>
<body class="container">
<h1>${vo.name}</h1>
<form method = "post" action="${ctx}item/itemEdit.do?code=${vo.code}">
	<div> <!-- 상품 코드  -->
			<label class="col-sm-2">상품 코드 </label>
			<label class="col-sm-2">${vo.code}</label>
		</div>
		<div> <!-- 카테고리 select들  -->
			<label class="col-sm-2">카테고리</label>
			<label class="col-sm-3">${vo.category}</label>
		</div>
		<div> <!-- 상품명, 판매금액, 할인률   -->
			<label class="col-sm-2">상품명</label> 
				<label class="col-sm-3">${vo.name}</label><br/>
			<label class="col-sm-2">판매금액 </label>
				<label class="col-sm-3">${vo.price}원</label> 
			<label class="col-sm-2">할인률 </label>
				<label class="col-sm-3">${vo.discount}%</label>	
		</div>
		<div> <!-- 옵션, 색깔 -->
			<label class="col-sm-2">옵션</label>
			<label class="col-sm-3">${vo.option}</label>
			<label class="col-sm-2">색깔</label>
			<label class="col-sm-3">${vo.color}</label>
		</div>
		<div>  <!-- 썸네일 이미지,  -->
			<label class="col-sm-2">썸네일</label>
				<label class="col-sm-3">${vo.thumbnail}</label><br/>
			<label class="col-sm-2">내용</label>
				<label class="col-sm-3">${vo.detail}</label>
		</div>
		<div id="btns">
			<input type="submit" id="submit" value="수정" />
			<input type="button" id="delete" name="delete" value="삭제"/>
		</div>
</form>
</body>
</html>