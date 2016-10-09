package pe.edu.upc.Controller;

import java.io.IOException;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pe.edu.upc.Entidades.Cliente;
import pe.edu.upc.Model.ClienteModel;

@WebServlet({ "/registrarcliente", "/listarcliente","/login","/cerrars" })
public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private ClienteModel cmodel=null;
    private Cliente cl= new Cliente();
    private String destino ="destino.jsp";
    private String mensaje=null;
    private HttpSession session= null;
    public ClienteServlet() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		cmodel= new ClienteModel();
	
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//session= request.getSession(true);
		String path =request.getServletPath();
		
		
		try {

			switch (path) {
			
				case "/registrarcliente":
					insert(request);
					mensaje = listar(request,cmodel);
					destino="/panel.jsp";
				break;
				case "/listarcliente":
					mensaje=listar(request,cmodel);
					destino="panel.jsp";
				break;
				case "/cerrars":
					session.invalidate();
					destino="index.jsp";
				break;
				case "/login":
					String usuario=request.getParameter("usuario");
					String password=request.getParameter("password");
					
					cl=cmodel.inicioSesion(usuario, password);
					
					if(cl!=null){
						//session.setAttribute("usuario", cl);
					//	session.setAttribute("ID", session.getId());
						
							destino="panel.jsp";						
						
					}else{
						//request.setAttribute("mensaje","credenciales no validas");
						destino="index.jsp";					
					}
					
					break;
			default:
				break;
			}
			
		} catch (Exception e) {
			
		}
		
		RequestDispatcher rd=request.getRequestDispatcher(destino);
		rd.forward(request,response);
	}

	protected String listar(HttpServletRequest request,ClienteModel cmodel)throws ServletException, IOException,SQLException {
		// TODO Auto-generated method stub
		String error=null;
		List<Cliente> lc =cmodel.ListarClientes();
		
		if(lc!=null){
			request.setAttribute("lisclientes", lc);
		}else{
			error="Sin acceso a base de datos";
		}
		return error;
		
		
	}

	private void insert(HttpServletRequest request)throws ServletException, IOException,SQLException {
		// TODO Auto-generated method stub
		Cliente cliente= new Cliente();

		cliente.setNombre(request.getParameter("nombre"));
		cliente.setApellidos(request.getParameter("apellidos"));
		cliente.setEdad(Integer.parseInt(request.getParameter("edad")));
		cliente.setUsuario(request.getParameter("usuario"));
		cliente.setPassword(request.getParameter("password"));
		
		cmodel.RegistrarCliente(cliente);
		
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
