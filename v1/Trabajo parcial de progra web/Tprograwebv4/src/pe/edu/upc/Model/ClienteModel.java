package pe.edu.upc.Model;

import java.sql.SQLException;
import java.util.List;

import pe.edu.upc.DAO.IClientedao;
import pe.edu.upc.Entidades.Cliente;
import pe.edu.upc.Factory.Factory;

public class ClienteModel {
	private IClientedao cdao=null;
	
	public ClienteModel(){
	cdao=Factory.getInstance().getClientedao();
	
	}
	
	public void RegistrarCliente(Cliente cli) throws SQLException{
		cdao.create(cli);
	}
	public List<Cliente> ListarClientes () throws SQLException{
		return cdao.getAll();
	}
	public Cliente inicioSesion(String correo,String password) throws SQLException{
		Cliente c=cdao.autentica(correo, password);
		return c;
	}
}
