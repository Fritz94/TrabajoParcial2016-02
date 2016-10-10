package com.dev.dao;

import java.sql.SQLException;
import java.util.List;

import com.dev.dto.Cita;
import com.dev.dto.Usuario;

public interface ICitadao extends ICruddao<Cita>, IRowmapper<Cita> {

	//luego
	List<Cita> getAllCitasByCliente (Usuario usuario) throws SQLException;
	List<Cita> getAllCitasByFecha (String fechacita) throws SQLException;
	List<Cita> insertarCita (int CodigoCita, String UbicacionCita, String HoraInicio, String HoraFin, String FechaCita, int idUsuario, int idEmpleado) throws SQLException;
	
}
