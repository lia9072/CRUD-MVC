<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
   <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
<title>Add Products</title>
</head>
<body>
<div class="container">
            <div class="col-lg-6">
                <h1>Add Products</h1>
                <form action="ControladorP">
                  	ID: <br>
                    <input class="form-control" type="text" name="txtid"><br>
                    Name: <br>
                    <input class="form-control" type="text" name="txtanem"><br>
                    Category: <br>
                    <input class="form-control" type="text" name="txtcategory"><br>
                    
                    Price: <br>
                    <input class="form-control" type="text" name="txtprice"><br>
                    
                      Status: <br>
                    <input class="form-control" type="text" name="txtstatus"><br>
                    
                    <input class="btn btn-primary" type="submit" name="accion" value="Agregar">
                    
                    <a href="Controlador?accion=listar">Regresar</a>
                </form>
            </div>

        </div>
</body>
</html>