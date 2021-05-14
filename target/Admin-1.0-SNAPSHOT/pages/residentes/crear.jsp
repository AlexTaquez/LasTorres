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
                      
            <label for="id">N° Identificacion *</label>
            <input type="number" name="id" id="id" required="true" requiredMessage="Este campo es obligatorio" maxlength="15" min="5"/>
            
            <label for="tipo">Tipo documento *</label>
            <select id="tipo">
                <option value="CC" selected>CC</option>
                <option value="CE">CE</option>
                <option value="TI">TI</option>
            </select>
            <br>
            <label for="nombres">Nombres *</label>
            <input type="text" name="nombres" id="nombres" required="true" requiredMessage="Este campo es obligatorio"/>
            
            <label for="apellidos">Apellidos *</label>
            <input type="text" name="apellidos" id="apellidos" required="true" requiredMessage="Este campo es obligatorio"/>
            
            <label for="usuario">G-mail *</label>
            <input type="text" name="usuario" id="usuario" required="true" requiredMessage="Este campo es obligatorio"/>
            
            <label for="contacto">N° telefono</label>
            <input type="text" name="contacto" id="contacto"/>
            
            <label for="torre">Torre del Apartamento *</label>
            <select id="torre" name="torre">
                <option value="4" selected>TORRE 1</option>
                <option value="14">TORRE 2</option>
                <option value="24">TORRE 3</option>
                <option value="34">TORRE 4</option>
            </select>
            <br>
            
            <label for="apt">Apartamento *</label>
            <input type="text" name="apt" id="apt" required="true" disabled />
            <a class="waves-effect waves-light btn modal-trigger" href="#modal1" onclick="listaApts()">Seleccionar</a>         
            
            <br>
            <button id="btnGuardar" type="submit" disabled="true">Guardar</button>
        </form>        
                
        <!-- Modal Structure -->
        <div id="modal1" class="modal" style="height: 80%">
            <div class="modal-content" >
                <ul id="selApts"></ul>
            </div>
            <div class="modal-footer">
                <a href="#!" class="modal-close waves-effect waves-green btn-flat">OK</a>
            </div>
        </div>
        
    </body>
</html>
