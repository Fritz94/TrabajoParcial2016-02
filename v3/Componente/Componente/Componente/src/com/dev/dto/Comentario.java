package com.dev.dto;

public class Comentario {
	
	private String Contratado;
	private String DescripcionComentario;
	private Usuario idUsuario;//private Usuario usuario
	private Empleado idEmpleado;//private Empleado empleado 
	
	
	public String getContratado() {
		return Contratado;
	}
	public void setContratado(String contratado) {
		Contratado = contratado;
	}
	public String getDescripcionComentario() {
		return DescripcionComentario;
	}
	public void setDescripcionComentario(String descripcionComentario) {
		DescripcionComentario = descripcionComentario;
	}
	public Usuario getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Empleado getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(Empleado idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	
	
	

}
