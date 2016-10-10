package com.dev.model;

import java.sql.SQLException;
import java.util.List;

import com.dev.dao.ICitadao;
import com.dev.dto.Cita;
import com.dev.dto.Comentario;
import com.dev.factory.Factory;

public class citaModel {

private ICitadao cdao = null;
	
	public citaModel()
	{
		cdao = Factory.getInstance().getCitadao();
	}
	
	public void RegistrarCita(Cita cita) throws SQLException
	{
		cdao.create(cita);
	}
	
	public void EliminarCita(int id) throws SQLException
	{
		cdao.delete(id);
	}
	public void ActualizarCita(Cita cita) throws SQLException
	{
		cdao.update(cita);
	}

	public List<Cita> ListarCitas() throws SQLException {
		// TODO Auto-generated method stub
		return cdao.getAll();
	}
}
