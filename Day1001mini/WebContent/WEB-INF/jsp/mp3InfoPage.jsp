<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
</html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>mp3InfoPage</title>
</head>
<body>
	<!-- 모달을 켜고 끄는 버튼 -->
	<a href="#myModal" role="button" class="btn" data-toggle="modal">모달 시연 시작</a>
	 
	<!-- 모달 -->
	<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	    <h3 id="myModalLabel">모달 제목</h3>
	  </div>
	  <div class="modal-body">
	    <p>한 멋진 본문…</p>
	  </div>
	  <div class="modal-footer">
	    <button class="btn" data-dismiss="modal" aria-hidden="true">닫기</button>
	    <button class="btn btn-primary">변경사항 저장</button>
	  </div>
	</div>
	<h1>mp3InfoPage.jsp</h1>
	<!--정보 띄우기-->
	${mp3Info.getTitle()}
	<br>
	<!-- 오디오 실행??? 잘....--> 
	
	
		<iframe name="songFrame" width="500" height="200" src="play?song=${mp3Info.getFileName()}">오디오플레이어</iframe>
	
	<h2>list page</h2>
	
	<ul>
	<li><a href="play?song=${mp3Info.getFileName()}" target="songFrame">파일명 : ${mp3Info.getTitle()}</a></li>
			
		
	</ul>
	

	
</body>
</html>