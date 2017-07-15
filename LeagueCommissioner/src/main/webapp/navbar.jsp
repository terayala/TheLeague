<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<div class="header hidden-md-down">
	<div class="header-container">
		<div class="header-title">
			League Commissioner
		</div>
		<ul>
			<li id="standings"><a href="http://localhost:8085/LeagueCommissioner/standings">Standings</a></li>
			<li id="schedule"><a href="http://localhost:8085/LeagueCommissioner/viewschedule">Schedule</a></li>
			<c:choose>
				
				<c:when test="${ sessionScope.user.getRole() == 3}">
					<li><a href="http://localhost:8085/LeagueCommissioner/createleague">Create League</a></li>
				</c:when>
				
				<c:when test="${ sessionScope.user.getRole() == 2}">
					<li><a href="http://localhost:8085/LeagueCommissioner/viewStats">Stats</a></li>
					<li><a href="http://localhost:8085/LeagueCommissioner/createuserpage">Create Player</a></li>
				</c:when>
				
				<c:when test="${ sessionScope.user.getRole() == 1}">
					<li><a href="http://localhost:8085/LeagueCommissioner/viewStats">Stats</a></li>
				</c:when>
			</c:choose>
			<li id="logout"><a href="http://localhost:8085/LeagueCommissioner/logout">Logout</a></li>
		</ul>
	</div>
</div>

<div class="header-small hidden-lg-up">
	<div class="dropdown">
		<button class="btn btn-secondary dropdown-toggle dropdown-name" type="button" id="dropdownMenuButton"
		data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			League Commissioner
		</button>
		<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
			<a class="dropdown-item" href="http://localhost:8085/LeagueCommissioner/standings">Standings</a>
			<a class="dropdown-item" href="http://localhost:8085/LeagueCommissioner/viewschedule">Schedule</a>
			<c:choose>
			
				<c:when test="${ sessionScope.user.getRole() == 3}">
					<a class="dropdown-item" href="http://localhost:8085/LeagueCommissioner/stats">Stats</a>
					<a class="dropdown-item" href="http://localhost:8085/LeagueCommissioner/createleague">Create League</a>
				</c:when>
				
				<c:when test="${ sessionScope.user.getRole() == 2}">
					<a class="dropdown-item" href="http://localhost:8085/LeagueCommissioner/stats">Stats</a>
					<a class="dropdown-item" href="http://localhost:8085/LeagueCommissioner/createuserpage">Create Player</a>
				</c:when>
				
				<c:when test="${ sessionScope.user.getRole() == 1}">
					<a class="dropdown-item" href="http://localhost:8085/LeagueCommissioner/viewStats">Stats</a>
				</c:when>
			</c:choose>
			<a class="dropdown-item" href="http://localhost:8085/LeagueCommissioner/logout">Logout</a>
		</div>
	</div>
</div>