<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
<title>Add Orders</title>
</head>
<body>

	<div class="container">
            <div class="col-lg-6">
                <h1>Add Order</h1>
                <form action="Controlador">
                  	ID: <br>
                    <input class="form-control" type="text" name="txtid"><br>
                    Consummer: <br>
                    <input class="form-control" type="text" name="txtcliente"><br>
                    Status: <br>
                    <input class="form-control" type="text" name="txtestado"><br>
                    
                    Date: <br>
                    <input class="form-control" type="text" name="txtfecha"><br>
                    
                    <input class="btn btn-primary" type="submit" name="accion" value="Agregar">
                    
                    <a href="Controlador?accion=listar">Regresar</a>
                </form>
            </div>

        </div>

</body>
</html>