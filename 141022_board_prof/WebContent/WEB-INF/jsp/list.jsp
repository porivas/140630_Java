<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" buffer="8kb"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<script type="text/javascript" src="/board/js/paging.js"></script>

<form name='form1'>
  <input type='hidden' name='bno'>
  <input type='hidden' name='page' value='${cri.page }'>
  <input type='text' name='keyword' value='${cri.keyword }'>
  <input type='checkbox' name="types" value="t" ${cri.checked("t") }>Titie
  <input type='checkbox' name="types" value="w" ${cri.checked("w") }>Writer
  <input type='checkbox' name="types" value="c" ${cri.checked("c") }>Content
  <button onclick="javascript:goSearch();">Search</button>
</form>

<ul>
  <c:forEach var="str" varStatus="status" 
    items="${list}">
    <li><a href="javascript:viewData(${str.bno })"> ${str } </a> </li>
  </c:forEach>
</ul>

<%@include file="include/paging.jsp" %>


</body>
</html>










