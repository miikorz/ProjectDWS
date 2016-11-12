<%-- 
    Document   : addUser
    Created on : 12-nov-2016, 18:24:53
    Author     : fabio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear Usuario</title>
    </head>
    <body>
        <h1>Crear Usuario</h1>
        <form action="AddUser" method="post">
            <b>Usuario</b>
            <input type="text" name="user" value="" style="display: block;" />
            <b>Contraseña</b>
            <input type="password" name="password" value="" style="display: block;" />
            <b>Nombre</b>
            <input type="text" name="name" value="" style="display: block;" />
            <b>Primer Apellido</b>
            <input type="text" name="firstLastname" value="" style="display: block;" />
            <b>Segundo Apellido</b>
            <input type="text" name="secondLastname" value="" style="display: block;" />
            <b>Edad</b>
            <input type="text" name="age" value="" style="display: block;" />
            <b>Dirección</b>
            <input type="text" name="addres" value="" style="display: block;" />
            <b>Correo electrónico</b>
            <input type="text" name="email" value="" style="display: block;" />
            <b>Teléfono</b>
            <input type="text" name="phone" value="" style="display: block;" />
            <input type="submit" name="create" value="Crear">
            <input onclick="location.href='ListUsers'" type="button" name="cancel" value="Cancelar">
        </form>
    </body>
</html>
