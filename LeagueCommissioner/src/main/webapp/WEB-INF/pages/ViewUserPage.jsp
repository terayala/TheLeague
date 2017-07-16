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
			
				<div class="view-user-container">

					<div class="view-user">
						<c:choose>
							<c:when test="${ sessionScope.user.getRole() == 1 }">
								<!-- player form -->
								<h3>View And Update Information</h3>
								<hr>
								<form class="form-horizontal" id="AccountForm" method="post">
								  <div class="form-group">
								    <label class="control-label col-sm-2" for="username">Username:</label>
								    <div class="col-sm-10"> 
								      <input type="text" class="form-control" value="${ sessionScope.user.getUsername() }" name="username" id="username" disabled>
								    </div>
								  </div>
								  <div class="form-group">
								    <label class="control-label col-sm-2" for="pwd">Old Password:</label>
								    <div class="col-sm-10"> 
								      <input type="text" class="form-control" name="oldpwd" id="oldpwd">
								    </div>
								  </div>
								  <div class="form-group">
								    <label class="control-label col-sm-2" for="pwd">New Password:</label>
								    <div class="col-sm-10"> 
								      <input type="text" class="form-control" name="pwd" id="pwd">
								    </div>
								  </div>
								  <div class="form-group">
								    <label class="control-label col-sm-2" for="fname">First name:</label>
								    <div class="col-sm-10"> 
								      <input type="text" class="form-control" value="${ sessionScope.user.getFirstName() }" name="fname" id="fname" required>
								    </div>
								  </div>
								  <div class="form-group">
								    <label class="control-label col-sm-2" for="lname">Last name:</label>
								    <div class="col-sm-10"> 
								      <input type="text" class="form-control" value="${ sessionScope.user.getLastName() }" name="lname" id="lname" required>
								    </div>
								  </div>
								  <div class="form-group">
								    <label class="control-label col-sm-2" for="email">Email:</label>
								    <div class="col-sm-10"> 
								      <input type="email" class="form-control" value="${ sessionScope.user.getEmail() }" name="email" id="email" required>
								  	</div>
								  </div>
								  <div class="form-group">
								    <label class="control-label col-sm-2" for="uniform">Uniform Number:</label>
								    <div class="col-sm-10"> 
								      <input type="text" class="form-control" value="${ sessionScope.user.getUniform() }" name="uniform" id="unifrom" required>
								  	</div>
								  </div>
								  <div class="form-group"> 
								    <div class="col-sm-offset-2 col-sm-10">
								      <button class="btn btn-default" onclick="updateAccount()">Update Account</button>
								    </div>
								  </div>
								</form>
							</c:when>
							<c:otherwise>
								<!-- commissioner/coach form -->
								<h3>View And Update Information</h3>
								<hr>
								<form class="form-horizontal" id="AccountForm" method="post">
								  <div class="form-group">
								    <label class="control-label col-sm-2" for="username">Username:</label>
								    <div class="col-sm-10"> 
								      <input type="text" class="form-control" value="${ sessionScope.user.getUsername() }" name="username" id="username" disabled>
								    </div>
								  </div>
								  <div class="form-group">
								    <label class="control-label col-sm-2" for="pwd">Old Password:</label>
								    <div class="col-sm-10"> 
								      <input type="text" class="form-control" name="oldpwd" id="oldpwd">
								    </div>
								  </div>
								  <div class="form-group">
								    <label class="control-label col-sm-2" for="pwd">New Password:</label>
								    <div class="col-sm-10"> 
								      <input type="text" class="form-control" name="pwd" id="pwd">
								    </div>
								  </div>
								  <div class="form-group">
								    <label class="control-label col-sm-2" for="fname">First name:</label>
								    <div class="col-sm-10"> 
								      <input type="text" class="form-control" value="${ sessionScope.user.getFirstName() }" name="fname" id="fname" required>
								    </div>
								  </div>
								  <div class="form-group">
								    <label class="control-label col-sm-2" for="lname">Last name:</label>
								    <div class="col-sm-10"> 
								      <input type="text" class="form-control" value="${ sessionScope.user.getLastName() }" name="lname" id="lname" required>
								    </div>
								  </div>
								  <div class="form-group">
								    <label class="control-label col-sm-2" for="email">Email:</label>
								    <div class="col-sm-10"> 
								      <input type="email" class="form-control" value="${ sessionScope.user.getEmail() }" name="email" id="email" required>
								  	</div>
								  </div>
								  <div class="form-group"> 
								    <div class="col-sm-offset-2 col-sm-10">
								      <button class="btn btn-default" onclick="updateAccount()">Update Account</button>
								    </div>
								  </div>
								</form>
							</c:otherwise>
						</c:choose>
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