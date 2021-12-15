package Controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clases.Products;
import modelado.mProducts;

/**
 * Servlet implementation class ControladorP
 */
@WebServlet("/ControladorP")
public class ControladorP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	    String listar="Products.jsp";
		String add="views/addProduct.jsp";
		String edit="views/editProdcut.jsp";
		Products p=new Products();
		mProducts dao=new mProducts();
	
    public ControladorP() {
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
	            String cliente=request.getParameter("txtanem");
	            String category=request.getParameter("txtcategory");
	            double price=Double.parseDouble(request.getParameter("txtprice"));
	            String Status=request.getParameter("txtstatus");
	           p.setID(id);
	            p.setNameProduct(cliente);
	            p.setCategory(category);
	            p.setPrice(price);
	            p.setStatusProduct(Status);
	            dao.Insertar(p);
	            acceso=add;
	        }
	        else if(action.equalsIgnoreCase("edit")){
	            request.setAttribute("idper",request.getParameter("id"));
	            acceso=edit;
	        }
	        else if(action.equalsIgnoreCase("Actualizar")){
	        	int id = Integer.parseInt(request.getParameter("txtid"));
	            String cliente=request.getParameter("txtanem");
	            String category=request.getParameter("txtcategory");
	            double price=Double.parseDouble(request.getParameter("txtprice"));
	            String Status=request.getParameter("txtstatus");
	           p.setID(id);
	            p.setNameProduct(cliente);
	            p.setCategory(category);
	            p.setPrice(price);
	            p.setStatusProduct(Status);
	            dao.Insertar(p);
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
