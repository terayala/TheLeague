<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="jscolor.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<!--Create team  -->
<!-- Add another team button submits form and resets for next -->
<!--  Finish teams button -->

<form:form action="createteam" method="POST" commandName="team">

	Team Name: <form:input path="name"/>
	Nickname: <form:input path="nickname"/>
	Primary Color: <input class="jscolor" value="ab2567">
	<input type="submit" value="Add Team">
</form:form>

<!-- clicking submit button should generate a form for teams to input dates for each set of games -->
<form:form action="enterdates.jsp">
    <input type="submit" value="Enter Dates" />
</form:form>
</body>
</html>