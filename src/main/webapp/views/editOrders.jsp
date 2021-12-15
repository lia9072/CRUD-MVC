



<%@page import="modelado.mOrders"%>
<%@page import="clases.Orders"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
          <div class="col-lg-6">
              <% 
              mOrders dao=new mOrders();
              int Id=Integer.parseInt(request.getParameter("id"));
             Orders p=(Orders)dao.Buscar(Id);
         
          %>
            <h1>Edit Orders</h1>
           <form action="Controlador">
            ID: <br>
                    <input class="form-control" type="text" name="txtid" value="<%= p.getId()%>"><br>
              
             	
            	  Cliete: <br>
                    <input class="form-control" type="text" name="txtcliente" value="<%= p.getCliente()%>"><br>
              
             
                  Status <br>
               		 <input class="form-control" type="text" name="txtestado" value="<%= p.getEstado()%>"><br>
               	 Date <br>
               		 <input class="form-control" type="text" name="txtfecha" value="<%= p.getFecha()%>"><br>
                
                
                <input type="hidden" name="txtid" value="<%= p.getId()%>">
                <input class="btn btn-primary" type="submit" name="accion" value="Actualizar"> 
                <a href="Controlador?accion=listar">Regresar</a>
            </form>
          </div> 
       
          
          
        </div>
    </body>
</html>
