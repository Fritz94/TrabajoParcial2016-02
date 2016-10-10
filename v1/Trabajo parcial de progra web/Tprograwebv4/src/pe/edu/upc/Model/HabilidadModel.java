package pe.edu.upc.Model;

import java.sql.SQLException;
import java.util.List;

import pe.edu.upc.DAO.IHabilidaddao;

import pe.edu.upc.Entidades.Habilidad;
import pe.edu.upc.Factory.Factory;

public class HabilidadModel {
	private IHabilidaddao hdao=null;
	
	public HabilidadModel(){
	hdao=Factory.getInstance().getHabilidaddao();
	
	}
	
	public void RegistrarHabilidad(Habilidad h) throws SQLException{
		hdao.create(h);
	}
	public List<Habilidad> ListarHabilidades () throws SQLException{
		return hdao.getAll();
	}
	
}
