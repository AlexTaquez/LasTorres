<%-- 
    Document   : RESIDENTE
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
       
        <p> <% out.print(request.getAttribute("fecha")); %>  </p>
        
        <!-- Diseño formulario AG -->        
         
         <main class="container">

           <div class="card #eceff1 blue-grey lighten-5">
                <div class="card-content">
                        <h3 style="text-align:center;">Nuevo Residente</h3>
                        <br>
                        <form action="/Admin/residente" method="post"  class="col s12" accept-charset="UTF-8" style="margin-top: 15px;">

                            <div class="row">                   
                                <div class="col s6">
                                    <label for="id">N° Identificacion *</label>
                                    <input type="number" name="id" id="id" required="true" requiredMessage="Este campo es obligatorio" maxlength="10" min="5"/>
                                </div>

                                <div class="col s6">
                                    <label for="tipo">Tipo documento *</label>
                                    <select id="tipo" name="tipo">
                                        <option value="CC" selected>CC</option>
                                        <option value="CE">CE</option>
                                        <option value="TI">TI</option>
                                    </select>
                                </div>
                            </div>

                            <div class="row">                   
                                <div class="col s6">
                                    <label for="nombres">Nombres *</label>
                                    <input type="text" name="nombres" id="nombres" required="true" requiredMessage="Este campo es obligatorio"/>
                                </div>

                                <div class="col s6">
                                    <label for="apellidos">Apellidos *</label>
                                    <input type="text" name="apellidos" id="apellidos" required="true" requiredMessage="Este campo es obligatorio"/>
                                </div>
                            </div>

                            <div class="row">                   
                                <div class="col s6">
                                    <label for="usuario">G-mail *</label>
                                    <input type="text" name="usuario" id="usuario" required="true" requiredMessage="Este campo es obligatorio"/>
                                </div>

                                <div class="col s6">
                                    <label for="contacto">N° telefono</label>
                                    <input type="text" name="contacto" id="contacto"/>
                                </div>
                            </div>

                            <div class="row">                   
                                <div class="col s6">
                                    <label for="torre">Torre del Apartamento *</label>
                                    <select id="torre" name="torre" onchange="listaDisp()">
                                        <option value="0" selected disabled="true">SELECCIONE</option>
                                        <option value="35">TORRE 1</option>
                                        <option value="36">TORRE 2</option>
                                        <option value="37">TORRE 3</option>
                                        <option value="38">TORRE 4</option>
                                    </select>
                                </div>

                                <div class="col s3">
                                    <label for="apt">Apartamento *</label>
                                    <input type="text" name="apt" id="apt" required="true" disabled />
                                    <input type="number" name="aptID" id="aptID" required="true" hidden="true"/>
                                </div>
                                <div class="col s3">
                                    <!-- a class="waves-effect waves-light btn modal-trigger" href="#modal1">Seleccionar</a-->            
                                    <button id="btnModal" class="waves-effect waves-light btn modal-trigger" type="reset" href='#modal1' disabled="true">Seleccionar</button>
                                </div>
                            </div>



                            <button id="btnGuardar" class="waves-effect waves-light btn " type="submit" disabled="true">Guardar</button>
                        </form>
                        
                    
                    
                </div>
            </div>
          
        </main>       
        <!-- Modal Structure -->
        <div id="modal1" class="modal">
            <div class="modal-content" >
                <ul id="selApts"></ul>
            </div>
            <div class="modal-footer">
                <a href="#!" class="modal-close waves-effect waves-green btn-flat">OK</a>
            </div>
        </div>
        
        
        <%@include file="../platillas/footer.html" %>
    </body>
</html>
