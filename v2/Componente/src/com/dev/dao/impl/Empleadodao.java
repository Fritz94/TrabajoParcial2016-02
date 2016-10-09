package com.dev.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.dev.dao.IEmpleadodao;
import com.dev.dto.Empleado;
import com.dev.dto.Usuario;

public class Empleadodao implements IEmpleadodao{

	@Override
	public void create(Empleado o) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Empleado o) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Empleado get(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Empleado> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Empleado mapRow(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Empleado> listarEmpleadoStringUsuario(String nombreUsuario) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Empleado> listarEmpleadoUsuario(Usuario o) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Empleado> listarEmpleadoValorizacion(int Valorizacion) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
