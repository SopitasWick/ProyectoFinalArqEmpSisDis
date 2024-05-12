<%-- 
    Document   : consulta
    Created on : 11 may 2024, 18:45:29
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulta</title>
    </head>
    <body>
        <h1>ECE - Ingresar consulta</h1><br><br>
        <form id="ingresarConsultaForm">
        <label for="idSintomas">Sintomas:</label>
        <input type="text" id="idSintomas" name="idSintomas" required><br><br>
        <label for="idDiagnostico">Diagnostico:</label>
        <input type="text" id="idDiagnostico" name="idDiagnostico" required><br><br>
        <label for="idReceta">Receta:</label>
        <input type="text" id="idReceta" name="idReceta" required><br><br>
        <button type="submit">Aceptar</button>
        </form>
        
    </body>
</html>
