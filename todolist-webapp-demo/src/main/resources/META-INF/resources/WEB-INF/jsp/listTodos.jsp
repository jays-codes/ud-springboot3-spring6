<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link href="webjars/bootstrap/5.3.2/css/bootstrap.min.css"
	rel="stylesheet">
<meta charset="UTF-8">
<title>To Dos</title>
</head>
<body>
	<div class="container">
		<!--  
		<div>Welcome ${name}</div>
		<hr>
		-->
		<h1>Your Todos are</h1>
		<table class="table">
			<thead>
				<tr>
					<th>Description</th>
					<th>Target date</th>
					<th>Done?</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.description}</td>
						<td>${todo.targetDate}</td>
						<td>${todo.done}</td>
						<td><a href="deletetodo?id=${todo.id}" class="btn btn-danger">x</a>
						</td>
						<td><a href="updatetodo?id=${todo.id}" class="btn btn-primary">...</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="addtodo" class="btn btn-success">Add a Todo</a>
	</div>

	<script src="webjars/bootstrap/5.3.2/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.7.1/jquery.min.js"></script>
</body>
</html>