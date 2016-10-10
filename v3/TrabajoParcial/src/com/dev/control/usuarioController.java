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



import com.dev.dto.Usuario;
import com.dev.model.usuarioModel;

import com.dev.factory.Factory;
//import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
 * Servlet implementation class usuarioController
 */
@WebServlet({"/panelu", "/insertUsuario", "/listUsuario" })
public class usuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	private usuarioModel umodel = null;
	//---
	private Usuario usua = null;
	//---
	private String mensaje = null;
	private String destino="/panelu.jsp";
	
    public usuarioController() {
        super();
        // TODO Auto-generated constructor stub
    }
 
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	umodel = new usuarioModel();
    	usua = new Usuario();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	String path = request.getServletPath();
    	try
    	{
    		switch (path) {
			case "/newp":
				mensaje = list(request, umodel);
				destino = "insertUsuario.jsp";
				break;//"/insertUsuario", "/ListarUsuario"
			case "/insertUsuario":
				insertUsuario(request);
				mensaje = list(request, umodel);
				destino = "/panelu.jsp";
				break;
			case "/listUsuario":
				mensaje = list(request, umodel);
				destino = "/panelu.jsp";
				System.out.println("Me están llamanod!!");
				if(mensaje != null)
	    		{
	    			request.setAttribute("mensaje", mensaje);
	    			
	    		}else
	    		{
	    			request.removeAttribute("mensaje");
	    		}
				break;
			case "/panelu":
				mensaje = list(request, umodel);
				destino = "/panelu.jsp";
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
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected String list(HttpServletRequest request, usuarioModel umodel) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		//System.out.println("Lista");
		String error = null ; 
		
		List<Usuario> list = umodel.ListarUsuarios();
		
		if(list != null){
			//System.out.println("Lista");
			System.out.println(list);
			request.setAttribute("listUsuarios", list);
		}
		else
		{
			error = "Sin acceso a base de datos";
		}
		return error;
	}

	
	protected void insertUsuario(HttpServletRequest request) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		Usuario u = new Usuario();
		u.setNombrePersona(request.getParameter("nombre"));
		u.setApellidoPersona(request.getParameter("apellido"));
		u.setNumDNI(Integer.parseInt(request.getParameter("DNI")));
		u.setDireccionUsuario(request.getParameter("direccion"));
		u.setCorreoElectronicoUsuario(request.getParameter("mail"));
		u.setNumTelefonico(request.getParameter("telefono"));

		umodel.RegistrarUsuario(u);
		
		
		
	}
	protected void update(HttpServletRequest request) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
	
	}
	protected void delete(HttpServletRequest request) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
