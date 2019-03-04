<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="u"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Todotolist</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script type="text/javascript"
	src='<c:url value="/static/js/jquery-3.3.1.min.js"></c:url>'"></script>
</head>
<body>
	<div class="container-fluid h-100">
		<div class="col ">
			<div class="row justify-content-center align-content-center h-100">
				<div class="col-6 ">
					<div class="input-group mb-3">
						<u:form modelAttribute="noteUser" method="POST" action="addNote"
							class="form-inline">
							<div class="form-group mb-2">
								<u:input type="text" class="form-control"
									placeholder="Recipient's username"
									aria-label="Recipient's username"
									aria-describedby="basic-addon2" path="note" />
								<p style="color: red;">
									<u:errors path="note"></u:errors>
								</p>
								<div class="input-group-append">
									<button class="btn btn-outline-secondary" type="submit">+</button>
								</div>
							</div>

						</u:form>
					</div>


					<table class="table text-center">
						<thead class="thead-dark">
							<tr>
								<th scope="col">#</th>
								<th scope="col">Nội Dung</th>
								<th scope="col">Chức năng</th>
							</tr>
						</thead>
						<tbody id="body-not-complete">
							<c:forEach items="${lsNotComple}" var="notComple">
								<tr class="todo-item">
									<th scope="row">${notComple.idUser}</th>
									<td>${notComple.note}</td>
									<td><a type="button" class="btn btn-success complete" href='<c:url value="/complete/${notComple.id}"></c:url>'>V</a>
										<a type="button" class="btn btn-danger" href='<c:url value="/delete/${notComple.id}"></c:url>'>X</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<table class="table text-center mt-4">
						<thead class="thead-light">
							<tr>
								<th scope="col">#</th>
								<th scope="col">Nội Dung</th>
								<th scope="col">Chức năng</th>
							</tr>
						</thead>
						<tbody id="body-complete">
							<c:forEach items="${lsComple}" var="comple">
								<tr>
									<th scope="row">${comple.idUser}</th>
									<td>${comple.note}</td>
									<td>
										<a type="button" class="btn btn-danger" href='<c:url value="/notcomplete/${comple.id}"></c:url>'>X</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			$(".complete").click(function(event) {
				$("#body-complete").prepend($("#tmp"));
			});
		});
	</script>
</body>
</html>