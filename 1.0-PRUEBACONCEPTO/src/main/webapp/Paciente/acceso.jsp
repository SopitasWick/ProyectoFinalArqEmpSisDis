<%-- 
    Document   : acceso
    Created on : 11 may 2024, 14:44:50
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Conceder acceso medico</title>
    </head>
    <body>
        <h1>Conceder acceso medico</h1><br><br><br>
        <form id="concederAcceso">
           <label for="idCitaText">Id cita</label>
           <input type="number" id="idCitaText" name="idCitaText" required><br><br>
           <label for="tokenHuellaAcceso">Token huella</label>
           <input type="password" id="tokenHuellaAcceso" name="tokenHuellaAcceso" required><br><br>
           <button type="submit">Aceptar</button> 
        </form>
    </body>
</html>
