<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Player's Game Stats</title>
</head>
<body>

	<h3>${ sessionScope.user.getFirstName() }&nbsp;${ sessionScope.user.getLastName() }'s Game Stats</h3>

	<c:if test="${not empty stats}">
	    <table>
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
		                <td>${s.getGame().getHomeTeam()}</td>
		                <td>${s.getGame().getAwayTeam()}</td>
		                <td>${s.getPointsScored()}</td> 
		            </tr>
		        </c:forEach>
			</tbody>
	    </table>
	</c:if>
</body>
</html>