package pe.edu.upc.DAO.IMP;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.upc.ds.Dbconnection;

import pe.edu.upc.DAO.IComentariodao;
import pe.edu.upc.Entidades.Cita;
import pe.edu.upc.Entidades.Cliente;
import pe.edu.upc.Entidades.Comentario;

public class Comentariodao implements IComentariodao {

	@Override
	public void create(Comentario o) throws SQLException {
		// TODO Auto-generated method stub
		String insert = "{call insertar_comentario(?,?,?,?)}";

		Connection cn = Dbconnection.getInstance();

		cn.setAutoCommit(true);

		CallableStatement cs = cn.prepareCall(insert);

		cs.registerOutParameter(1, java.sql.Types.VARCHAR);
		cs.setString(2, o.getComentario());
		cs.setInt(3, o.getCita().getCodigo());
		cs.setInt(4, o.getCliente().getCodigo());

		cs.execute();

		String estado = cs.getString(1);

		cs.close();
		cs = null;

		if (!estado.equals("ok")) {
			throw new SQLException(estado);
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
		return null;
	}

	@Override
	public List<Comentario> getAll() throws SQLException {
		// TODO Auto-generated method stub
		List<Comentario> lista = new ArrayList<>();
		String query = "{call listar_comentario()}";

		Connection cn = Dbconnection.getInstance();

		CallableStatement cs = cn.prepareCall(query);

		ResultSet rs = cs.executeQuery();
		while (rs.next()) {
			lista.add(mapRow(rs));
		}

		return lista;
	}

	@Override
	public Comentario mapRow(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		Cliente cliente=new Cliente();
		Cita cita=new Cita();
		Comentario comentario = new Comentario();
		
		comentario.setCodigo(rs.getInt(1));
		comentario.setComentario(rs.getString(2));
		
		cliente.setCodigo(rs.getInt(3));
		cliente.setNombre(rs.getString(4));
		cita.setCodigo(rs.getInt(5));
		
		comentario.setCita(cita);
		comentario.setCliente(cliente);
				
		return comentario;
	}

	@Override
	public List<Comentario> BuscarPorCliente(String nombrecliente) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
