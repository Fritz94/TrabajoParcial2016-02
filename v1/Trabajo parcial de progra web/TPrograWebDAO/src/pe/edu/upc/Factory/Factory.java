package pe.edu.upc.Factory;

import pe.edu.upc.DAO.ICitadao;
import pe.edu.upc.DAO.IClientedao;
import pe.edu.upc.DAO.IComentariodao;
import pe.edu.upc.DAO.IEmpleadodao;
import pe.edu.upc.DAO.IMP.Citadao;
import pe.edu.upc.DAO.IMP.Clientedao;
import pe.edu.upc.DAO.IMP.Comentariodao;
import pe.edu.upc.DAO.IMP.Empleadodao;
import pe.edu.upc.DAO.IMP.Habilidaddao;

public class Factory {
	
	//Implementacion de singleton
		private static Factory fac;
		
		private Factory(){
			
		}
		
		public static Factory getInstance(){
			if (fac == null) 
				fac = new Factory();
			return fac;
		}
		//fin de implementacion singleton
		
		//Se definen los servicios
		public IClientedao getClientedao(){
			return new Clientedao();
		}
		
		public IComentariodao getComentariodao(){
			return new Comentariodao();
		}
		public IEmpleadodao getEmpleadodao(){
			return new Empleadodao();
		}
		public Habilidaddao getHabilidaddao(){
			return new Habilidaddao();
		}
		public ICitadao getCitadao(){
			return new Citadao();
		}
		
			

}
