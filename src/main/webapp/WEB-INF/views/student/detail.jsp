<%@page import="com.iu.main.student.StudentDTO"%>
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
	<h1>detail page</h1>
	<%StudentDTO studentDTO = (StudentDTO)request.getAttribute("dto"); %>
	
	<h3><%= studentDTO.getName() %></h3>
	<h1>${requestScope.dto.bookName}</h1>
	<h1>${dto.bookRate}</h1>
	
</body>
</html>