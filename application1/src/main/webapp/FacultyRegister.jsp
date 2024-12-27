<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FacultyRegistered</title>
<style>
h2 {
	color: Green;
}
</style>
</head>
<body>
	<h2>Registration completed successfully</h2>
	<!-- Display the registered student ID -->
    <p>Your registered Faculty ID is : <b><%= request.getAttribute("registeredId") %></b></p>
    <p style="color:orange"> Reminder!! ID is Mandatory For Any Changes Do You Want to made In Registration</p>
</body>
</html>