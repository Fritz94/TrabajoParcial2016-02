package com.dev.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.dev.dao.ICitadao;
import com.dev.dto.Cita;
import com.dev.dto.Usuario;

public class Citadao implements ICitadao{

	@Override
	public void create(Cita o) throws SQLException {
		// TODO Auto-generated method stub
		
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
		return null;
	}

	@Override
	public List<Cita> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cita mapRow(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
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
