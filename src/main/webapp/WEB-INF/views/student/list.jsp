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
	<h1>list page</h1>
	
	<table>
		<thead>
			<th>학생이름</th><th>총점</th><th>평균</th>
		</thead>
		<tbody>
			<c:forEach items="${studentList}" var="s" varStatus="i">
				<tr>
					<td><a href="./list.do?studNum=${s.studNum}">${s.studName}</a></td>
					<td>${s.total} ${i.index}</td>
					<td>${s.avg}</td>
				</tr>
			</c:forEach>
			
		</tbody>
	</table>
</body>
</html>