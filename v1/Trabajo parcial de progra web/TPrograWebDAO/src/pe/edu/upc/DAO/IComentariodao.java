package pe.edu.upc.DAO;

import java.sql.SQLException;
import java.util.List;

import pe.edu.upc.Entidades.Comentario;

public interface IComentariodao extends ICruddao<Comentario>,IRowmapper<Comentario> {
	List<Comentario> BuscarPorCliente (String nombrecliente) throws SQLException;
}
