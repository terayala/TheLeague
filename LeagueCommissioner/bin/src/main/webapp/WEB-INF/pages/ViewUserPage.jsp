<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="viewUser">
	<c:choose>
		<c:when test="${ user.getRole() == 1 }">
			<!-- player form -->
			<h1>View And Update Information</h1>
			<hr>
			<form class="form-horizontal" id="AccountForm" method="post">
			  <div class="form-group">
			    <label class="control-label col-sm-2" for="username">Username:</label>
			    <div class="col-sm-10"> 
			      <input type="text" class="form-control" value="${ user.getUsername() }" name="username" id="username" disabled>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-2" for="pwd">Old Password:</label>
			    <div class="col-sm-10"> 
			      <input type="text" class="form-control" name="oldpwd" id="oldpwd" required>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-2" for="pwd">New Password:</label>
			    <div class="col-sm-10"> 
			      <input type="text" class="form-control" name="pwd" id="pwd" required>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-2" for="fname">First name:</label>
			    <div class="col-sm-10"> 
			      <input type="text" class="form-control" value="${ user.getFirstName() }" name="fname" id="fname" required>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-2" for="lname">Last name:</label>
			    <div class="col-sm-10"> 
			      <input type="text" class="form-control" value="${ user.getLastName() }" name="lname" id="lname" required>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-2" for="email">Email:</label>
			    <div class="col-sm-10"> 
			      <input type="email" class="form-control" value="${ user.getEmail() }" name="email" id="email" required>
			  	</div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-2" for="uniform">Uniform Number:</label>
			    <div class="col-sm-10"> 
			      <input type="text" class="form-control" value="${ user.getUniform() }" name="uniform" id="unifrom" required>
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
			      <input type="text" class="form-control" value="${ user.getUsername() }" name="username" id="username" disabled>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-2" for="pwd">Old Password:</label>
			    <div class="col-sm-10"> 
			      <input type="text" class="form-control" name="oldpwd" id="oldpwd" required>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-2" for="pwd">New Password:</label>
			    <div class="col-sm-10"> 
			      <input type="text" class="form-control" name="pwd" id="pwd" required>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-2" for="fname">First name:</label>
			    <div class="col-sm-10"> 
			      <input type="text" class="form-control" value="${ user.getFirstName() }" name="fname" id="fname" required>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-2" for="lname">Last name:</label>
			    <div class="col-sm-10"> 
			      <input type="text" class="form-control" value="${ user.getLastName() }" name="lname" id="lname" required>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-2" for="email">Email:</label>
			    <div class="col-sm-10"> 
			      <input type="email" class="form-control" value="${ user.getEmail() }" name="email" id="email" required>
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
