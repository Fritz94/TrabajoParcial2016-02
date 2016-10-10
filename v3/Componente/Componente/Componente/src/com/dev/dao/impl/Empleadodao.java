package com.dev.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dev.dao.IEmpleadodao;
import com.dev.ds.Dbconnection;
import com.dev.dto.Empleado;
import com.dev.dto.Usuario;

public class Empleadodao implements IEmpleadodao{
	
	

	@Override
	public void create(Empleado o) throws SQLException {
		// TODO Auto-generated method stub
		
		String insert = "{call sp_insert_empleado(?, ?, ?, ?, ?,?, ?,?)}";
		Connection cn = Dbconnection.getInstance();
		cn.setAutoCommit(true);
		
		CallableStatement cs = cn.prepareCall(insert);
		
		cs.registerOutParameter(1, java.sql.Types.VARCHAR);
		cs.setString(2, o.getNombrePersona());
		cs.setString(3,  o.getApellidoPersona());
		cs.setInt(4, o.getNumDNI());
		cs.setString(5, o.getDireccionEmpleado());
		cs.setString(6,  o.getCorreoElectronicoEmpleado());
		cs.setString(7, o.getNumTelefonico());
		cs.setInt(8, o.getValorizacionEmpleado());
		
		
		cs.execute();
		
		String estado = cs.getString(1);
		
		cs.close();
		
		cs = null;
		
		if (!estado.equals("ok"))
		{
			throw new SQLException();
		}
		
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
		
		String query = "{call sp_get_empleado(?)}";
		Connection cn = Dbconnection.getInstance();
		cn.setAutoCommit(true);
		
		CallableStatement cs = cn.prepareCall(query);
		
		cs.registerOutParameter(1, java.sql.Types.VARCHAR);
		cs.setInt(1, id );
		
		cs.execute();
		
		ResultSet rs = cs.executeQuery();
		
		if (rs.next())
		{
			mapRow(rs);
		}
		
		return mapRow(rs); 
	}

	@Override
	public List<Empleado> getAll() throws SQLException {
		// TODO Auto-generated method stub
		
		List<Empleado> lista = new ArrayList<>();
		String query = "{call sp_list_empleado()}";
		Connection cn = Dbconnection.getInstance();
		cn.setAutoCommit(true);
		
		CallableStatement cs = cn.prepareCall(query);
		
		ResultSet rs = cs.executeQuery();
		
		while (rs.next())
		{
			lista.add(mapRow(rs));
		}
		
		return lista;
	}

	@Override
	public Empleado mapRow(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		
		Empleado empleado = new Empleado();
		empleado.setNombrePersona(rs.getString(1));
		empleado.setApellidoPersona(rs.getString(2));
		empleado.setNumDNI(rs.getInt(3));
		empleado.setDireccionEmpleado(rs.getString(4));
		empleado.setCorreoElectronicoEmpleado(rs.getString(5));
		empleado.setNumTelefonico(rs.getString(6));
		empleado.setValorizacionEmpleado(rs.getInt(7));
			
		
		return empleado;
	}

	@Override
	public List<Empleado> listarEmpleadoStringUsuario(String nombreUsuario) throws SQLException {
		// TODO Auto-generated method stub
		
		
		
		
		return null;
	}

	@Override
	public List<Empleado> listarEmpleadoValorizacion(int Valorizacion) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Empleado> listarEmpleadoUsuario(Usuario o) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


}
