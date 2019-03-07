<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- 로그인 성공시 -->
<c:if test="${vo.loginStatus == 'Y'}">
	<script>
		location.href="<%=request.getContextPath()%>/search/memberList.do";
	</script>
</c:if>
<!-- 로그인 실패시 -->
<c:if test="${vo.loginStatus == 'N'}">
	<script>
		alert("아이디 비밀번호 확인해 주세요.");
		history.back();
	</script>
</c:if>