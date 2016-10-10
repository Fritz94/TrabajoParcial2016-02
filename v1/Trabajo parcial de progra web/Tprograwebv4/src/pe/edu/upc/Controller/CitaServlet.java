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

import pe.edu.upc.Entidades.Cita;
import pe.edu.upc.Entidades.Cliente;
import pe.edu.upc.Entidades.Empleado;
import pe.edu.upc.Model.CitaModel;
import pe.edu.upc.Model.EmpleadoModel;

@WebServlet({ "/registrarcita", "/listarcitas" })
public class CitaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private CitaModel cmodel= null;
    private Cita c= new Cita();
    private EmpleadoModel em= null;
    private String destino="destino.jsp";
    private String mensaje=null;
    private HttpSession session=null;
    public CitaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		cmodel=new CitaModel();
		em= new EmpleadoModel();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path =request.getServletPath();
		
		try {
			switch (path) {
			case "/registrarcita":
				insertar(request);
				listarcombo(request,em);
				mensaje=listar(request,cmodel);
				destino="/panelc.jsp";
				break;
			case "/listarcitas":
				mensaje=listar(request,cmodel);
				destino="panelc.jsp";
				break;
			default:
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		RequestDispatcher rd=request.getRequestDispatcher(destino);
		rd.forward(request, response);
	}

	private void listarcombo(HttpServletRequest request, EmpleadoModel em2) throws SQLException{
		// TODO Auto-generated method stub
		String error=null;
		List<Empleado> lc =em.ListarEmpleados();
		
		if(lc!=null){
			request.setAttribute("Empleado", lc);
		}else{
			error="Sin acceso a base de datos";
		}
	
	}

	private String listar(HttpServletRequest request, CitaModel cmodel2) throws SQLException {
		// TODO Auto-generated method stub
		String error=null;
		List<Cita> lc =cmodel.ListarCitas();
		
		if(lc!=null){
			request.setAttribute("liscitas", lc);
		}else{
			error="Sin acceso a base de datos";
		}
		return error;
	}

	private void insertar(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Cita cita= new Cita();
		Cliente c= new Cliente();
		//aqui vamos a obtener los parametros mediante cliks, para asi obtener la fecha
		//	y los codigos del cliente y empleado
		session = request.getSession(true);
		session.getAttribute("codigo");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
