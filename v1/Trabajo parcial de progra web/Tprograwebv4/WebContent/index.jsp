<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="registrarcliente" method="POST">
<div align="center">
	<table>
	<tr>
	<td>Nombre: </td>
	<td><input type="text" name="nombre"/></td>
	</tr>
	<tr>
	<td>Apellidos: </td>
	<td><input type="text" name="apellidos"/></td>
	</tr>
	<tr>
	<td>Edad: </td>
	<td><input type="number" name="edad" min="18"/></td>
	</tr>
	<tr>
	<td>Usuario: </td>
	<td><input type="text" name="usuario"/></td>
	</tr>
	<tr>
	<td>Contraseña: </td>
	<td><input type="password" name="password"/></td>
	</tr>
	<tr>
	<td><input type="submit" value="Registrarse" name="registrar"/></td>
	</tr>
	
	</table>
	<a href="listarcliente">listar clientes</a>
	<a href="login.jsp">login</a>
	</div>
</form>
</body>
</html>