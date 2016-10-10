package com.dev.model;

import java.sql.SQLException;
import java.util.List;

import com.dev.dao.IEmpleadodao;
import com.dev.dto.Empleado;
import com.dev.factory.Factory;

public class empleadoModel {
	
private IEmpleadodao cdao = null;
	
	public empleadoModel()
	{
		cdao = Factory.getInstance().getEmpleadoDao();
	}
	
	public void RegistrarEmpleado(Empleado e) throws SQLException
	{
		cdao.create(e);
	}
	
	public void EliminarEmpleado(int id) throws SQLException
	{
		cdao.delete(id);
	}
	public void ActualizarUsuario(Empleado e) throws SQLException
	{
		cdao.update(e);
	}

	public List<Empleado> ListarUEmpleado() throws SQLException {
		// TODO Auto-generated method stub
		return cdao.getAll();
	}

}
