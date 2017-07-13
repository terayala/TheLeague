<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>League Commissioner</title>
</head>
	<body>
		<!-- <div include="nav-bar"></div> -->
		<div class="createUser">
			<c:choose>
				<c:when test="${ user.getRole() == 3 }">
					<h1>Register A Coach</h1>
					<hr>
					<form:form action="createUser" method="POST" commandName="user">
						First Name: <form:input path="firstName"/>
						<br>
						Last Name: <form:input path="lastName"/>
						<br>
						Email: <form:input path="email"/>
						<br>
						Username: <form:input path="username"/>
						<br>
						Temporary Password: <form:input path="password"/> 
						<br>
						<input type="submit" value="createuser">
					</form:form>
				</c:when>
				<c:otherwise>
					<h1>Register A Player</h1>
					<hr>
					<form:form action="createUser" method="POST" commandName="user">
						First Name: <form:input path="firstName"/>
						<br>
						Last Name: <form:input path="lastName"/>
						<br>
						Email: <form:input path="email"/>
						<br>
						Username: <form:input path="username"/>
						<br>
						Temporary Password: <form:input path="password"/> 
						<br>
						Uniform Number: <form:input path="uniform"/>
						<br>
						<input type="submit" value="createuser">
					</form:form>
				</c:otherwise>
			</c:choose>
		</div>
	</body>
</html>
