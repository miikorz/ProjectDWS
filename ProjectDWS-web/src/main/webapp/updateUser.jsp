<%-- 
    Document   : updateUser
    Created on : 11-nov-2016, 20:08:58
    Author     : fabio
--%>

<%-- 
<%@page contentType="text/html" pageEncoding="UTF-8"%> WTF? Preguntar en clase (acentos)
--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css" media="screen" />
        <title>Modificar Usuario</title>
    </head>
    <body>
        <h1>Modificar Usuario</h1>
        <br>
        <form action="UpdateUser?action=update&id=${u.id}" method="post" class="col-sm-5">
            <div class="form-group row">
                <label for="user" class="col-sm-3 col-form-label">Usuario</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" placeholder="Usuario" name="user" value="${u.user}" />  
                </div>
            </div>
            <div class="form-group row">
                <label for="password" class="col-sm-3 col-form-label">Contraseña</label>
                <div class="col-sm-6">
                    <input type="password" class="form-control" placeholder="Contraseña" name="password" value="${u.password}" />
                </div>
            </div>
            <div class="form-group row">
                <label for="name" class="col-sm-3 col-form-label">Nombre</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" placeholder="Nombre" name="name" value="${u.name}" />
                </div>
            </div>
            <div class="form-group row">
                <label for="firstLastname" class="col-sm-3 col-form-label">Primer Apellido</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" placeholder="Primer Apellido" name="firstLastname" value="${u.firstLastname}" />
                </div>
            </div>
            <div class="form-group row">
                <label for="secondLastname" class="col-sm-3 col-form-label">Segundo Apellido</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" placeholder="Segundo Apellido" name="secondLastname" value="${u.secondLastname}" />
                </div>
            </div>
            <div class="form-group row">
                <label for="age" class="col-sm-3 col-form-label">Edad</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" placeholder="Edad" name="age" value="${u.age}" />
                </div>
            </div>
            <div class="form-group row">
                <label for="addres" class="col-sm-3 col-form-label">Dirección</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" placeholder="Dirección" name="addres" value="${u.addres}" />
                </div>
            </div>
            <div class="form-group row">
                <label for="email" class="col-sm-3 col-form-label">Correo Electrónico</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" placeholder="Correo Electrónico" name="email" value="${u.email}" />
                </div>
            </div>
            <div class="form-group row">
                <label for="phone" class="col-sm-3 col-form-label">Teléfono</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" placeholder="Teléfono" name="phone" value="${u.phone}" />
                </div>
            </div>
            <input type="submit" name="save" value="Guardar" class="btn btn-primary">
            <input onclick="location.href='ListUsers'" type="button" name="cancel" value="Cancelar" class="btn btn-default">
        </form>
    </body>
</html>
