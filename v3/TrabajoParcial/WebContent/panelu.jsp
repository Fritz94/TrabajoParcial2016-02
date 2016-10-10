<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<title>UNIVERSIDAD PERUANA DE CIENCIAS APLICADAS</title>
</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">UPCMovies</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="paneladmin.jsp">Home</a></li>
				<li><a href="listUsuario">Usuarios</a></li>
			</ul>
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<h3>Mantenimiento de usuarios</h3>
		</div>
		<div class="row">
			<div class="tabbable">
				<ul class="nav nav-tabs">
					<li class="active"><a href="#" data-toggle="tab">clientes</a></li>
				</ul>
			</div>
		</div>
		<div class="row">
			<p style="text-align: right;">
			<a href="registrarcita.jsp">registrar cita</a>

			</p>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>ID</th>
						<th>NOMBRE</th>
						<th>apellidos</th>
						<th>edad</th>
					
						
					</tr>
				</thead>
				<tbody>



					<c:forEach var="p" items="${requestScope.listUsuarios}">
						<tr>
							<td>${p.nombrePersona}</td>
							<td>${p.apellidoPersona}</td>
							<td>${p.numDNI}</td>
							<td>${p.direccionUsuario}</td>
							
							
					</c:forEach>

				</tbody>
			</table>
		</div>

		<div class="row">
			<c:if test="${!empty requestScope.mensaje}">
				<div>${requestScope.mensaje }</div>
			</c:if>
		</div>
	</div>
	<!-- /container -->
</body>
</html>