<%-- 
    Document   : opcionesP
    Created on : 11 may 2024, 17:50:16
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Opciones Paciente</title>
    </head>
    <body>
        <h1>ECE-Paciente-Menu opciones</h1><br><br><br>
        <button id="logoutButto3" style="display: none;">Cerrar Sesión</button>
        <button id="solicitarCitabtn" >Solicitar cita</button><br><br>
        <button id="postButtonEvent">Conceder acceso</button>
        <script src="fetchAutenticacionPaciente.js"></script>
    </body>
    <script>
        document.getElementById('solicitarCitabtn').addEventListener('click', function () {
            let token = localStorage.getItem('token');
            if (token) {
                window.location.href = window.location.href = 'solicitarCita.jsp';
                ;
            } else {
                showMessage('Token no disponible. Inicia sesión primero.', false);
            }
        });
    </script>
</html>
