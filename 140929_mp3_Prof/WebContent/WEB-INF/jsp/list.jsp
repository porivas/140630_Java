<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<iframe name='songFrame' >
</iframe>

<h2>${fileList.size()}</h2>

<div>
    <a href='list?dir=${path}'>이전</a>
</div>


<ul>
  <c:forEach var="str" items="${fileList}">
  	<c:choose>
  	<c:when test="${str.lastIndexOf('.mp3') > 0}">
  	  <li><a href='listen?song=${param.dir}/${str}' target="songFrame">${str}-${mp3.desc}</a></li>
 	</c:when>
 	
 	<c:when test="${str.lastIndexOf('.') > 0}">
  	  <li><a href='download?file=${param.dir}/${str}'>${str}</a></li>
 	</c:when>
 	
  	  <c:otherwise>
  	  <li><a href='list?dir=${param.dir}/${str}'>[${str}]</a></li>
  	  </c:otherwise>
  	  
  	</c:choose> 
  </c:forEach>
  
  <!--upload 로 연결되는 버튼 만들어줘  -->

	<form action = "list" method="get">
	<a href='list?dir=${param.dir}' target="_parent">
	<input type="button" value="refresh" target="/140929_mp3_Prof/list">
	</a>
	<a href='/140929_mp3_Prof/upload' target="uploadFrame">
	<input type="button" value="업로드" target="/140929_mp3_Prof/upload">
	</a>
	</form>

</ul>

<iframe name='uploadFrame' width = 30% height = 200px></iframe>

</body>
</html>











