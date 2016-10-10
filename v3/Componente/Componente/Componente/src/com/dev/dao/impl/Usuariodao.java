package com.dev.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
		
		String query = "{call sp_get_usuario(?)}";
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
	public List<Usuario> getAll() throws SQLException {
		// TODO Auto-generated method stub
		
		List<Usuario> lista = new ArrayList<>();
		String query = "{call sp_list_usuario()}";
		Connection cn = Dbconnection.getInstance();
		cn.setAutoCommit(true);
		
		CallableStatement cs = cn.prepareCall(query);
		
		ResultSet rs = cs.executeQuery();
		
		while (rs.next())
		{
			System.out.println("Ya llame los usuarios");
			lista.add(mapRow(rs));
		}
		
		return lista; 
	}

	@Override
	public Usuario mapRow(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(rs.getInt(1));
		usuario.setNombrePersona(rs.getString(2));
		usuario.setApellidoPersona(rs.getString(3));
		usuario.setNumDNI(rs.getInt(4));
		usuario.setDireccionUsuario(rs.getString(5));
		usuario.setCorreoElectronicoUsuario(rs.getString(6));
		usuario.setNumTelefonico(rs.getString(7));
		
		return usuario;
		
	}

	@Override
	public Usuario autenticar(String correo, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
