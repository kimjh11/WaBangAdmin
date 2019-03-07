<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!-- 지시부 태그 라이브러리 표시 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<title>admin 로그인</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
<script>
	$(function(){
		/* 아이디를 입력하지 않았을때 */
		$("#loginBtn").on("click",function(){
			var adminid = $("#adminid").val(); //text값 변수에 저장
			if(adminid == ""){
				$("#warning").text("아이디 또는 비밀번호를 입력해주세요.");
			}else{
				return true;
			}
			return false;
		});
		/* 아이디 입력시 경고글 없어지게 하는 부분 */
		$("#adminid").on("keydown",function(){
			$("#warning").text("");
		});
		
		/* 비밀번호 입력하지 않았을때 */
		$("#loginBtn").on("click",function(){
			var adminpwd = $("#adminpwd").val();
			if(adminpwd == ""){
				$("#warning").text("아이디 또는 비밀번호를 입력해주세요.");
			}else{
				return true;
			}
			return false;
		});
		/* 비밀번호 입력시 경고글 없어지게 하는 부분 */
		$("#adminpwd").on("keydown",function(){
			//$("#warningpwd").text("");
			$("#warning").text("");
		});
	});
</script>

<!-- 커스텀 CSS -->
<link href="<%=request.getContextPath()%>/css/login.css" rel="stylesheet" media="screen">
<!-- 폰트 CSS -->
<link href="<%=request.getContextPath()%>/fonts/fonts.css" rel="stylesheet">
</head>
<body>
	<section class="container">
		<div class="wrap">
			<div class="loginLogo">
				<h1 class="font-coiny"><a href="<%=request.getContextPath()%>/index.do">WA BANG</a></h1>
				<hr/>
			</div>
			
			<div class="formDiv">
				<form method="post" action="<%=request.getContextPath()%>/login/loginOk.do" name="frm1" id="frm1">
					<div class="form-group" id="useridDiv">
						<label for="userid" class="font-noto-login-T">아이디</label><br/>
						<input type="text" id="adminid" name="adminid" class="form-control"/>
						<label></label>
					</div>
					<div class="form-group">
						<label for="userpwd" class="font-noto-login-T">비밀번호</label><br/>
						<input type="password" id="adminpwd" name="adminpwd" class="form-control"/>
						<label></label>
					</div>
					<label id="warning"><!-- 경고글 --></label>
					<input type="submit" value="로그인" id="loginBtn" class="font-noto-login-T form-control btn"/>
				</form>
				<hr/>
			</div>
		</div>
	</section>
</body>
</html>