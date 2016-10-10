package com.dev.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.dto.Cita;
import com.dev.dto.Comentario;
import com.dev.dto.Empleado;
import com.dev.dto.Usuario;
import com.dev.model.citaModel;
import com.dev.model.comentarioModel;

/**
 * Servlet implementation class citaController
 */
@WebServlet({"/citaController", "/listCita", "/insertCita"})
public class citaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	
	private citaModel citamodel= null;
	//---
	private Usuario usua = null;
	private Empleado empleado= null;
	//---
	private String mensaje = null;
	private String destino="/panelcita.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public citaController() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	citamodel = new citaModel();
    	usua = new Usuario();
    	empleado = new Empleado();
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	String path = request.getServletPath();
    	try
    	{
    		switch (path) {
			case "/newp":
				mensaje = list(request, citamodel);
				destino = "insertComentario.jsp";
				break;//"/insertUsuario", "/ListarUsuario"
			case "/insertCita":
				insertCita(request);
				mensaje = list(request, citamodel);
				destino = "/panelcita.jsp";
				break;
			case "/listCita":
				mensaje = list(request, citamodel);
				destino = "/panelcita.jsp";
				//System.out.println("Me están llamanod!!");
				if(mensaje != null)
	    		{
	    			request.setAttribute("mensaje", mensaje);
	    			
	    		}else
	    		{
	    			request.removeAttribute("mensaje");
	    		}
				break;
			case "/panelu":
				mensaje = list(request, citamodel);
				destino = "/panelu.jsp";
				//System.out.println("Me están llamanod!!");
				if(mensaje != null)
	    		{
	    			request.setAttribute("mensaje", mensaje);
	    			
	    		}else
	    		{
	    			request.removeAttribute("mensaje");
	    		}
				break;
			}   		
    		//---
    	}
    	catch (SQLException e)
    	{
    		System.out.println("Error: " + e.getMessage());
    	}
    	
    	RequestDispatcher rd = request.getRequestDispatcher(destino);
    	rd.forward(request, response);
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected String list(HttpServletRequest request, citaModel citamodel) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		//System.out.println("Lista");
		String error = null ; 
		
		List<Cita> list = citamodel.ListarCitas();
		
		if(list != null){
			//System.out.println("Lista");
			System.out.println(list);
			request.setAttribute("listCita", list);
		}
		else
		{
			error = "Sin acceso a base de datos";
		}
		return error;
	}
    
    protected void insertCita(HttpServletRequest request) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		Cita c = new Cita();
		Empleado e = new Empleado();
		Usuario u = new Usuario();
		c.setUbicacionCita(request.getParameter(("ubicacionCita")));
		c.setFechaCita(request.getParameter("fechaCita"));
		c.setHoraFin(request.getParameter("horaFin"));
		c.setHoraInicio(request.getParameter("horaInicio"));
		u.setIdUsuario(Integer.parseInt(request.getParameter("usuario")));
		c.setIdUsuario(u);
		e.setIdEmpleado(Integer.parseInt(request.getParameter("empleado")));
		c.setIdEmpleado(e);
		
		//c.setDescripcionComentario(request.getParameter("descripcion"));
		//c.setIdEmpleado(Empleado (Integer.parseInt(request.getParameter("empleado"))));
		//c.setIdUsuario(Integer.parseInt(request.getParameter("direccion")));

		citamodel.RegistrarCita(c);
	}    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
