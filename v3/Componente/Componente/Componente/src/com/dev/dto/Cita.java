package com.dev.dto;

public class Cita {
		
	private int CodigoCita;
	private String UbicacionCita;
	private String HoraInicio;
	private String HoraFin;
	private String FechaCita;
	private Usuario idUsuario;
	private Empleado idEmpleado;
	
	
	public int getCodigoCita() {
		return CodigoCita;
	}
	public void setCodigoCita(int codigoCita) {
		CodigoCita = codigoCita;
	}
	public String getUbicacionCita() {
		return UbicacionCita;
	}
	public void setUbicacionCita(String ubicacionCita) {
		UbicacionCita = ubicacionCita;
	}
	public String getHoraInicio() {
		return HoraInicio;
	}
	public void setHoraInicio(String horaInicio) {
		HoraInicio = horaInicio;
	}
	public String getHoraFin() {
		return HoraFin;
	}
	public void setHoraFin(String horaFin) {
		HoraFin = horaFin;
	}
	public String getFechaCita() {
		return FechaCita;
	}
	public void setFechaCita(String fechaCita) {
		FechaCita = fechaCita;
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
