package pe.edu.upc.DAO.IMP;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.upc.ds.Dbconnection;

import pe.edu.upc.DAO.ICitadao;
import pe.edu.upc.Entidades.Cita;
import pe.edu.upc.Entidades.Cliente;
import pe.edu.upc.Entidades.Empleado;

public class Citadao implements ICitadao{

	@Override
	public void create(Cita o) throws SQLException {
		// TODO Auto-generated method stub
		String insertar ="{call insertar_cita(?,?,?,?)}";
		Connection cn=Dbconnection.getInstance();
		cn.setAutoCommit(true);
		CallableStatement cs=cn.prepareCall(insertar);
		
		cs.registerOutParameter(1, java.sql.Types.VARCHAR);
		cs.setString(2, o.getFecha());
		cs.setInt(3, o.getCliente().getCodigo());
		cs.setInt(4, o.getEmpleado().getCodigo());
		
		cs.execute();
		String estado = cs.getString(1);
		cs.close();
		cs=null;
		if(!estado.equals("ok")){
			throw new SQLException(estado);
		}
	}

	@Override
	public void update(Cita o) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cita get(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cita> getAll() throws SQLException {
		// TODO Auto-generated method stub
		List<Cita> lcita =new ArrayList<>();
		String query ="{call listar_citas()}";
		Connection cn=Dbconnection.getInstance();
		CallableStatement cs= cn.prepareCall(query);
		ResultSet rs= cs.executeQuery();
		while (rs.next()) {
			lcita.add(mapRow(rs));
		}
		return lcita;
	}

	@Override
	public Cita mapRow(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		Cliente cl= new Cliente();
		Empleado e= new Empleado();
		Cita c= new Cita();
		
		c.setCodigo(rs.getInt(1));
		c.setFecha(rs.getString(2));
		
		cl.setNombre(rs.getString(3));
		
		e.setNombre(rs.getString(4));
		
		c.setCliente(cl);
		c.setEmpleado(e);
		
		
		return c;
	}

	@Override
	public List<Cita> getAllCitasByCliente(Cliente cliente) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cita> getAllCitasByFecha(Date fechacita) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
