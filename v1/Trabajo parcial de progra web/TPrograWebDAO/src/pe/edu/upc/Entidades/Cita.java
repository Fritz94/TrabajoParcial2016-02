package pe.edu.upc.Entidades;


public class Cita {
private int codigo;
private String fecha;
private Cliente cliente;
private Empleado empleado;

public Cliente getCliente() {
	return cliente;
}
public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}
public Empleado getEmpleado() {
	return empleado;
}
public void setEmpleado(Empleado empleado) {
	this.empleado = empleado;
}
public int getCodigo() {
	return codigo;
}
public void setCodigo(int codigo) {
	this.codigo = codigo;
}
public String getFecha() {
	return fecha;
}
public void setFecha(String fecha) {
	this.fecha = fecha;
}


}
