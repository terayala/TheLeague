<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="com.revature.services.FetchLeagueStandingsService, com.revature.beans.*,
	com.revature.services.StandingsPOJO, java.util.ArrayList" %>

<% try { %>
	<%! FetchLeagueStandingsService service = new FetchLeagueStandingsService(); %>
	
	<%  int leagueId = ((League)session.getAttribute("league")).getLeagueID();
		int ptsOrPct = ((League)session.getAttribute("league")).getPtsOrPct();
		ArrayList<StandingsPOJO> standings = service.currentStandings(leagueId, ptsOrPct); %>
		
	<h3 style="text-align:center;">Standings</h3>

	<table class="sidebar-standings-table">
		<tr>
			<th>${ sessionScope.league.getName() }</th>
			<th<% if (ptsOrPct == 1) { %>
				style="text-align: right;">Pts				
			<% } else { %>
				style="text-align: center;">W</th><th style="text-align: center;">L
			<% } %></th>
		</tr>
		
		<% for (StandingsPOJO i : standings) { %>
			<tr>
				<td><%= i.getTeamName() %></td>
				<td
				
				<% if (ptsOrPct == 1) { %>
					style="text-align: right;"><%= i.getPtsPct() %>
				<% } else { %>
					style="text-align: center;"><%= i.getWins() %></td><td style="text-align: center;"><%= i.getLosses() %>
				<% } %>
				
				</td>
			</tr>
		<% } %>
		
	</table>

<% } catch (Exception e) { %>

	<div class="sidebar-commissioner">
		<h4 style="text-align:center;">Welcome to League Commissioner</h4>
		<p>Please select a league from the left to continue.</p>
	</div>

<% } %>