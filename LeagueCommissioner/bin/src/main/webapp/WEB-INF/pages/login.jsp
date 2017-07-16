<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="static/css/style.css">
	<link rel="icon" type="image/png" href="static/img/BasketBall.png">
	<script type="text/javascript" src="static/js/default.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Login</title>
</head>
<body>
	<div class="login-background" style="background-image:url('static/img/Background.jpg')">
		<c:if test="${ errorMessage != null }">
			<div class="alert alert-danger">${ errorMessage }</div>
		</c:if>
		<div class="outerbox">
		<div class="login-vertical">
			<div class="login-wrapper">
				<h1>League Commissioner</h1>
				<p>Please Log In</p>
				<form:form action="login" method="POST" commandName="user">
					<p>Username: <form:input path="username"/>
					<form:errors path="username" cssClass="alert alert-danger" element="div"/></p>
					<p>Password: <form:password path="password"/>
					<form:errors path="password" cssClass="alert alert-danger" element="div"/></p>
					<form:hidden path="firstName"/>
					<form:hidden path="lastName"/>
					<form:hidden path="email"/>
					<div class="login-button"><input type="submit" value="login"></div>
				</form:form>
			</div>
		</div>
		</div>
		
	</div>
</body>
</html>