<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Sticky Notes</title>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"
	type="text/javascript"></script>


<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">

<link rel='stylesheet'
	href='http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css'>

<link rel="stylesheet" href="<c:url value = "/static/css/style.css"/>">


</head>

<body>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Sticky Notes board</title>
<meta name="description" content="Sticky Notes by Edmond Ko">
<meta name="author" content="Edmond Ko">
<link href='https://fonts.googleapis.com/css?family=Gloria+Hallelujah'
	rel='stylesheet' type='text/css'>

</head>
<body>
	<a href="javascript:;" class="button" id="add_new">Add New Note</a>
	<div id="board"></div>

	${msg }
</body>
</html>
<script
	src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script
	src='http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js'></script>



<script src="<c:url value = "/static/js/index.js"/>"></script>




</body>
</html>