<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="com.revature.services.FetchLeagueStandingsService, com.revature.beans.*,
	com.revature.services.StandingsPOJO, java.util.ArrayList" %>

<%! FetchLeagueStandingsService service = new FetchLeagueStandingsService(); %>

<%  int leagueId = ((League)session.getAttribute("league")).getLeagueID();
	int ptsOrPct = ((League)session.getAttribute("league")).getPtsOrPct();
	ArrayList<StandingsPOJO> standings = service.currentStandings(leagueId, ptsOrPct); %>
	
<table class="sidebar-standings-table>">
	<tr>
		<th>${ sessionScope.league.getName() }</th>
		<th><% if (ptsOrPct == 1) { %>
			Pts				
		<% } else { %>
			W</th><th>L
		<% } %></th>
	</tr>
	
	<% for (StandingsPOJO i : standings) { %>
		<tr>
			<td><%= i.getTeamName() %></td>
			<td>
			
			<% if (ptsOrPct == 1) { %>
				<%= i.getPtsPct() %>
			<% } else { %>
				<%= i.getWins() %></td><td><%= i.getLosses() %>
			<% } %>
			
			</td>
		</tr>
	<% } %>
	
</table>