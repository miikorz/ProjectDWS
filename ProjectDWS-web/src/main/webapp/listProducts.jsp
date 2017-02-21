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
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" media="screen" />
        
        <title>Product's List</title>
    </head>
    <body>

        <h1>Product's List</h1>

        <a href="addProduct.jsp">Add Product</a>

        <br/>
        <br/>

        <table border="1" class="table table-bordered table-striped table-hover">
            <tr class="thead-inverse">
                <th>ID</th>
                <th>Name</th>
                <th>Description</th>
                <th>Stock</th>
                <th>Price <a href="OrderByPrice"><i class="glyphicon glyphicon-apple" aria-hidden="true"></i></a></th>
                <th></th>
                <th></th>

            </tr>
            <%
                ArrayList<Product> lista = (ArrayList) session.getAttribute("productList");
                for (Product product : lista) {

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
                <td><a class="btn btn-info btn-xs" href="FillUpdateForm?id=<%=id%>">Edit</td>
                <td><a class="btn btn-danger btn-xs" href="DeleteProduct?id=<%=id%>">Delete</a></td>
            </tr>
            <% }%>
        </table>
        <br>
        <a href="index.jsp">Go back</a>
    </body>
</html>
