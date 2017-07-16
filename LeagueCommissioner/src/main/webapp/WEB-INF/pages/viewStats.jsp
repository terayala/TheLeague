<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>View Stats</title>

<!-- Download Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
	integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js"
	integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"
	integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"
	integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn"
	crossorigin="anonymous"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="icon" type="image/png"
	href="/LeagueCommissioner/static/img/BasketBall.png">
<link rel="stylesheet" type="text/css"
	href="/LeagueCommissioner/static/css/style.css">
</head>
<body>
	<%@ include file="/navbar.jsp"%>
	<div class="navbar-clear"></div>

	<div class="row">
		<div class="col-md-12 col-lg-9 main-screen">
		<div class="standings-container">
			<c:if test="${ sessionScope.user.getRole() == 1 }">
				<c:choose>
					<c:when test="${not empty stats}">
						<h3 class="schedule-header">${ sessionScope.user.getFirstName() }&nbsp;${ sessionScope.user.getLastName() }</h3>
						<br /><h3 class="schedule-header">Individual Game Stats</h3>
						<table class="standings-table">
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
						<h3>${ sessionScope.user.getFirstName() }&nbsp;${ sessionScope.user.getLastName() }
							Has No Stats. Bummer.</h3>
					</c:otherwise>
				</c:choose>
			</c:if>
			<c:choose>
				<c:when test="${not empty aggTable}">
					<br/>
					<h3 class="schedule-header">${ sessionScope.user.getTeam().getName() }</h3>
					<br />
					<h3 class="schedule-header">Total Player Scores</h3>
					<table class="standings-table">
						<thead>
							<th>Player</th>
							<th>Total Score</th>
						</thead>
						<tbody>
							<c:forEach var="player" items="${aggTable}">
								<tr>
									<c:forEach var="playerInfo" items="${player}">
										<td>${ playerInfo }</td>
									</c:forEach>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:when>
				<c:otherwise>
					<h3>${ sessionScope.user.getFirstName() }&nbsp;${ sessionScope.user.getLastName() }
						and His Team Has Not Played a Game Yet. Bummer.</h3>
				</c:otherwise>
			</c:choose>
		</div>
		</div>

		<div class="col-md-3 hidden-md-down sidebar">
			<div class="sidebar-container">
				<%@ include file="/sidebar.jsp"%>
			</div>
		</div>
	</div>
</body>
</html>
