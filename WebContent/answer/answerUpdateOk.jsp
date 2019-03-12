<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 답변 수정 성공 -->
<c:if test="${cnt>0}">
	<script>
		location.href="<%=request.getContextPath()%>/answer/answerView.do?q_num=${q_num}";
	</script>
</c:if>
<!-- 답변 수정 실패 -->
<c:if test="">
	<script>
		alert("글 수정이 실패하였습니다.");
		history.back();
	</script>
</c:if>