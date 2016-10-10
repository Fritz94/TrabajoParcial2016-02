package com.dev.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dev.dao.ICitadao;
import com.dev.ds.Dbconnection;
import com.dev.dto.Cita;
import com.dev.dto.Empleado;
import com.dev.dto.Usuario;

public class Citadao implements ICitadao{

	/*

	*/
	
	@Override
	public void create(Cita o) throws SQLException {
		// TODO Auto-generated method stub
		
		String insert = "{call sp_insert_cita(?, ?, ?, ?, ?, ?, ?)}";
		Connection cn = Dbconnection.getInstance();
		cn.setAutoCommit(true);
		
		CallableStatement cs = cn.prepareCall(insert);
		
		cs.registerOutParameter(1, java.sql.Types.VARCHAR);
		cs.setString(2, o.getUbicacionCita());
		cs.setString(3,  o.getHoraInicio());
		cs.setString(4,  o.getHoraFin());
		cs.setString(5,  o.getFechaCita());
		cs.setInt(6, o.getIdUsuario().getIdUsuario());
		cs.setInt(7, o.getIdEmpleado().getIdEmpleado());
		
		
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
	public void update(Cita o) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cita get(int id) throws SQLException {
		// TODO Auto-generated method stub
		
		String query = "{call sp_get_cita(?)}";
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
	public List<Cita> getAll() throws SQLException {
		// TODO Auto-generated method stub
		
		List<Cita> lista = new ArrayList<>();
		String query = "{call sp_list_cita()}";
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
	public Cita mapRow(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		
		Cita cita = new Cita();
		Usuario usuario = new Usuario();
		Empleado empleado = new Empleado(); 

		
		cita.setCodigoCita(rs.getInt(1));
		
		usuario.setIdUsuario(rs.getInt(2));
		empleado.setIdEmpleado(rs.getInt(3));
		cita.setUbicacionCita(rs.getString(4));
		cita.setHoraInicio(rs.getString(5));
		cita.setHoraFin(rs.getString(6));
		cita.setFechaCita(rs.getString(7));
		
		usuario.setNombrePersona(rs.getString(8));
		usuario.setApellidoPersona(rs.getString(9));
		empleado.setNombrePersona(rs.getString(10));
		empleado.setApellidoPersona(rs.getString(11));
		//usuario.setIdUsuario(rs.getInt(12));
		//empleado.setIdEmpleado(rs.getInt(13));
		
		cita.setIdUsuario(usuario);
		cita.setIdEmpleado(empleado);
		
				
		return cita;
	}

	@Override
	public List<Cita> insertarCita(int CodigoCita, String UbicacionCita, String HoraInicio, String HoraFin,
			String FechaCita, int idUsuario, int idEmpleado) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cita> getAllCitasByCliente(Usuario usuario) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cita> getAllCitasByFecha(String fechacita) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
