package com.dev.dao;

import java.sql.SQLException;
import java.util.List;

import com.dev.dto.Empleado;
import com.dev.dto.Usuario;

public interface IEmpleadodao  extends ICruddao<Empleado>, IRowmapper<Empleado>{

	//Luego lo implementamos ojo: creo que tiene que ir en el comentario 
	List<Empleado> listarEmpleadoStringUsuario (String nombreUsuario) throws SQLException;
	List<Empleado> listarEmpleadoUsuario (Usuario o) throws SQLException;
	List<Empleado> listarEmpleadoValorizacion (int Valorizacion) throws SQLException;
	
		
	
}
