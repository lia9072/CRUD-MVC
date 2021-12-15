<%@page import="modelado.mOrders"%>
<%@page import="java.util.Iterator"%>
<%@page import="clases.Orders"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
              <div class="navbar-header">
                <a class="navbar-brand" href="#">BLAZE</a>
              </div>
              <ul class="nav navbar-nav">
                  <li class="active"><a href="index.jsp">Orders</a></li>
                  <li class=""><a href="Products.jsp">Products</a></li>
              </ul>
            </div>
        </nav>
      
        <br>
        <br>
        
      
        
          <div class="container">
            <h1>Orders</h1>
            <a class="btn btn-success" href="Controlador?accion=add">Create Order</a>
            <br>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">N°</th>
                        <th class="text-center">CONSUMMER</th>
                        <th class="text-center">STATUS</th>
                        <th class="text-center">DATE</th>
                        <th class="text-center">ACCIONES</th>
                    </tr>
                </thead>
                <%
                    mOrders dao=new mOrders();
                    List<Orders>list=dao.Listar();
                    Iterator<Orders>iter=list.iterator();
                    Orders per=null;
                    while(iter.hasNext()){
                        per=iter.next();
                    
                %>
                <tbody>
                    <tr>
                         <td class="text-center"><%= per.getId()%></td>
                        <td class="text-center"><%= per.getCliente()%></td>
                        <td><%= per.getEstado()%></td>
                        <td><%= per.getFecha()%></td>
                        <td class="text-center">
                        <from action="Controlador" method="POST">
                        
                        	<a class="btn btn-warning" href="Controlador?accion=edit&id=<%= per.getId()%>">Editar</a>
                            <a class="btn btn-danger" href="Controlador?accion=Suprimir&id=<%= per.getId()%>">Remove</a>
                            
                        </from>
                            
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>

        </div>
                
                
                
                
    </body>
</html>