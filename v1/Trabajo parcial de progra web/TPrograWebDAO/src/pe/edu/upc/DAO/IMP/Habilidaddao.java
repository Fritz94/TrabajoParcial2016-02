package pe.edu.upc.DAO.IMP;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.upc.ds.Dbconnection;

import pe.edu.upc.DAO.IHabilidaddao;

import pe.edu.upc.Entidades.Habilidad;

public class Habilidaddao implements IHabilidaddao{

	@Override
	public void create(Habilidad o) throws SQLException {
		// TODO Auto-generated method stub
		String insertar ="{call insertar_habilidad(?,?)}";
		Connection cn=Dbconnection.getInstance();
		cn.setAutoCommit(true);
		CallableStatement cs=cn.prepareCall(insertar);
		
		cs.registerOutParameter(1, java.sql.Types.VARCHAR);
		cs.setString(2, o.getNombre());
	
		
		cs.execute();
		String estado = cs.getString(1);
		cs.close();
		cs=null;
		if(!estado.equals("ok")){
			throw new SQLException(estado);
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
		return null;
	}

	@Override
	public List<Habilidad> getAll() throws SQLException {
		// TODO Auto-generated method stub
		List<Habilidad> lhabildiad =new ArrayList<>();
		String query ="{call listar_habilidad()}";
		Connection cn=Dbconnection.getInstance();
		CallableStatement cs= cn.prepareCall(query);
		ResultSet rs= cs.executeQuery();
		while (rs.next()) {
			lhabildiad.add(mapRow(rs));
		}
		return lhabildiad;
	}

	@Override
	public Habilidad mapRow(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		Habilidad h= new Habilidad();
		
		h.setNombre(rs.getString(1));
		return h;
	}

	@Override
	public List<Habilidad> BuscarPorEmpleado(String nombreempleado) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
