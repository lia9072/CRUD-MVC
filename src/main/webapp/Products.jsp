<%@page import="modelado.mProducts"%>
<%@page import="clases.Products"%>
<%@page import="java.util.Iterator"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
   <link href="./css/bootstrap.css" rel="stylesheet" type="text/css"/>
<title>Productos</title>
</head>
<body>
<nav class="navbar navbar-inverse">
            <div class="container-fluid">
              <div class="navbar-header">
                <a class="navbar-brand" href="#">BLAZE</a>
              </div>
              <ul class="nav navbar-nav">
                  <li class=""><a href="index.jsp">Orders</a></li>
                  <li class="active"><a href="Products.jsp">Products</a></li>
              </ul>
            </div>
        </nav>
      
        <br>
        <br>
        
      
        
          <div class="container">
            <h1>Products</h1>
            <a class="btn btn-success" href="ControladorP?accion=add">Create Product</a>
            <br>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">N°</th>
                        <th class="text-center">Name</th>
                        <th class="text-center">Category</th>                      
                        <th class="text-center">Price</th>
                         <th class="text-center">status</th>
                          <th class="text-center">Actions</th>
                    </tr>
                </thead>
                <%
                    mProducts dao=new mProducts();
                    List<Products>list=dao.Listar();
                    Iterator<Products>iter=list.iterator();
                    Products per=null;
                    while(iter.hasNext()){
                        per=iter.next();
                    
                %>
                <tbody>
                    <tr>
                         <td class="text-center"><%= per.getID()%></td>
                        <td class="text-center"><%= per.getNameProduct()%></td>
                        <td><%= per.getCategory()%></td>
                        <td><%= per.getPrice()%></td>
                        <td><%= per.getStatusProduct()%></td>
                        <td class="text-center">
                        <from action="ControladorP" method="POST">
                        
                        	<a class="btn btn-warning" href="ControladorP?accion=edit&id=<%= per.getID()%>">Editar</a>
                            <a class="btn btn-danger" href="ControladorP?accion=Suprimir&id=<%= per.getID()%>">Remove</a>
                            
                        </from>
                            
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>

        </div>
                
</body>
</html>