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
	<c:choose>
		<c:when test="${ sessionScope.league == null }">
			<!--  commissioner selects league (List of available leagues in modelMap) -->
			<table class="table table-hover">
			  <thead>
			    <tr>
			      <th>League ID</th>
			      <th>League Name</th>
			      <th>Sport</th>
			    </tr>
			  </thead>
			  <tbody>
			  	<c:forEach items="${ modelMap.leagues }" var="league">
			  		<tr>
			  			<td>${ league.getLeagueID() }</td>
			  			<td>${ league.getName() }</td>
			  			<td>${ league.getSportID().getName() }</td>
			  			<td><button type="button" class="btn btn-info" value="Select League" onclick="submitLeague(${league})">
			  			</button></td>
			  		</tr>
			  	</c:forEach>
			  </tbody>
			</table>
		</c:when>
		<c:otherwise>
			<!-- regular home page with descriptions depending on user's role -->
			<p>WELCOME, ${ sessionScope.user.getFirstName() } ${ sessionScope.user.getLastName() }</p>
			<c:choose>
				<c:when test="${ sessionScope.user.getRole() == 1}">
				<!-- player home page view -->
					<p>PLAYER PAGE</p>
				</c:when>
				<c:when test="${ sessionScope.user.getRole() }== 2">
				<!-- coach home page view -->
					<p>COACH PAGE</p>
				</c:when>
				<c:otherwise>
				<!-- commissioner home page view -->
					<p>COMMISSIONER PAGE</p>
				</c:otherwise>
			</c:choose>
		</c:otherwise>
	</c:choose>
</body>
</html>
