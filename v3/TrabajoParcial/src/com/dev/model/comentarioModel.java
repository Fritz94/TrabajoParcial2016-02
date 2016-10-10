package com.dev.model;

import java.sql.SQLException;
import java.util.List;

import com.dev.dao.IComentariodao;
import com.dev.dto.Comentario;
import com.dev.factory.Factory;

public class comentarioModel {
	
	private IComentariodao cdao = null;
	
	public comentarioModel()
	{
		cdao = Factory.getInstance().getComentarioDao();
	}
	
	public void RegistrarComentario(Comentario u) throws SQLException
	{
		cdao.create(u);
	}
	
	public void EliminarComentario(int id) throws SQLException
	{
		cdao.delete(id);
	}
	public void ActualizarComentario(Comentario u) throws SQLException
	{
		cdao.update(u);
	}

	public List<Comentario> ListarComentarios() throws SQLException {
		// TODO Auto-generated method stub
		return cdao.getAll();
	}

}
