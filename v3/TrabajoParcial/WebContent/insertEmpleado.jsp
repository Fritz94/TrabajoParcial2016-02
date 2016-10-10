<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="insertEmpleado" method="post">

//idEmpleado, nombreEmpleado, apellidoEmpleado, numDNI, direccionEmpleado, 
emailEmpleado, telefonoEmpleado

Nombre: <input type="text" name ="nombre"/></br>
Apellido: <input type="text" name ="apellido"/></br>
Numero DNI: <input type="text" name ="DNI"/></br>
DireccionUsuario: <input type="text" name ="direccion"/></br>
CorreoElectronicaUsuario: <input type="text" name ="mail"/></br>
numTelefonico: <input type="text" name ="telefono"/></br>
		<input type="submit" name ="Registrar"/></br>
		
</form>


</body>
</html>