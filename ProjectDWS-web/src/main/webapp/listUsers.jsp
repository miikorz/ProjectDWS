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
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css" media="screen" />
        <title>Listado Usuarios</title>
    </head>
    <body>
        <h1>Listado de Usuarios</h1>
        <br>
        <a href="addUser.jsp">Agregar Usuario</a>
        <br>
        <br>
        <table class="table table-bordered table-striped table-hover">
            <tr class="thead-inverse">
                <th>Usuario</th>
                <th>Nombre</th>
                <th>Primer Apellido</th>
                <th>Segundo Apellido</th>
                <th>Edad</th>
                <th>Dirección</th>
                <th>Correo electrónico</th>
                <th>Teléfono</th>
                <th></th>
            </tr>
            <%
                ArrayList<User> list = (ArrayList) session.getAttribute("users");

                for (int i = 0; list.size() > i; i++) {
                    int id = list.get(i).getId();
                    String user = list.get(i).getUser();
                    String name = list.get(i).getName();
                    String firstLastname = list.get(i).getFirstLastname();
                    String secondLastname = list.get(i).getSecondLastname();
                    int age = list.get(i).getAge();
                    String addres = list.get(i).getAddres();
                    String email = list.get(i).getEmail();
                    int phone = list.get(i).getPhone();
            %>
            <tr>
                <td><a href="UpdateUser?action=edit&id=<%=id%>"><%=user%></td>
                <td><%=name%></td>
                <td><%=firstLastname%></td>
                <td><%=secondLastname%></td>
                <td><%=age%></td>
                <td><%=addres%></td>
                <td><%=email%></td>
                <td><%=phone%></td>
                <td><a href="DeleteUser?id=<%=id%>">Eliminar</a></td>
            </tr>
            <% }%>
        </table>
        <br>
        <a href="index.jsp">Regresar al Inicio</a>
    </body>
</html>
