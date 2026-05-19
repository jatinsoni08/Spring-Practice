<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>My Page</title>

		<style>
			body {
				font-family: Arial;
				background-color: #f2f2f2;
				text-align: center;
				padding-top: 100px;
			}

			.box {
				background: white;
				width: 500px;
				margin: auto;
				padding: 30px;
				border-radius: 10px;
				box-shadow: 0px 0px 10px gray;
			}

			h1 {
				color: blue;
			}
		</style>
	</head>
	<body>

		<div class="box">

			<h1>${msg}</h1>

			<h2>Spring Boot MVC + JSP Working Successfully</h2>

		</div>
	</body>
	</html>