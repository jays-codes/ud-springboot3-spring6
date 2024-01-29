<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="webjars/bootstrap/5.3.2/css/bootstrap.min.css"
	rel="stylesheet">
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<div class="container">
		<h1>Login</h1>
		<pre>${error}</pre>

		<form method="post">
			Name: <input type="text" name="name">
			<p>
				Password: <input type="password" name="pwd"> <input
					type="submit">
		</form>
	</div>
	<script src="webjars/bootstrap/5.3.2/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.7.1/jquery.min.js"></script>

</body>
</html>