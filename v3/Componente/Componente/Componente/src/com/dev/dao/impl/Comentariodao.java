package com.dev.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dev.dao.IComentariodao;
import com.dev.ds.Dbconnection;
import com.dev.dto.Comentario;
import com.dev.dto.Empleado;
import com.dev.dto.Usuario;

public class Comentariodao implements IComentariodao {

	@Override
	public void create(Comentario o) throws SQLException {
		// TODO Auto-generated method stub
		

		
		String insert = "{call sp_insert_comentario(?, ?, ?, ?, ?)}";
		Connection cn = Dbconnection.getInstance();
		cn.setAutoCommit(true);
		
		CallableStatement cs = cn.prepareCall(insert);
		
		cs.registerOutParameter(1, java.sql.Types.VARCHAR);
		cs.setString(2,o.getContratado());
		cs.setString(3, o.getDescripcionComentario());
		cs.setInt(4, o.getIdUsuario().getIdUsuario());
		cs.setInt(5, o.getIdEmpleado().getIdEmpleado());
		
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
	public void update(Comentario o) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Comentario get(int id) throws SQLException {
		// TODO Auto-generated method stub
		String query = "{call sp_get_comentario(?)}";
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
	public List<Comentario> getAll() throws SQLException {
		// TODO Auto-generated method stub
		
		List<Comentario> lista = new ArrayList<>();
		String query = "{call sp_list_comentario()}";
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
	public Comentario mapRow(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		Empleado empleado=new Empleado();
		Usuario usuario=new Usuario();
		
		Comentario comentario = new Comentario();
		comentario.setContratado(rs.getString(1));
		comentario.setDescripcionComentario(rs.getString(2));
		comentario.setIdUsuario(usuario);
		comentario.setIdEmpleado(empleado);
		
		return comentario;
	}

}
