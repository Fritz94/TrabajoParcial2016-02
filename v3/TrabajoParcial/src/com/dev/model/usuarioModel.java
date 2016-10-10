package com.dev.model;

import java.sql.SQLException;
import java.util.List;

import com.dev.dao.IUsuariodao;
import com.dev.dto.Usuario;
import com.dev.factory.Factory;

public class usuarioModel {

	private IUsuariodao cdao = null;
	
	public usuarioModel()
	{
		cdao = Factory.getInstance().getUsuarioDao();
	}
	
	public void RegistrarUsuario(Usuario u) throws SQLException
	{
		cdao.create(u);
	}
	
	public void EliminarUsuario(int id) throws SQLException
	{
		cdao.delete(id);
	}
	public void ActualizarUsuario(Usuario u) throws SQLException
	{
		cdao.update(u);
	}

	public List<Usuario> ListarUsuarios() throws SQLException {
		// TODO Auto-generated method stub
		return cdao.getAll();
	}
	
}
