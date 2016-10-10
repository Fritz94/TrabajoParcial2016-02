package com.dev.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.dto.Comentario;
import com.dev.dto.Empleado;
import com.dev.dto.Usuario;
import com.dev.model.comentarioModel;
import com.dev.model.usuarioModel;

/**
 * Servlet implementation class comentarioController
 */
@WebServlet({"/panelc", "/insertComentario", "/listComentario"})
public class comentarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private comentarioModel cmodel= null;
	//---
	private Usuario usua = null;
	private Empleado empleado= null;
	//---
	private String mensaje = null;
	private String destino="/panelc.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public comentarioController() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	cmodel = new comentarioModel();
    	usua = new Usuario();
    	empleado = new Empleado();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	String path = request.getServletPath();
    	try
    	{
    		switch (path) {
			case "/newp":
				mensaje = list(request, cmodel);
				destino = "insertComentario.jsp";
				break;//"/insertUsuario", "/ListarUsuario"
			case "/insertUsuario":
				insertComentario(request);
				mensaje = list(request, cmodel);
				destino = "/panelu.jsp";
				break;
			case "/listUsuario":
				mensaje = list(request, cmodel);
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
			case "/panelu":
				mensaje = list(request, cmodel);
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
    
    protected String list(HttpServletRequest request, comentarioModel cmodel) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		//System.out.println("Lista");
		String error = null ; 
		
		List<Comentario> list = cmodel.ListarComentarios();
		
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
    

	protected void insertComentario(HttpServletRequest request) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		Comentario c = new Comentario();
		c.setContratado(request.getParameter("contratado"));
		c.setDescripcionComentario(request.getParameter("descripcion"));
		//c.setIdEmpleado(Empleado (Integer.parseInt(request.getParameter("empleado"))));
		//c.setIdUsuario(Integer.parseInt(request.getParameter("direccion")));

		cmodel.RegistrarComentario(c);
		
		
		
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
