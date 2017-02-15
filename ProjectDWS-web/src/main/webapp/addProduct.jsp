<%-- 
    Document   : addProduct
    Created on : 14-nov-2016, 10:06:54
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Product</title>
    </head>
    <body>

	<h1>Add Product</h1>
	
	<form action="AddProduct" method="post">
		<input type="hidden" name="accion" value="agregar"/>
                
                <label for="nombre">ID:</label>
		<input type="text" name="id" style="display: block;" />
	
		<label for="nombre">Name:</label>
		<input type="text" name="name" style="display: block;" />
		
		<label for="email">Description:</label>
		<input type="text" name="desc" style="display: block;"/>
		
		<label for="telefono">Stock:</label>
		<input type="text" name="stock" style="display: block;"/>
                
                <label for="telefono">Price:</label>
		<input type="text" name="price" style="display: block;"/>
		
		<input type="submit" value="Enviar" />
	</form>

	<a href="index.jsp">Regresar al Inicio</a>
    </body>
</html>
