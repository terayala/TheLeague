<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>League Commissioner</title>
		
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
				<table class="table table-hover">
					<!-- check role for coach, player/commissioner in otherwise -->
						  <thead>
						    <tr>
						      <th>Game Date</th>
						      <th>Home Team</th>
						      <th>Away Team</th>						  
						      <th>Home Score</th>
						      <th>Away Score</th>
						    </tr>
						  </thead>
						  <c:choose>
						  	<c:when test="${ sessionScope.user.getRole() == 2 }">
						  	<tbody>
						  	<c:forEach items="${ requestScope.allGames }" var="game">
						  	<!-- check for scores: if yes, display scores; if none, add button to enter scores -->
						  		<tr>
						  			<td>${ game.getGameDate() }</td>
						  			<td>${ game.getHomeTeam().getName() }</td>
						  			<td>${ game.getAwayTeam().getName() }</td>
						  		<c:choose>
						  			<c:when test="${ game.getHomeScore() == null }">
						  				word
						  				<td><a class="btn btn-default" 
								  			href="http://localhost:8085/LeagueCommissioner/enterscores">Enter Scores</a></td>
						  			</c:when>
						  			<c:otherwise>
							  			<td>${ game.getHomeScore() }</td>
										<td>${ game.getAwayScore() }</td>
						  			</c:otherwise>
						  		</c:choose>	
						  		</tr>					  		
						  	</c:forEach>
						  </tbody>
						  </c:when>
						  <c:otherwise>
						  	<tbody>
						  	<c:forEach items="${ requestScope.allGames }" var="game">
						  		<tr>
						  			<td>${ game.getGameDate() }</td>
						  			<td>${ game.getHomeTeam().getName() }</td>
						  			<td>${ game.getAwayTeam().getName() }</td>
						  			<td>${ game.getHomeScore() }</td>
									<td>${ game.getAwayScore() }</td>
						  		</tr>					  		
						  	</c:forEach>
						  </tbody>
						  </c:otherwise>
						  </c:choose>
						</table>
					</div>
			
			<div class="col-md-3 hidden-md-down sidebar">
				<div class="sidebar-container">
					<%@ include file="/sidebar.jsp" %>
				</div>
			</div>
		</div>
	
	</body>
	
</html>