<%-- 
    Document   : crear
    Created on : 11/05/2021, 10:17:03 AM
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <%@include file="../platillas/head.html" %>
    <body>
        <%@include file="../platillas/menubar.html" %>
       
        <h1>Nuevo Residente</h1>
        
        <form action="../../residente" method="post" class="container">
            <label for="id">N° Identificacion</label>
            <input type="number" name="id" id="id" required="true" requiredMessage="Este campo es obligatorio" maxlength="15" min="5"/>
            
            <label for="tipo">Tipo documento</label>
            <select id="tipo">
                <option value="CC" selected>CC</option>
                <option value="CE">CE</option>
                <option value="TI">TI</option>
            </select>
            
            <label for="nombres">Nombres</label>
            <input type="text" name="nombres" id="nombres" required="true" requiredMessage="Este campo es obligatorio"/>
            
            <label for="apellidos">Apellidos</label>
            <input type="text" name="apellidos" id="apellidos" required="true" requiredMessage="Este campo es obligatorio"/>
            
            <label for="usuario">G-mail</label>
            <input type="text" name="usuario" id="usuario" required="true" requiredMessage="Este campo es obligatorio"/>
            
            <label for="contacto">N° telefono</label>
            <input type="text" name="contacto" id="contacto"/>
            
            <label for="torre">Torre del titular</label>
            <select id="torre">
                <option value="1">TORRE 1</option>
                <option value="2">TORRE 2</option>
                <option value="3">TORRE 3</option>
                <option value="4">TORRE 4</option>
            </select>
            
            <div id="select">
                <%@include file="vincular.jsp" %>
            </div>
                    
            <button type="submit">Guardar</button>
        </form>
    </body>
</html>
