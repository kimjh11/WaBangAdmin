<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 답변 등록 성공 -->
<c:if test="${cnt>0}">
	<script>
		location.href="<%=request.getContextPath()%>/search/questionList.do";
	</script>
</c:if>
<!-- 답변 등록 실패 -->
<c:if test="${cnt<=0 }">
	<script>
		alert("답변 등록이 실패하였습니다.");
		history.back();
	</script>
</c:if>