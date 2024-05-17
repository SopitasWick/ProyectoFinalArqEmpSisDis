<%-- 
    Document   : concederAccesoMedico
    Created on : 11 may 2024, 18:09:19
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Conceder acceso</title>
    </head>
    <body>
        <h1>ECE - Conceder acceso a medico</h1><br><br><br>
        <form id="solicitarCitaForm">
            <label for="idCita">Id cita:</label>
            <input type="number" id="idCita" name="idCita" required><br><br>
            <label for="tokenHuellaPaciente">Token huella:</label>
            <input type="password" id="tokenHuellaPaciente" name="tokenHuellaPaciente" required><br><br>
            <button id="postButtonEvent">Solicitar</button>
        </form>
        <button id="logoutButton2" style="display: none;">Cerrar Sesión</button>
        <script src="fetchAutenticacionPaciente.js"></script>
    </body>
</html>
