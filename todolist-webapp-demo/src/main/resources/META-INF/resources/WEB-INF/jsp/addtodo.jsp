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
<title>Add/Update Todo</title>
</head>
<body>
	<div class="container form-check">
		<h1>Todo Details</h1>
		<form:form method="post" modelAttribute="todo">
			<Fieldset class="mb-3">
				<form:label path="description">Description</form:label>
				<form:input type="text" path="description" class="form-control"
					required="required" />
				<form:errors path="description" cssClass="text-warning" />
			</Fieldset>

			<Fieldset class="mb-3">
				<form:label path="targetDate">Target Date</form:label>
				<form:input type="text" path="targetDate" class="form-control"
					required="required" />
				<form:errors path="targetDate" cssClass="text-warning" />
			</Fieldset>

			<form:input type="hidden" path="id" class="form-control" />
			<form:input type="hidden" path="done" class="form-control" />
			<input type="submit" class="btn btn-success" value="Save">

		</form:form>
	</div>
	<script src="webjars/bootstrap/5.3.2/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.7.1/jquery.min.js"></script>

</body>
</html>