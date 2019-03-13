<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${cnt>0 }">  <!-- 삭재됨 -->
	<script>
		alert("수정완료되었습니다.");
		 location.href="<%=request.getContextPath()%>/item/itemView.do?code=${code}"; 
	</script>
</c:if>
<c:if test="${cnt<=0}"> <!-- 수정안댐 -->
	<script>
		alert("수정에 실패했습니다.");
		history.back();
	</script>	
</c:if>