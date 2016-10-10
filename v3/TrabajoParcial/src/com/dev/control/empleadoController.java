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

import com.dev.dto.Empleado;
import com.dev.dto.Usuario;
import com.dev.factory.Factory;
import com.dev.model.empleadoModel;
/**
 * Servlet implementation class empleadoController
 */
@WebServlet({ "/panele", "/insertEmpleado", "/listEmpleado" })
public class empleadoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private empleadoModel emodel = null;
	//---
	private Empleado esua = null;
	//---
	private String mensaje = null;
	private String destino="/panele.jsp";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		emodel = new empleadoModel();
		esua = new Empleado();
	}
	
    public empleadoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getServletPath();
    	try
    	{
    		switch (path) {
			case "/newe":
				mensaje = list(request, emodel);
				destino = "inserEmpleado.jsp";
				break;//"/insertUsuario", "/ListarUsuario"
			case "/insertEmpleado":
				mensaje = list(request, emodel);
				destino = "/panelu.jsp";
				break;
			case "/listUsuario":
				mensaje = list(request, emodel);
				destino = "/panele.jsp";
				System.out.println("Me están llamanod!!");
				if(mensaje != null)
	    		{
	    			request.setAttribute("mensaje", mensaje);
	    			
	    		}else
	    		{
	    			request.removeAttribute("mensaje");
	    		}
				break;
			case "/paneeu":
				mensaje = list(request, emodel);
				destino = "/panele.jsp";
				System.out.println("Me están llamanod!!");
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

	private String list(HttpServletRequest request, empleadoModel emodel1) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		String error = null ; 
		
		List<Empleado> list = emodel.ListarUEmpleado();
		
		if(list != null){
			//System.out.println("Lista");
			System.out.println(list);
			request.setAttribute("listEmpleado", list);
		}
		else
		{
			error = "Sin acceso a base de datos";
		}
		return error;
	}

	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,SQLException {
		// TODO Auto-generated method stub
		Empleado e = new Empleado();
		e.setNombrePersona(request.getParameter("nombre"));
		e.setApellidoPersona(request.getParameter("apellido"));
		e.setNumDNI(Integer.parseInt(request.getParameter("DNI")));
		e.setDireccionEmpleado(request.getParameter("direccion"));
		e.setCorreoElectronicoEmpleado(request.getParameter("mail"));
		e.setNumTelefonico(request.getParameter("telefono"));

		
			emodel.RegistrarEmpleado(e);		
		
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
