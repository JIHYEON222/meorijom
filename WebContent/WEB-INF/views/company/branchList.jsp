<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/js/jquery-3.3.1.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="/WEB-INF/views/common/header.jsp" />
		
		<div class="content">
		<table>
		<c:forEach items="${list }" var="a">
			<tr>
				<td>${a.salonAddr }</td>
				<div style="wudth:800px;margin: 0 auto;margin-bottom:10px;">
						<img src = "/upload/salon/${a.salonFilepath }" "width =100%;">
						
						</div>
			
			</tr>
			</c:forEach>
			</table>
			
		</div>
		<jsp:include page="/WEB-INF/views/common/footer.jsp" />
		
	</div>
</body>
</html>