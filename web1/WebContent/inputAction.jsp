<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	// only post
	request.setCharacterEncoding("UTF-8");
	String bookName = request.getParameter("bookName");
	// only get 
	// bookName = new String (bookName.getBytes("8859_1"),"UTF-8");
	String publisher = request.getParameter("publisher");
	String bookDesc = request.getParameter("bookDesc");
	
	System.out.println(bookName);
	System.out.println(publisher);
	System.out.println(bookDesc);
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
	var msg = "SUCCESS";
	window.parent.showMsg(msg);
	alert("이 페이지는 결과 페이지입니다.");
	</script>
</body>
</html>