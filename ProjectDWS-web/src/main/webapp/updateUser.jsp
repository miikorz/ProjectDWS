<%-- 
    Document   : updateUser
    Created on : 11-nov-2016, 20:08:58
    Author     : fabio
--%>

<%-- 
<%@page contentType="text/html" pageEncoding="UTF-8"%> WTF?¿?¿?¿ Preguntar en clase (acentos)
--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Usuario</title>
    </head>
    <body>
        <h1>Modificar Usuario</h1>
        <form action="UpdateUser?action=update&id=${u.id}" method="post">
            <b>Usuario</b>
            <input type="text" name="user" value="${u.user}" style="display: block;" />
            <b>Nombre</b>
            <input type="text" name="name" value="${u.name}" style="display: block;" />
            <b>Primer Apellido</b>
            <input type="text" name="firstLastname" value="${u.firstLastname}" style="display: block;" />
            <b>Segundo Apellido</b>
            <input type="text" name="secondLastname" value="${u.secondLastname}" style="display: block;" />
            <input type="submit" name="save" value="Guardar">
        </form>
    </body>
</html>
