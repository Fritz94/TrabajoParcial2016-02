package com.dev.factory;

import com.dev.dao.ICitadao;
import com.dev.dao.IComentariodao;
import com.dev.dao.IEmpleadodao;
import com.dev.dao.IUsuariodao;
import com.dev.dao.impl.Citadao;
import com.dev.dao.impl.Comentariodao;
import com.dev.dao.impl.Empleadodao;
import com.dev.dao.impl.Usuariodao;

public class Factory {
	
	private static Factory fac;
	private Factory()
	{
		
	}
	
	public static Factory getInstance(){
		if (fac==null)
		{
			fac = new Factory();
		}
		return fac;
		
	}
	
	public ICitadao getCitadao()
	{
		return new Citadao();
	}
	
	public IComentariodao getComentarioDao()
	{
		return new Comentariodao();
	}
	
	public IUsuariodao getUsuarioDao()
	{
		return new Usuariodao();
	}
	
	public IEmpleadodao getEmpleadoDao()
	{
		return new Empleadodao();
	}
	
	
	

}
