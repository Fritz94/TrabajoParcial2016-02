package pe.edu.upc.DAO;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import pe.edu.upc.Entidades.Cita;
import pe.edu.upc.Entidades.Cliente;

public interface ICitadao extends ICruddao<Cita>,IRowmapper<Cita> {
List<Cita> getAllCitasByCliente (Cliente cliente) throws SQLException;
List<Cita> getAllCitasByFecha (Date fechacita) throws SQLException;
}
