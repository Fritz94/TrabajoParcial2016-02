package pe.edu.upc.DAO;

import java.sql.SQLException;

import pe.edu.upc.Entidades.Cliente;

public interface IClientedao extends ICruddao<Cliente>,IRowmapper<Cliente> {
	 Cliente autentica(String usuario, String password)throws SQLException;
}
