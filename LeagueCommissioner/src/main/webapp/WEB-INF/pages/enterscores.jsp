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
				
				<div class="enter-score-container">
				
					<h3>Enter Results of Game</h3>
					<hr>
					
					<div class="row">
						<div class="col-6">
							<div class="enter-home-team">${ requestScope.game.getHomeTeam().getName() }</div>
							<div class="enter-home-score"><input type="text" name="home"></div>
						</div>
						
						<div class="col-6">
							<div class="enter-away-score"><input type="text" name="away"></div>
							<div class="enter-away-team">${ requestScope.game.getAwayTeam().getName() }</div>
						</div>
					</div>
					
					<div style="clear:both;"></div>
					
					<hr>
					
					<div class="row">
						<div class="col-6">
							<c:forEach items="${ requestScope.homePlayers }" var="player">
								<div class="row">
								<div class="col-12">
								<c:if test="${ player.getRole() == 1 }">
									${ player.getUniform() } - ${ player.getFirstName() } ${ player.getLastName() }
									<input type="text" class="player-goals" style="float:right;"
									name="${ player.getUsername() }" placeholder="#${ player.getUniform() }"> 
									<div class="clear:both;"></div>
								</c:if>
								</div></div>
							</c:forEach>
						</div>
						
						<div class="col-6">
							<c:forEach items="${ requestScope.awayPlayers }" var="player">
								<div class="row">
								<div class="col-12 away-players">
								<c:if test="${ player.getRole() == 1 }">
									<input type="text" class="player-goals" style="float:left;"
									name="${ player.getUsername() }" placeholder="#${ player.getUniform() }">
									${ player.getFirstName() } ${ player.getLastName() } - ${ player.getUniform() }
									<div class="clear:both;"></div>
								</c:if>
								</div></div>
							</c:forEach>
						</div>
					</div>
					
					<hr>
				
					<div class="row">
						<button href="http://13.58.132.64:8085/LeagueCommissioner/enterscores" type="submit" class="btn btn-default" value="POST" style="margin:auto;">Submit Score</button>
					</div>
					
				</div>
				
			</div>
			
			<div class="col-md-3 hidden-md-down sidebar">
				<div class="sidebar-container">
					<%@ include file="/sidebar.jsp" %>
				</div>
			</div>
		</div>
	
	</body>
	
</html>