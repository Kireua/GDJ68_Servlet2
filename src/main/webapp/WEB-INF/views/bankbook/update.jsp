<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>update</h1>
	<form action="./update.do" method="post">
		<input type="hidden" name="bookNum" value="${dto.bookNum }">
		상품명<input type="text" name="bookName" value="${dto.bookName }"><br>
		내용<textarea rows="" cols="" name="bookContents">${dto.bookContents}</textarea>
		이자율<input type="text" name="bookRate" value="${dto.bookRate }"><br>
		
		<p>
			판매가능<input type="radio" name="bookSale" checked value="1"><br>
			판매중지<input type="radio" name="bookSale" value="0"><br>
		</p>
		
		
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