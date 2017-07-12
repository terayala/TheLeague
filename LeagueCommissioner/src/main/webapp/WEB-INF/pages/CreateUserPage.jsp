<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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