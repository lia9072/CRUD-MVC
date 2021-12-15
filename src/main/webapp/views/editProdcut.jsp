<%@page import="clases.Products"%>
<%@page import="modelado.mProducts"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Products</title>
</head>
<body>
       <div class="container">
          <div class="col-lg-6">
              <% 
              mProducts dao=new mProducts();
              int Id=Integer.parseInt(request.getParameter("id"));
             Products p=(Products)dao.Buscar(Id);
         
          %>
            <h1>Edit Products</h1>
           
             <form action="ControladorP">
                  	ID: <br>
                    <input class="form-control" type="text" name="txtid" value="<%= p.getID()%>"><br>
                    Name: <br>
                    <input class="form-control" type="text" name="txtanem" value="<%= p.getNameProduct()%>"><br>
                    Category: <br>
                    <input class="form-control" type="text" name="txtcategory" value="<%= p.getCategory()%>"><br>
                    
                    Price: <br>
                    <input class="form-control" type="text" name="txtprice" value="<%= p.getPrice()%>"><br>
                    
                      Status: <br>
                    <input class="form-control" type="text" name="txtstatus" value="<%= p.getStatusProduct()%>"><br>
                    
                    <input class="btn btn-primary" type="submit" name="accion" value="Agregar">
                    
                    <a href="Controlador?accion=listar">Regresar</a>
                </form>
           
          </div> 
       
          
          
        </div>
</body>
</html>