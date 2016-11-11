<%-- 
    Document   : listUsers
    Created on : 11-nov-2016, 19:38:24
    Author     : fabio
--%>

<%@page import="entity.User"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado Usuarios</title>
    </head>
    <body>
        <h1>Listado de Usuarios</h1>
        <a href="#">Agregar Usuario</a>
        <br>
        <br>
        <table border="1px" cellspacing="0" cellpadding="10px">
            <tr>
                <th>Usuario</th>
                <th>Nombre</th>
                <th>Primer Apellido</th>
                <th>Segundo Apellido</th>
                <th></th>
                <th></th>
            </tr>
            <%
                ArrayList<User> list = (ArrayList) session.getAttribute("users");
                
                for(User u: list){
                    int id = u.getId();
                    String user = u.getUser();
                    String name = u.getName();
                    String firstLastname = u.getFirstLastname();
                    String secondLastname = u.getSecondLastname();
                %>
            <tr>
                <td><%=user%></td>
                <td><%=name%></td>
                <td><%=firstLastname%></td>
                <td><%=secondLastname%></td>
                <td><a href="UpdateUser?action=edit&id=<%=id%>">Modificar</td>
                <td><a href="#">Eliminar</a></td>
            </tr>
            <% } %>
        </table>
        <br>
        <a href="index.jsp">Regresar al Inicio</a>
    </body>
</html>
