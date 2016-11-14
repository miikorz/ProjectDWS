<%-- 
    Document   : ListProducts
    Created on : 14-nov-2016, 9:19:22
    Author     : alumno
--%>

<%@page import="entity.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product's List</title>
    </head>
    <body>
        
	<h1>Listado de Productos</h1>
        
        <a href="addProduct.jsp">Agregar Producto</a>
        
	<br/>
	<br/>

	<table border="1">
		<tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Stock</th>
                    <th>Price</th>
 
		</tr>
                <%
                ArrayList<Product> lista = (ArrayList) session.getAttribute("productList");
                for(Product product : lista){
                    
                    int id = product.getProductID();
                    String name = product.getName();
                    String desc = product.getDescription();
                    int stock = product.getStock();
                    double price = product.getPrice();
                %>                
		<tr>
                    <td><%=id%></a></td>
                    <td><%=name%></td>
                    <td><%=desc%></td>
                    <td><%=stock%></td>
                    <td><%=price%></td>
                </tr>
                <% } %>
	</table>
	<br>
	<a href="index.jsp">Regresar al Inicio</a>
    </body>
</html>
