<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page trimDirectiveWhitespaces="true" %>
<c:if test="${cnt>0}">  <!-- 삭제 됬을떄 -->
	<script>
		alert("글이 삭제되었습니다.");
		location.href="<%=request.getContextPath()%>/item/itemList.do";
	</script>
</c:if>


<c:if test="${cnt<0}"> <!-- 삭제안됬을때 -->
	<script>
		alert("삭제에 실패했습니다.");
		history.back();
	</script>
</c:if>