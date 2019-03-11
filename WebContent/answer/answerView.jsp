<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>답변 보기</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
<script src="https://cdn.ckeditor.com/4.11.2/full/ckeditor.js"></script>

<!-- 커스텀 CSS -->
<link href="../css/answer.css" rel="stylesheet"/>

<script>
	//글 삭제하기
	function deleteCheck(){
		if(confirm("글을 삭제하시겠습니까?")){
			location.href="<%=request.getContextPath()%>/answer/answerDeleteOk.do?q_num=${vo.q_num}";
		}	
	}
</script>
</head>
<%@ include file="../search/menu.jspf" %>
<body>
	<div class="container">
	
	<h3 id="qnaTitle">질문</h3>
	
		<!-- 아이디 -->
		<div class="form-group row">
			<input type="text" id="userid" name="userid" value="${vo.m_id}" readonly class="form-control col-sm-9 qnaViewId"/>
		</div>
			
		<!-- 글 제목, 글 내용  -->
		<div class="form-group row text">
			<label class="col-sm-9" id="qnaViewTitle">${vo.q_title}</label>
		</div>
		<div class="form-group row" id="qnaContent">
			<label class="form-control col-sm-10" id="qnaViewContent">${vo.q_content}</label>
		</div>
		
		<c:if test="${answervo.a_comment !=null && answervo.a_comment != ' '}">
			<hr/>
			<button type="button" class="btn btn-outline-dark btn-sm" id="qnaUpdateBtn">
		  		<a href="<%=request.getContextPath()%>/answer/answerUpdateForm.do?q_num=${vo.q_num}">수정하기</a>
			</button>
			<button type="button" class="btn btn-outline-dark btn-sm" id="qnadeleteBtn">
				<!-- 페이지 이동 개념보다 함수를 호출하는 개념으로. -->
		  		<a href="javascript:deleteCheck()">삭제하기</a>
			</button>
			<h3 id="qnaTitle">답변</h3> 
		</c:if>
		
	<!-- 답변 입력 부분 -->
		<form method="post" action="<%=request.getContextPath()%>/answer/answerWriteOk.do">
			<div class="form-group row" id="qnaContent">
				<label>${answervo.a_comment}</label>
			</div>
			<!-- 글번호, 아이디, 어드민 아이디 보내기 -->
			<input type="hidden" name="q_num" value="${vo.q_num }"/>
			<input type="hidden" name="m_id" value="${vo.m_id}"/>
			<input type="hidden" name="adminid" value="${adminid}">
		</form>
	</div>
</body>
</html>