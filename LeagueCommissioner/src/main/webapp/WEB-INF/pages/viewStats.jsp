<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>View Stats</title>
		
		<link rel="icon" type="image/png" href="/LeagueCommissioner/static/img/BasketBall.png">
		<link rel="stylesheet" type="text/css" href="/LeagueCommissioner/static/css/style.css">
		
		<!-- Download Bootstrap -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
</head>
	<body>
		<%@ include file="/navbar.jsp" %>
		<div class="navbar-clear"></div>
		
		<div class="row">
			<div class="col-md-12 col-lg-9 main-screen">
				<c:choose>
					<c:when test="${not empty stats}">
					<h3>${ sessionScope.user.getFirstName() }&nbsp;${ sessionScope.user.getLastName() }'s Game Stats</h3>
					    <table>
					    	<thead>
					    		<tr>
					    			<th>Home Team</th>
					    			<th>Away Team</th>
					    			<th>Points Scored</th>
					    		</tr>
					    	</thead>
					    	<tbody>
						        <c:forEach var="s" items="${stats}">
						            <tr>
						                <td>${s.getGame().getHomeTeam().getName()}</td>
						                <td>${s.getGame().getAwayTeam().getName()}</td>
						                <td>${s.getPointsScored()}</td> 
						            </tr>
						        </c:forEach>
							</tbody>
					    </table>
					</c:when>
					<c:otherwise>
						<h3>${ sessionScope.user.getFirstName() }&nbsp;${ sessionScope.user.getLastName() } Has NO Stats. Bummer.</h3>
					</c:otherwise>
				</c:choose>
			</div>
			
			<div class="col-md-3 hidden-md-down sidebar">
				<div class="sidebar-container">
					<%@ include file="/sidebar.jsp" %>
				</div>
			</div>
		</div>
	</body>
</html>		                