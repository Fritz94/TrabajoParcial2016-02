package com.dev.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.dev.dao.IUsuariodao;
import com.dev.ds.Dbconnection;
import com.dev.dto.Usuario;

public class Usuariodao implements IUsuariodao{

	@Override
	public void create(Usuario o) throws SQLException {
		String insert = "{call sp_insert_usuario(?, ?, ?, ?, ?, ?, ?)}";
		Connection cn = Dbconnection.getInstance();
		cn.setAutoCommit(true);
		
		CallableStatement cs = cn.prepareCall(insert);
		
		cs.registerOutParameter(1, java.sql.Types.VARCHAR);
		cs.setString(2, o.getNombrePersona());
		cs.setString(3,  o.getApellidoPersona());
		cs.setInt(4, o.getNumDNI());
		cs.setString(5, o.getDireccionUsuario());
		cs.setString(6,  o.getCorreoElectronicoUsuario());
		cs.setString(7, o.getNumTelefonico());
		
		System.out.println(o.getNombrePersona()+o.getApellidoPersona()+o.getNumDNI()+o.getDireccionUsuario()+o.getCorreoElectronicoUsuario()+o.getNumTelefonico());
		
		cs.execute();
		
		String estado = cs.getString(1);
		
		cs.close();
		
		cs = null;
		
		if (!estado.equals("ok"))
		{
			
			//throw new SQLException(estado);
			System.out.println(estado);
		}
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Usuario o) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario get(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario mapRow(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		Usuario usuario = new Usuario();
		usuario.setApellidoPersona(rs.getString(1));
		usuario.setNombrePersona(rs.getString(2));
		return usuario;
		
	}

	@Override
	public Usuario autenticar(String correo, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
