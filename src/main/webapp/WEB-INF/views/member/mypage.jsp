<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="../temp/bootStrap.jsp"></c:import>
<title>마이페이지</title>
</head>
<body>
	<c:import url="../temp/header.jsp"></c:import>

	<section class="container mt-5">	
	<h1 class="my-4">마이 페이지</h1>
	<form action="./mypage.do" method="post">
	
	<div class="mb-3">
	  <label for="id" class="form-label">ID</label>
	  <input type="text" name="id" class="form-control" id="id"  value="${sessionScope.member.id }">
	</div>
	
	<div class="mb-3">
	  <label for="name" class="form-label">Name</label>
	  <input type="text" name="name" class="form-control" id="name" value="${sessionScope.member.name }">
	</div>
	
	</form>
	
	
	</section>
</body>
</html>