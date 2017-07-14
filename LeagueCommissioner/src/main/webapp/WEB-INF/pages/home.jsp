<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<!-- Download Bootstrap -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<link rel="stylesheet" type="text/css" href="static/css/style.css">
		<link rel="icon" type="image/png" href="static/img/BasketBall.png">
		<script type="text/javascript" src="static/js/default.js"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>League Commissioner</title>
</head>
	
	<body>
		
		<%@ include file="/navbar.jsp" %>
		<div class="navbar-clear"></div>
		
		<div class="row">
			<div class="col-md-12 col-lg-9 main-screen">
				<c:choose>
					<c:when test="${ sessionScope.league == null }">
						<!--  commissioner selects league (List of available leagues in modelMap) -->
						<table class="table table-hover">
						  <thead>
						    <tr>
						      <th>League ID</th>
						      <th>League Name</th>
						      <th>Sport</th>
						      <th></th>
						    </tr>
						  </thead>
						  <tbody>
						  	<c:forEach items="${ modelMap.allLeagues }" var="league">
						  		<tr>
						  			<td>${ league.getLeagueID() }</td>
						  			<td>${ league.getName() }</td>
						  			<td>${ league.getSport().getName() }</td>
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
							<c:when test="${ sessionScope.user.getRole() == 2 }">
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
			</div>
			<div class="space"></div>
			<div class="col-md-3 hidden-md-down sidebar">
				<div class="sidebar-container">
					<%@ include file="/sidebar.jsp" %>
				</div>
			</div>
		</div>
	
	</body>
	
</html>
