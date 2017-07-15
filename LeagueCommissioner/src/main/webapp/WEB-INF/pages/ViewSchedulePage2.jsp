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
			
				<h3 class="schedule-header">Schedule for
					<c:choose>
						<c:when test="${ sessionScope.user.getRole() == 3 }">
							${ sessionScope.league.getName() }
						</c:when>
						<c:otherwise>
							${ sessionScope.user.team.getName() }
						</c:otherwise>
					</c:choose>
				</h3>
			
				<div class="schedule-container">
					<table class="schedule-table">
					
						<!-- Will show a different table for commissioners than for coaches or players -->
						
						<!-- Header row -->
						<c:choose>
							<c:when test="${ sessionScope.user.getRole() == 3 }">
								<tr>
									<th class="sched-date">Date</th>
									<th class="sched-time">Time</th>
									<th class="sched-team">Home</th>
									<th class="sched-score"></th>
									<th style="text-align:right" class="sched-team">Visitor</th>
								</tr>
							</c:when>
							<c:otherwise>
								<tr>
									<th class="sched-date">Date</th>
									<th class="sched-time">Time</th>
									<th class="sched-opponent">Opponent</th>
									<th class="sched-team-score" style="text-align:right;">Score</th>
								</tr>
							</c:otherwise>
						</c:choose>
						
						<!-- Main body of table -->
						<c:forEach items="${ requestScope.allGames }" var="game">
							<tr>
								<td><fmt:parseDate pattern="MMM-dd-yyyy k:m:s" value="${ game.getGameDate() }" var="date" />
									<span class="hidden-sm-down"><fmt:formatDate pattern="MMM. d, yyyy" value="${ date }"/></span>
									<span class="hidden-md-up"><fmt:formatDate pattern="MMM. d" value="${ date }"/></span>
								</td>
								<td>
									<span class="hidden-sm-down"><fmt:formatDate pattern="h:mm a" value="${ date }"/></span>
									<span class="hidden-md-up"><fmt:formatDate pattern="h:mm" value="${ date }"/></span>
								</td>
							
								<c:choose>
									<c:when test="${ sessionScope.user.getRole() == 3 }">
										<td
											<c:if test="${ game.getHomeScore() > game.getAwayScore() }">
												style="font-weight:bold;"
											</c:if>
											>${ game.getHomeTeam().getName() }</td>
										<td style="text-align:center;">${ game.getHomeScore() }:${ game.getAwayScore() }</td>
							  			<td style="text-align:right;
							  				<c:if test="${ game.getHomeScore() < game.getAwayScore() }">
												font-weight:bold;
											</c:if>
							  			">${ game.getAwayTeam().getName() }</td>
									</c:when>
									<c:otherwise>
										<td>
											<c:choose>
												<c:when test="${ game.getHomeTeam().getName().equals(sessionScope.user.team.getName()) }">
													<strong>${ game.getAwayTeam().getName() }</strong>
												</c:when>
												<c:otherwise>
													@ ${ game.getHomeTeam().getName() }
												</c:otherwise>
											</c:choose>
										</td>
										
										<td style="text-align:right;">
											<c:if test="${ game.getHomeScore() == null && sessionScope.user.getRole() == 2 }">
								  				<a href="http://localhost:8085/LeagueCommissioner/enterscores?gameId=${ game.getGameID() }">Enter Scores</a></td>
								  			</c:if>
								  			<c:if test="${ game.getHomeScore() != null }">
								  				<c:choose>
								  					<c:when test="${ game.getHomeTeam().getName().equals(sessionScope.user.team.getName()) }">
								  						<c:choose>
								  							<c:when test="${ game.getHomeScore() > game.getAwayScore() }">
								  								W
								  							</c:when>
								  							<c:when test="${ game.getHomeScore() < game.getAwayScore() }">
								  								L
								  							</c:when>
								  							<c:otherwise>T</c:otherwise>
								  						</c:choose>
								  						<c:if test="${ game.getIsOvertime() }">
								  							(OT)
								  						</c:if>
								  						${ game.getHomeScore() } - ${ game.getAwayScore() }
								  					</c:when>
								  					<c:otherwise>
								  						<c:choose>
								  							<c:when test="${ game.getHomeScore() < game.getAwayScore() }">
								  								W
								  							</c:when>
								  							<c:when test="${ game.getHomeScore() > game.getAwayScore() }">
								  								L
								  							</c:when>
								  							<c:otherwise>T</c:otherwise>
								  						</c:choose>
								  						<c:if test="${ game.getIsOvertime() }">
								  							(OT)
								  						</c:if>
								  						${ game.getAwayScore() } - ${ game.getHomeScore() }
								  					</c:otherwise>
								  				</c:choose>
								  			</c:if>
										</td>
									</c:otherwise>
								</c:choose>
							</tr>
						</c:forEach>
					
					</table>
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