<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>League Commissioner</title>
</head>
<body>
	<!-- <div include="nav-bar"></div> -->
	<div class="viewUser">
		<c:choose>
			<c:when test="${ sessionScope.user.getRole() == 1 }">
				<!-- player form -->
				<h1>View And Update Information</h1>
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
				<h1>View And Update Information</h1>
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
</body>
</html>