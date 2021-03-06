<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--EL문 사용시 추가해줘야함 -->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MP3 Player</title>
</head>
<body>

<h1>MP3 Player</h1>

<iframe name="player" height="300" width="500"></iframe>
<%--플레이어가 표시될 iframe --%>
<ul>
<c:forEach var="file" items="${mp3List}">
<%--El문-forEach: 자바의 forEach문과 사용법은 같다. var부분에 배열이 들어가고 items에 리스트가 들어간다
items안의 ${mp3List}부분 또한 El문의 출력문으로 해당 이름을 가진 원소를 불러온다
불러온 원소를 다시 쌍따옴표""로 감싸서 html문 형식으로 만들어준다. 없으면 동작 안함--%>
	<li><a href ="/listen.han?file=${file}" target="player"> ${file} </a></li>
	<%--href로 링크경로를 잡아주고 get방식으로 file이라는 이름으로 파일명을 원소로 잡아준다 --%>
</c:forEach>
</ul>

</body>
</html>