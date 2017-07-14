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
		
		<%  int id = ((League)session.getAttribute("league")).getLeagueID();
			int pts = ((League)session.getAttribute("league")).getPtsOrPct();
			int ot = ((League)session.getAttribute("league")).getWinOTPts();
			boolean ties = ((League)session.getAttribute("league")).getTiesAllowed();
			ArrayList<StandingsPOJO> s = service.currentStandings(id, pts); %>
		
		<%@ include file="/navbar.jsp" %>
		<div class="navbar-clear"></div>
		
		<div class="row">
			<div class="col-md-12 col-lg-9 main-screen">
			
				<h3 class="page-header" style="text-align:center;">Current League Standings</h3>
				
				<div class="standings-container">
					<table class="standings-table">
						<tr>
							<th class="standings-league-name" style="width:40%;">${ sessionScope.league.getName() }</th>
							<th class="std-col">GP</th>
							<th class="std-col">W</th>
							<% if (ties) { %>
								<th class="std-col">D</th>
							<% } %>
							<th class="std-col">L</th>
							<% if (ot != 0 && pts == 1) { %>
								<th style="std-col">OTW</th><th style="std-col">OTL</th>
							<% } %>
							<th class="std-col">For</th>
							<th class="std-col">Ag</th>
							<th class="std-col">Diff.</th>
							<th class="std-col"><% if (pts == 1) { %>
								Pts.
							<% } else { %>
								Pct.
							<% } %></th>
						</tr>
						
						<% for (StandingsPOJO i : s) { %>
							<tr>
								<td><%= i.getTeamName() %></td>
								<td class="std-col"><%= i.getPlayed() %></td>
								<td class="std-col"><%= i.getWins() %></td>
								<% if (ties) { %>
									<td class="std-col"><%= i.getDraws() %></td>
								<% } %>
								<td class="std-col"><%= i.getLosses() %></td>
								<% if (ot != 0 && pts == 1) { %>
									<td style="std-col"><%= i.getOtWins() %></td>
									<td style="std-col"><%= i.getOtLosses() %></td>
								<% } %>
								<td class="std-col"><%= i.getGoalsFor() %></td>
								<td class="std-col"><%= i.getGoalsAllowed() %></td>
								<td class="std-col"><%= i.getGoalDiff() %></td>
								<td class="std-col"><% if (pts == 1) { %>
									<%= i.getPtsPct() %>
								<% } else { %>
									.
								<% } %></td>
							</tr>
						<% } %>
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
