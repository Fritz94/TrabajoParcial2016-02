package pe.edu.upc.DAO.IMP;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.upc.ds.Dbconnection;

import pe.edu.upc.DAO.IClientedao;
import pe.edu.upc.Entidades.Cliente;

public class Clientedao implements IClientedao{

	@Override
	public void create(Cliente o) throws SQLException {
		// TODO Auto-generated method stub
		String insertar ="{call insertar_cliente(?,?,?,?,?,?)}";
		Connection cn=Dbconnection.getInstance();
		cn.setAutoCommit(true);
		CallableStatement cs=cn.prepareCall(insertar);
		
		cs.registerOutParameter(1, java.sql.Types.VARCHAR);
		cs.setString(2, o.getNombre());
		cs.setString(3, o.getApellidos());
		cs.setInt(4, o.getEdad());
		cs.setString(5, o.getUsuario());
		cs.setString(6, o.getPassword());
		
		cs.execute();
		String estado = cs.getString(1);
		cs.close();
		cs=null;
		if(!estado.equals("ok")){
			throw new SQLException(estado);
		}
		
	}

	@Override
	public void update(Cliente o) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente get(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> getAll() throws SQLException {
		// TODO Auto-generated method stub
		List<Cliente> lcliente =new ArrayList<>();
		String query ="{call listar_cliente()}";
		Connection cn=Dbconnection.getInstance();
		CallableStatement cs= cn.prepareCall(query);
		ResultSet rs= cs.executeQuery();
		while (rs.next()) {
			lcliente.add(mapRow(rs));
		}
		return lcliente;
	}

	@Override
	public Cliente mapRow(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		Cliente cliente = new Cliente();
		
		cliente.setCodigo(rs.getInt(1));
		cliente.setNombre(rs.getString(2));
		cliente.setApellidos(rs.getString(3));
		cliente.setEdad(rs.getInt(4));
		
		return cliente;
	}

	@Override
	public Cliente autentica(String usuario, String password) throws SQLException {
		// TODO Auto-generated method stub
		String query = "{call autenticar_usuario(?,?)}";

		Connection cn = Dbconnection.getInstance();
		

		CallableStatement cs = cn.prepareCall(query);
		cs.setString(1, usuario);
		cs.setString(2, password);

		ResultSet rs = cs.executeQuery();
		if (rs.next()) {
			mapRow(rs);
		}

		return mapRow(rs);
		
	}

}
