<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>To Dos</title>
</head>
<body>
	<div>Welcome ${name}</div>
	<hr>
	<h1>Your Todos are</h1>
	<table>
		<thead>
			<tr>
				<th>id</th>
				<th>description</th>
				<th>target date</th>
				<th>done?</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${todos}" var="todo">
				<tr>
					<td>${todo.id}</td>
					<td>${todo.description}</td>
					<td>${todo.targetDate}</td>
					<td>${todo.done}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>