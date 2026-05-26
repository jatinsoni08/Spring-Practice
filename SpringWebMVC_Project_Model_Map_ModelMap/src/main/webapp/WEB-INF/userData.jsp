<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib uri="jakarta.tags.core" prefix="c" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>User Data</title>
		</head>

		<body>
			<h1>Single User Data</h1>
			<h3>ID : ${obj.id}</h3>
			<h3>Name : ${obj.userName}</h3>
			<h3>Role : ${obj.userRole}</h3>
			<hr>
			<h1>Multiple Users</h1>
			<table border="1" cellpadding="10">
				<tr>
					<th>ID</th>

					<th>Name</th>

					<th>Role</th>
				</tr>

				<c:forEach items="${userData}" var="ob">
					<tr>
						<td>${ob.id}</td>

						<td>${ob.userName}</td>

						<td>${ob.userRole}</td>
					</tr>
				</c:forEach>
			</table>
		</body>

		</html>