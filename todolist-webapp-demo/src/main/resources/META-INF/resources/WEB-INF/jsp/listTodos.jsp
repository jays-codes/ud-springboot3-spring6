
<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>
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
					<td><a href="updatetodo?id=${todo.id}" class="btn btn-primary">...</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="addtodo" class="btn btn-success">Add a Todo</a>
</div>

<%@include file="common/footer.jspf"%>