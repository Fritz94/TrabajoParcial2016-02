package com.dev.dto;

public class Usuario {
private String nombrePersona;
private String apellidoPersona;
private int numDNI;
private String DireccionUsuario;
private String CorreoElectronicoUsuario;
private String numTelefonico;
private int idUsuario;

//Para listar ---------------

private Usuario usuario; 
//-----------------------

public String getNombrePersona() {
	return nombrePersona;
}
public void setNombrePersona(String nombrePersona) {
	this.nombrePersona = nombrePersona;
}
public String getApellidoPersona() {
	return apellidoPersona;
}
public void setApellidoPersona(String apellidoPersona) {
	this.apellidoPersona = apellidoPersona;
}
public int getNumDNI() {
	return numDNI;
}
public void setNumDNI(int numDNI) {
	this.numDNI = numDNI;
}
public String getDireccionUsuario() {
	return DireccionUsuario;
}
public void setDireccionUsuario(String direccionUsuario) {
	DireccionUsuario = direccionUsuario;
}
public String getCorreoElectronicoUsuario() {
	return CorreoElectronicoUsuario;
}
public void setCorreoElectronicoUsuario(String correoElectronicoUsuario) {
	CorreoElectronicoUsuario = correoElectronicoUsuario;
}
public String getNumTelefonico() {
	return numTelefonico;
}
public void setNumTelefonico(String numTelefonico) {
	this.numTelefonico = numTelefonico;
}
public int getIdUsuario() {
	return idUsuario;
}
public void setIdUsuario(int idUsuario) {
	this.idUsuario = idUsuario;
}

//Listar--------------------
public Usuario getUsuario() {
	return usuario;
}
public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
}
//---------------------



}
