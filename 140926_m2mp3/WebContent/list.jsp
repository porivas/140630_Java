<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<iframe name='songFrame'>
	
<c:forEach var = "str" step="1" items = "${fileList}">
 <c:if test="true">
 	<li><a href = 'listen?song=${str }' target="songFrame"> ${str} </a></li>
 </c:if>
</c:forEach>
	
	</iframe>
</body>
</html>