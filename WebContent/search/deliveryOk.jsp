<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${cnt>0 }">
	<script>
		alert("배송완료.");
		location.href="<%=request.getContextPath()%>/search/depositList.do";
	</script>
</c:if>
<c:if test="${cnt<=0 }">
	<script>
		alert("배송실패.");
		history.go(-1);
	</script>
</c:if>