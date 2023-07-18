<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<c:import url="../temp/bootStrap.jsp"></c:import>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:import url="../temp/header.jsp"></c:import>
	<h1>회원가입 페이지</h1>
	<section>
	<form class="mb-5 text-center form-control" action="./join.do" method="post">
		<div class="input-group text-center"><label for="id" class="input-group-text" id="basic-addon2">ID　　</label><input type="text" id="id" name="id" placeholder="ID를 입력하세요." ></div><br>
		<div class="input-group text-center"><label for="pw" class="input-group-text" id="basic-addon2">PW　　</label><input type="password" id="pw" name="pw" ></div><br>
		<div class="input-group text-center"><label for="name" class="input-group-text" id="basic-addon2">이름　　</label><input type="text" id="name" name="name" placeholder="이름을 입력하세요."></div><br>
		<div class="input-group text-center"><label for="email" class="input-group-text" id="basic-addon2">EMAIL</label><input type="email" id="email" name="email" placeholder="example@example.com"></div><br>
		<div class="input-group text-center"><label for="birth" class="input-group-text" id="basic-addon2">생년월일</label><input type="date" id="birth" name="birth" ></div><br>
		
			<button type="submit" class="btn btn-outline-secondary">회원가입</button>
		
	</form>
	</section>
</body>
</html>