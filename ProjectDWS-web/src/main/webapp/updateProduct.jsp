<%-- 
    Document   : updateProduct
    Created on : 15-nov-2016, 18:07:24
    Author     : Mike
--%>

<%@page import="entity.User"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Product</title>
    </head>
    <body>

        <h1>Edit Product</h1>

        <form action="UpdateProduct" method="post">
            <%--
            <label for="name">ID:</label>
            --%>
            <input type="hidden" name="id" value="${productToUpdate.productID}" style="display: block;"/>

            <label for="name">NAME:</label>
            <input type="text" name="name" value="${productToUpdate.name}" style="display: block;" />

            <label for="description">DESCRIPTION:</label>
            <input type="text" name="description" value="${productToUpdate.description}" style="display: block;"/>

            <label for="stock">STOCK:</label>
            <input type="text" name="stock" value="${productToUpdate.stock}" style="display: block;"/>

            <label for="price">PRICE:</label>
            <input type="text" name="price" value="${productToUpdate.price}" style="display: block;"/>

            <label for="user">User:</label>
            <select name="user" style="display: block;">
                <%
                    List<User> lista = (List) session.getAttribute("users");
                    for (User u : lista) {
                        int id = u.getId();
                        String user = u.getUser();
                %>
                <option value="<%=id%>"><%=user%></option>
                <% }%>
            </select>
            <br><br>
            <input type="submit" name="guardar" value="SAVE">
        </form>
    </body>
</html>
