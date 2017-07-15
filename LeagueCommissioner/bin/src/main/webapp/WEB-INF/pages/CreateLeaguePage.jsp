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
		
		<%@ include file="/navbar.jsp" %>
		<div class="navbar-clear"></div>
		
		<div class="row">
			<div class="col-md-12 col-lg-9 main-screen">
			
				<div class="create-league-container">
			
					<h1>Create New League</h1>
					<hr>
					<form class="form-horizontal" action="createleague" method="post">
					
						<!-- This is where the user will enter the league name -->
						<div class="form-group row">
							<label class="control-label col-sm-2" for="name">League Name:</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="Name" id="name">
							</div>
						</div>
					  
						<div class="row">
							<div class="form-group col-md-6">
								<div class="row">
									<label class="control-label col-sm-4" for="sports">Select Sport:</label>
									<div class="col-sm-8"> 
										<select name="Sport">
										<c:forEach items="${ requestScope.sports }" var="sport">
											<option value="${ sport.getSport_id() }">${ sport.getName() } </option>
										</c:forEach>
										</select>
									</div>
								</div>
								<div class="row">
									<div class="checkbox">
					        			<label>
					        				<input type="checkbox" name="tiesAllowed"
					        				style="margin-left:15px;">Are Draws/Ties Allowed?
					        				Check if yes
					        			</label>
					      			</div>
								</div>
							</div>
							<div class="form-group col-md-6">
								<div class="row">
									<label class="control-label col-sm-6">
										Will the standings be sorted by points or by win percentage?
									</label>
									<div class="col-sm-6">
								  		<input type="radio" name="ptsOrPct" value="1">Points<br>
										<input type="radio" name="ptsOrPct" value="2">Percentage
								    </div>
							    </div>
						    </div>
						</div>
						
						<h5>The following is used only if the standings are sorted by points</h5>
						<h5><em>NOTE: If your league does not have overtime, enter "0" for number of
						points per overtime win or loss.</em></h5>					
						<div class="row">
							<div class="col-sm-3">
								<div class="form-group">
									<label class="control-label" for="winPts">Points Per Win:</label>
									<input type="number" class="form-control" name="winPts" id="winPts">
								</div>
							</div>
							<div class="col-sm-3">
								<div class="form-group">
									<label class="control-label" for="tiePts">Points Per Tie/Draw:</label>
									<input type="number" class="form-control" name="tiePts" id="tiePts">
								</div>
							</div>
							<div class="col-sm-3">
								<div class="form-group">
									<label class="control-label" for="winOTPts">Points Per OT Win</label>
									<input type="number" class="form-control" name="winOTPts" id="winOTPts">
								</div>
							</div>
							<div class="col-sm-3">
								<div class="form-group">
									<label class="control-label" for="lossOTPts">Points Per OT Loss</label>
									<input type="number" class="form-control" name="lossOTPts" id="lossOTPts">
								</div>
							</div>
						</div>
					  
						<div class="create-league-submit">
							<button type="submit" class="btn btn-default" value="POST">Create League</button>
						</div>
						
					</form>
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