package com.dev.dto;

public class Comentario {
	
	private Boolean Contratado;
	private String DescripcionComentario;
	private int idUsuario;
	private int idEmpleado;
	public Boolean getContratado() {
		return Contratado;
	}
	public void setContratado(Boolean contratado) {
		Contratado = contratado;
	}
	public String getDescripcionComentario() {
		return DescripcionComentario;
	}
	public void setDescripcionComentario(String descripcionComentario) {
		DescripcionComentario = descripcionComentario;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	
	
	
	

}
