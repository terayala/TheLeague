<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.revature.beans.Team"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>League Commissioner</title>

<link rel="icon" type="image/png"
	href="/LeagueCommissioner/static/img/BasketBall.png">
<link rel="stylesheet" type="text/css"
	href="/LeagueCommissioner/static/css/style.css">

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

</head>

<body>

	<%@ include file="/navbar.jsp"%>
	<div class="navbar-clear"></div>

	<div class="row">
		<div class="col-md-12 col-lg-9 main-screen">
			<!--Create team  -->
			<!-- Add another team button submits form and resets for next -->
			<!--  Finish teams button -->

			<form action="createteam" method="POST">

				Team Name: <input type="text" name="teamName" />
				Nickname: <input type="text" name="nickname" />
			    Primary Color:  <input type="color" name="primaryColor" value="#ffffff">
			    Secondary Color:  <input type="color" name="secondaryColor" value="#ffffff">
				<input type="submit" value="Add Team">
			
			</form>

			<!-- clicking submit button should generate a form for teams to input dates for each set of games -->
			<form:form action="enterdates" method="get">
				<input type="submit" value="Enter Dates" />
			</form:form>

		
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
				Maecenas ultricies euismod eros, id imperdiet est congue non.
				Suspendisse bibendum enim tortor, quis gravida quam malesuada et.
				Aliquam erat volutpat. Mauris tincidunt ornare nunc. Maecenas ut
				suscipit nulla. Quisque vitae interdum lorem. Suspendisse gravida
				eros quis enim semper, ac viverra erat lacinia. Integer ac diam
				facilisis, tincidunt neque ac, aliquet dui. Nam semper, ligula eu
				blandit semper, lacus urna vulputate justo, ut fermentum tortor
				magna id quam. Proin dictum vitae tellus dapibus ullamcorper. Etiam
				vitae nibh eu dui volutpat sagittis. Nulla quis neque sed ex semper
				rhoncus. Aliquam eget libero malesuada, luctus odio sit amet,
				ultricies arcu. Aenean nec molestie justo, ac interdum nibh.</p>
		</div>

		<div class="col-md-3 hidden-md-down sidebar">
			<div class="sidebar-container">
				<p>Here we will include another JSP file that calls a shortened
					version of the league standings with only the team names and either
					points or W-L, depending on the league setup.</p>
			</div>
		</div>
	</div>

</body>

</html>