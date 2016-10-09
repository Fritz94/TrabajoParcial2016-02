package pe.edu.upc.DAO;

import java.sql.SQLException;
import java.util.List;

import pe.edu.upc.Entidades.Habilidad;

public interface IHabilidaddao extends ICruddao<Habilidad>,IRowmapper<Habilidad> {
	List<Habilidad> BuscarPorEmpleado (String nombreempleado) throws SQLException;
}
