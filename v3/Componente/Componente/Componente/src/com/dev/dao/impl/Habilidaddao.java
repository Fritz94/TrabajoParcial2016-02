package com.dev.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dev.dao.IHabilidaddao;
import com.dev.ds.Dbconnection;
import com.dev.dto.Habilidad;

public class Habilidaddao implements IHabilidaddao{

	/*
	 
	 */
	@Override
	public void create(Habilidad o) throws SQLException {
		// TODO Auto-generated method stub
		String insert = "{call sp_insert_habilidad(?, ?, ?)}";
		Connection cn = Dbconnection.getInstance();
		cn.setAutoCommit(true);
		
		CallableStatement cs = cn.prepareCall(insert);
		
		cs.registerOutParameter(1, java.sql.Types.VARCHAR);
		cs.setInt(2, o.getCodigoHabilidad());
		cs.setString(3,  o.getNombreHabilidad());
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
	public void update(Habilidad o) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Habilidad get(int id) throws SQLException {
		// TODO Auto-generated method stub
		
		String query = "{call sp_get_habilidad(?)}";
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
	public List<Habilidad> getAll() throws SQLException {
		// TODO Auto-generated method stub
		List<Habilidad> lista = new ArrayList<>();
		String query = "{call sp_list_habilidad()}";
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
	public Habilidad mapRow(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		
		Habilidad habilidad = new Habilidad();
		habilidad.setCodigoHabilidad(rs.getInt(1));
		habilidad.setNombreHabilidad(rs.getString(2));
		
		return habilidad;
	}

}
