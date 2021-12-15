package Controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clases.Orders;
import modelado.mOrders;



@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
       String listar="index.jsp";
		String add="views/addOrders.jsp";
		String edit="views/editOrders.jsp";
		Orders p=new Orders();
		mOrders dao=new mOrders();
	 int id;
	
    public Controlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		 String acceso="";
	        String action=request.getParameter("accion");
	                    
	         if(action.equalsIgnoreCase("add")){
	            acceso=add;
	        }
	        /////////////////////////
	        else if(action.equalsIgnoreCase("Agregar")){
	        	int id = Integer.parseInt(request.getParameter("txtid"));
	            String cliente=request.getParameter("txtcliente");
	            String estado=request.getParameter("txtestado");
	            String fecha=request.getParameter("txtfecha");
	           p.setId(id);
	            p.setCliente(cliente);
	            p.setEstado(estado);
	            p.setFecha(fecha);
	            dao.Insertar(p);
	            acceso=add;
	        }
	        else if(action.equalsIgnoreCase("edit")){
	            request.setAttribute("idper",request.getParameter("id"));
	            acceso=edit;
	        }
	        else if(action.equalsIgnoreCase("Actualizar")){
	        	int id = Integer.parseInt(request.getParameter("txtid"));
	        	 String cliente=request.getParameter("txtcliente");
		            String estado=request.getParameter("txtestado");
		            String fecha=request.getParameter("txtfecha");
		           p.setId(id);
		            p.setCliente(cliente);
		            p.setEstado(estado);
		            p.setFecha(fecha);
	            
	            dao.Modificar(p);
	            acceso=listar;
	        }
	        else if(action.equalsIgnoreCase("Suprimir")){
	         
	            
	            
	            int idd= Integer.parseInt(request.getParameter("id"));
                dao.Suprimir(idd);
                request.getRequestDispatcher("Controlador?accion=Listar").forward(request, response);
	        }
	        RequestDispatcher vista=request.getRequestDispatcher(acceso);
	        vista.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
