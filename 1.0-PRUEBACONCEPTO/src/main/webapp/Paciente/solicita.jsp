<%-- 
    Document   : solicita
    Created on : 11 may 2024, 14:15:17
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Solicitar cita</title>
    </head>
    <body>
        <h1>Solicitar cita</h1>
        <br>
        <br>
        <br>
        <form id="solicitaCita">
           <label for="idMedicoText">Id medico</label>
           <input type="number" id="idMedicoText" name="idMedicoText" required><br><br>
           <label for="tokenHuellaSolicita">Token huella</label>
           <input type="password" id="tokenHuellaSolicita" name="tokenHuellaSolicita" required><br><br>
           <button type="submit">Aceptar</button> 
        </form>
    </body>
</html>
