<%-- 
    Document   : crear
    Created on : 11/05/2021, 10:17:03 AM
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>residente</title>
    </head>
    <body>
        <%@include file="../platillas/menubar.html" %>
        
        <h1>Nuevo Residente</h1>
        
        <form action="residente" method="post" class="container">
            <label for="id">N° Identificacion</label>
            <input type="number" name="id" id="id" required="true" requiredMessage="Este campo es obligatorio" maxlength="15" min="5"/>
            
            <label for="tipo">Tipo documento</label>
            <input type="text" name="tipo" id="tipo" required="true" requiredMessage="Este campo es obligatorio"/>
            
            <label for="nombres">Nombres</label>
            <input type="text" name="nombres" id="nombres" required="true" requiredMessage="Este campo es obligatorio"/>
            
            <label for="apellidos">Apellidos</label>
            <input type="text" name="apellidos" id="apellidos" required="true" requiredMessage="Este campo es obligatorio"/>
            
            <label for="usuario">G-mail</label>
            <input type="text" name="usuario" id="usuario" required="true" requiredMessage="Este campo es obligatorio"/>
            
            <label for="contacto">N° telefono</label>
            <input type="text" name="contacto" id="contacto"/>
            
            
                    
            <button type="submit">Guardar</button>
        </form>
    </body>
</html>
