<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>add page</h1>
	<form action="./add.do" method="post">
		학생이름<input type="text" name="name"><br>
		국어점수<input type="text" name="korean"><br>
		영어점수<input type="text" name="english"><br>
		수학점수<input type="text" name="math"><br>
		
		
		
		<p>
	<!-- 	<select name="bookSale">
			<option value="1">판매가능</option>
			<option value="0" selected>판매중지</option>
		</select> -->
		</p>
		
		<button type="submit">등록</button>
		<input type="submit" value="add">
		<input type="reset" value="add">
		<input type="button" value="add">
	</form>
</body>
</html>