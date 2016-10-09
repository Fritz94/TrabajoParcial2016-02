package pe.edu.upc.DAO;

import java.sql.SQLException;

import pe.edu.upc.Entidades.Empleado;

public interface IEmpleadodao extends ICruddao<Empleado>,IRowmapper<Empleado> {
	 Empleado autentica(String usuario, String password)throws SQLException;
}
