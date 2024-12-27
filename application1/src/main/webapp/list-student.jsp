<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib uri="https://jakarta.ee/jsp/jstl/core" prefix="c" %>
	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h1>Total Number of Students</h1>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>phoneNo</th>
				<th>Email</th>
				<th>Password</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<!-- for (Todo todo: todos) { -->
			<c:forEach var="student" items="${listStudent}">
				<tr>
					<td><c:out value="${student.id}" /></td>
					<td><c:out value="${student.firstname}" /></td>
					<td><c:out value="${student.lastname}" /></td>
					<td><c:out value="${student.phoneno}" /></td>
					<td><c:out value="${student.email}" /></td>
					<td><c:out value="${student.password}" /></td>
					<td><a href="edit?id=<c:out value='${student.id}' />">Edit</a>

						<a href="delete?id=<c:out value='${student.id}' />">Delete</a></td>
				</tr>
			</c:forEach>
			<!-- } -->
		</tbody>
	</table>

</body>
</html>