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
<body>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Comentario</th>
						<th>Comentariolista</th>
						<th></th>
						<th>edad</th>
					
						
					</tr>
				</thead>
				<tbody>



					<c:forEach var="p" items="${requestScope.listCita}">
						<tr>
							<td>${p.ubicacionCita}</td>
							<td>${p.horaInicio}</td>
							<td>${p.horaFin}</td>
							<td>${p.fechaCita}</td>
							
							
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