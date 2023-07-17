<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BankBook List</h1>
	<!-- 표현식 -->

	<table>
		<thead>
			<th>상품명</th><th>이자율</th>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="d" varStatus="i">
				<tr>
					<td><a href="./detail.do?bookNum=${d.bookNum}">${d.bookName}</a></td>
					<td>${d.bookRate} ${i.index}</td>
				</tr>
			</c:forEach>
			
		</tbody>
	</table>
	
	<a href="./add.do">상품등록</a>
	
<%-- 	<c:forEach begin="1" step="2" end="10" var="num">
		<h1>${num}</h1>
	</c:forEach> --%>
</body>
</html>