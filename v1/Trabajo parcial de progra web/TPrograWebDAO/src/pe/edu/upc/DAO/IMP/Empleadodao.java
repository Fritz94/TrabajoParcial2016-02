package pe.edu.upc.DAO.IMP;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.upc.ds.Dbconnection;

import pe.edu.upc.DAO.IEmpleadodao;

import pe.edu.upc.Entidades.Empleado;
import pe.edu.upc.Entidades.Habilidad;

public class Empleadodao implements IEmpleadodao{

	@Override
	public void create(Empleado o) throws SQLException {
		// TODO Auto-generated method stub
		String insertar ="{call insertar_empleado(?,?,?,?,?,?,?)}";
		Connection cn=Dbconnection.getInstance();
		cn.setAutoCommit(true);
		CallableStatement cs=cn.prepareCall(insertar);
		
		cs.registerOutParameter(1, java.sql.Types.VARCHAR);
		cs.setString(2, o.getNombre());
		cs.setString(3, o.getApellidos());
		cs.setInt(4, o.getEdad());
		cs.setInt(5, o.getHabilidad().getCodigo());
		cs.setString(6, o.getUsuario());
		cs.setString(7, o.getPassword());
		
		
		cs.execute();
		String estado = cs.getString(1);
		cs.close();
		cs=null;
		if(!estado.equals("ok")){
			throw new SQLException(estado);
		}
	}

	@Override
	public void update(Empleado o) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Empleado get(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Empleado> getAll() throws SQLException {
		// TODO Auto-generated method stub
		List<Empleado> lempleado =new ArrayList<>();
		String query ="{call listar_empleado()}";
		Connection cn=Dbconnection.getInstance();
		CallableStatement cs= cn.prepareCall(query);
		ResultSet rs= cs.executeQuery();
		while (rs.next()) {
			lempleado.add(mapRow(rs));
		}
		return lempleado;
	}

	@Override
	public Empleado mapRow(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		Empleado e= new Empleado();
		Habilidad h= new Habilidad();
		
		e.setCodigo(rs.getInt(1));
		e.setNombre(rs.getString(2));
		e.setApellidos(rs.getString(3));
		e.setEdad(rs.getInt(4));
		
		h.setNombre(rs.getString(5));
		
		e.setHabilidad(h);
		
		
		return e;
	}

	@Override
	public Empleado autentica(String usuario, String password) throws SQLException {
		// TODO Auto-generated method stub
		String query = "{call autenticar_empleado(?,?)}";

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
