
<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>

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
			<form:input path="targetDate" class="form-control"
				required="required" />
			<form:errors path="targetDate" cssClass="text-warning" />
		</Fieldset>

		<form:input type="hidden" path="id" />
		<form:input type="hidden" path="username" />
		<form:input type="hidden" path="done" />
		<input type="submit" class="btn btn-success" value="Save">

	</form:form>
</div>
<%@include file="common/footer.jspf"%>
<script type="text/javascript">
	$('#targetDate').datepicker({
		format : 'yyyy-mm-dd'
	});
</script>
