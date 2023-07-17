<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Update page</h1>
	<form action="./update.do" method="post">
		<input type="hidden" name="studNum" value="${dto.studNum}">
		학생이름<input type="text" name="name" value="${dto.name}"><br>
		국어점수<input type="text" name="korean" value="${dto.korean }"><br>
		영어점수<input type="text" name="english" value="${dto.english }"><br>
		수학점수<input type="text" name="math" value="${dto.math }"><br>
		
		
		
		<p>
	<!-- 	<select name="bookSale">
			<option value="1">판매가능</option>
			<option value="0" selected>판매중지</option>
		</select> -->
		</p>
		
		<button type="submit">수정</button>
		<input type="submit" value="수정">
		<input type="reset" value="수정">
		<input type="button" value="수정">
	</form>
</body>
</html>