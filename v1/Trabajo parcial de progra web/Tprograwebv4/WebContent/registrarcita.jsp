<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="registrarcita" method="POST">
		<table>
			<tr>
				<td>fecha: </td>
				<td><input type="date" name="fecha"/></td>
			</tr>
			<tr>
				<td>empleado</td>
				<td><select name="empleadocombo">
				<option value="seleccione">Seleccione...</option>
				<c:forEach var="empleado" items="${requestScope.Empleado}">
				
           		 <option value="${empleado.codigo }">${empleado.nombre}</option>
        		  </c:forEach>
				
				</select></td>
			
			</tr>
		
		</table>
	</form>
</body>
</html>