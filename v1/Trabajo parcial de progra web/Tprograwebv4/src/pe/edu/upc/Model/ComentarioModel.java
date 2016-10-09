package pe.edu.upc.Model;

import java.sql.SQLException;
import java.util.List;
import pe.edu.upc.DAO.IComentariodao;

import pe.edu.upc.Entidades.Comentario;
import pe.edu.upc.Factory.Factory;

public class ComentarioModel {
	private IComentariodao idao=null;
	
	public ComentarioModel(){
	idao=Factory.getInstance().getComentariodao();
	
	}
	
	public void RegistrarComentario(Comentario c) throws SQLException{
		idao.create(c);
	}
	public List<Comentario> ListarComentarios () throws SQLException{
		return idao.getAll();
	}
	
}
