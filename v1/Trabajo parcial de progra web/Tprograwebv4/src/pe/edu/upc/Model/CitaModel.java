package pe.edu.upc.Model;

import java.sql.SQLException;
import java.util.List;

import pe.edu.upc.DAO.ICitadao;
import pe.edu.upc.Entidades.Cita;
import pe.edu.upc.Factory.Factory;

public class CitaModel {
private ICitadao cdao= null;
public CitaModel(){
	cdao=Factory.getInstance().getCitadao();
}

public void RegistrarCita(Cita c) throws SQLException{
	cdao.create(c);
}
public List<Cita> ListarCitas() throws SQLException{
	return cdao.getAll();
}


}
