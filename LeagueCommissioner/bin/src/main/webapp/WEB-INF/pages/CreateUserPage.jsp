<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.revature.beans.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<div class="createUser">
		<c:choose>
		<c:when test="${ sessionScope.user.getRole() == 3 }">
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
				Team: <select name="team">
						<c:forEach items="${ requestScope.teams }" var="team">
							<option value="${ team.getTeamID() }">${ team.getName() } </option>
						</c:forEach>
					</select>
				<br>
				<input type="submit" value="Register">
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
				<input type="submit" value="Register">
			</form:form>
		</c:otherwise>
	</c:choose>
</div>
