package com.dev.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.dto.Usuario;
import com.dev.model.usuarioModel;

/**
 * Servlet implementation class usuarioController
 */
@WebServlet({ "/insertUsuario", "/ListarUsuario" })
public class usuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	private usuarioModel umodel = null;
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
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	String path = request.getServletPath();
    	try
    	{
    		if (path.equals("/newUsuario"))
    		{
    			destino="createu.jsp";
    		}
    		else if (path.equals("/insertUsuario"))
    		{
    			//System.out.println("Hola");
    			insert(request);
    			//mensaje = list(request,umodel);
    			//destino="/panelc.jsp";
    			//mensaje = list(request,umodel);
    			//destino = "/panelu.jsp";
    		}
    		else if (path.equals("/inser3tUsuario"))
    		{
    			insert(request);
    			//mensaje = list(request,umodel);
    			//destino = "/panelu.jsp";
    		}
    	}
    	catch (SQLException e)
    	{
    		
    	}
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
		
		String error = null;
		return error;
	}

	
	protected void insert(HttpServletRequest request) throws ServletException, IOException, SQLException {
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
