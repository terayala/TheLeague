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
			<form action="createuser" method="POST">
				First Name: <input type="text" name="firstName"/>
				<br>
				Last Name: <input type="text" name="lastName"/>
				<br>
				Email: <input type="email" name="email"/>
				<br>
				Username: <input type="text" name="username"/>
				<br>
				Temporary Password: <input type="text" name="password"/> 
				<br>
				Team: <select name="team">
						<c:forEach items="${ requestScope.teams }" var="team">
							<option value="${ team.getTeamID() }">${ team.getName() } </option>
						</c:forEach>
					</select>
				<br>
				<input type="submit" value="Register">
			</form>
		</c:when>
		<c:otherwise>
			<h1>Register A Player</h1>
			<hr>
			<form action="createuser" method="POST">
				First Name: <input type="text" name="firstName"/>
				<br>
				Last Name: <input type="text" name="lastName"/>
				<br>
				Email: <input type="text" name="email"/>
				<br>
				Username: <input type="text" name="username"/>
				<br>
				Temporary Password: <input type="text" name="password"/> 
				<br>
				Uniform Number: <input type="text" name="uniform"/>
				<br>
				<input type="submit" value="Register">
			</form>
		</c:otherwise>
	</c:choose>
</div>
