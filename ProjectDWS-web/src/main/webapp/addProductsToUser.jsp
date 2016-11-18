<%-- 
    Document   : addProductsToUser
    Created on : 16-nov-2016, 10:12:21
    Author     : alumno
--%>

<%@page import="entity.User"%>
<%@page import="entity.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" media="screen" />
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="text-center">
                <h1>Factura</h1>
                <br>
            </div>
            <div class="col-md-4 row">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Datos del cliente</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                                ${u.firstLastname} ${u.secondLastname}, ${u.name}<br>
                                ${u.addres}<br>
                                ${u.email}<br>
                                ${u.phone} 
                            </td>
                        </tr>
                    </tbody>
                </table>
                <br>
                <br>
                <br>
            </div>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Producto</th>
                        <th>Descripción</th>
                        <th class="text-center">Cantidad</th>
                        <th class="text-center">Precio</th>
                        <th class="text-center">Total</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        User u = (User) session.getAttribute("u");
                        ArrayList<Product> products = u.getProducts();
                        double total = 0;
                        int cantidad = 1;

                        for (Product product : products) {
                            String name = product.getName();
                            String description = product.getDescription();
                            double price = product.getPrice();
                            total += price;
                    %>
                    <tr>
                        <td class="col-md-3"><em><%=name%></em></td>
                        <td class="col-md-6"><%=description%></td>
                        <td class="col-md-1" style="text-align: center"><%=cantidad%></td>
                        <td class="col-md-1 text-center"><%=price%> €</td>
                        <td class="col-md-1 text-center"><%=price%> €</td>
                    </tr>
                    <% }%>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td class="text-right"><h4><strong>Total: </strong></h4></td>
                        <td class="text-center text-danger"><h4><strong><%=total%> €</strong></h4></td>
                    </tr>
                </tbody>
            </table>
            <a href="listUsers.jsp">Regresar atrás</a>
        </div>
    </body>
</html>
