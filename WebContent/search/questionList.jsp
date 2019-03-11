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
	#questionLiDiv{margin-top:30px}
	#questionLiTa{margin-top:30px}
</style>
</head>
<body>
<%@include file="menu.jspf" %><br/>
<script>
	$(function(){
		$("#search4").on("keyup",function(){
			//입력한 검색어를 구해와야 한다.
			var value = $("#search4").val().toUpperCase(); // $(this).val();
			
			$("#questionList tr").filter(function(){
				$(this).toggle($(this).text().toUpperCase().indexOf(value) > -1);
			});
		
		});
	});
</script>
<h2>문의목록</h2>
<div id="questionLiDiv">
	<input class="form-control" type="text" id="search4" placeholder="검색어 입력 하세요."/>
	<span>* 검색방법: 아이디, 제목(예: "안녕하세요"), 문의날짜(예: 2019-09-15) </span>
	<table id="questionLiTa" class="table table-bordered table-striped">
			<thead>
			<tr style="background:lightblue">
				<td>아이디</td>
				<td>제목</td>
				<td>내용</td>
				<td>답변여부</td>
				<td>문의날짜</td>
				<td>답변날짜</td>
			</tr>
			</thead>
			<tbody id="questionList">
			<c:forEach var="QuestionListVO" items="${list}">
				<tr>
					<td>${QuestionListVO.m_id }</td>
					<td>${QuestionListVO.q_title }</td>					
					<td>${QuestionListVO.q_content }</td>
					
					<!-- 답변 날짜, 질문 번호 -->
					<c:if test="${(QuestionListVO.a_regdate == null || QuestionListVO.a_regdate == ' ')}">
						<td><a href="<%=request.getContextPath()%>/answer/answerWriteForm.do?q_num=${QuestionListVO.q_num}"><button>답변하기</button></a></td>
					</c:if>
					<c:if test="${(QuestionListVO.a_regdate != null && QuestionListVO.a_regdate != ' ')}">
						<td><a href="<%=request.getContextPath()%>/answer/answerView.do?q_num=${QuestionListVO.q_num}"><label>답변완료</label></a></td>
					</c:if>	
					
					<td>${QuestionListVO.q_regdate }</td>
					<td>${QuestionListVO.a_regdate }</td>
					
				</tr>
			</c:forEach>
			</tbody>
		</table>
</div>
</body>
</html>