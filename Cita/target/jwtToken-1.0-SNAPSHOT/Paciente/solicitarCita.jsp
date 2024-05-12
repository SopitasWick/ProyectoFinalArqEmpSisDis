<%-- 
    Document   : solicitarCita
    Created on : 11 may 2024, 17:57:16
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
        <h1>ECE - Solicitar cita</h1><br><br><br>
        <form id="solicitarCitaForm">
        <label for="idMedico">Id medico:</label>
        <input type="number" id="idMedico" name="idMedico" required><br><br>
        <label for="idFechaCita">Fecha cita:</label>
        <input type="datetime-local" id="idFechaCita" name="idFechaCita" required><br><br>
        <button type="submit">Aceptar</button>
        </form>
    </body>
</html>
