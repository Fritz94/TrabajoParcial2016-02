package pe.edu.upc.Model;

import java.sql.SQLException;
import java.util.List;

import pe.edu.upc.DAO.IClientedao;
import pe.edu.upc.DAO.IEmpleadodao;
import pe.edu.upc.Entidades.Cliente;
import pe.edu.upc.Entidades.Empleado;
import pe.edu.upc.Factory.Factory;

public class EmpleadoModel {
private IEmpleadodao edao=null;
	
	public EmpleadoModel(){
	edao=Factory.getInstance().getEmpleadodao();
	
	}
	
	public void RegistrarEmpleado(Empleado em) throws SQLException{
		edao.create(em);
	}
	public List<Empleado> ListarEmpleados () throws SQLException{
		return edao.getAll();
	}
	public Empleado inicioSesion(String usuario,String password) throws SQLException{
		Empleado e=edao.autentica(usuario, password);
		return e;
	}
}
