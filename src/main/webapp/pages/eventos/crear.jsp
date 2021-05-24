<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%
    request.setCharacterEncoding("UTF-8");
%>
<html>
    <%@include file="../platillas/head.html" %>
    <body>
        <%@include file="../platillas/menubar.html" %>       
        
        <main class="container">

           <div class="card #eceff1 blue-grey lighten-5">
                <div class="card-content">
                        <h3 style="text-align:center;">Nuevo Evento</h3>
                        <br>
                        <form action="/Admin/evento" method="post" accept-charset="UTF-8" class="col s12" style="margin-top: 15px;" enctype="multipart/form-data">

                            <div class="row">                   
                                <div class="col s6">
                                    <label for="titulo">Titulo *</label>
                                    <input type="text" name="titulo" id="titulo" required="true" maxlength="40" minlength="5"/>
                                </div>

                                <div class="col s6">
                                    <label for="descripcion">Descripción corta *</label>
                                    <input type="text" name="descripcion" id="descripcion" required="true" maxlength="100" minlength="5"/>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col s6">
                                    <label for="detalles">Detalles *</label>
                                    <input type="text" name="detalles" id="detalles" required="true" maxlength="100" />
                                </div>

                                <div class="col s6">
                                    <label for="lugar">Lugar *</label>
                                    <input type="text" name="lugar" id="lugar" required="true" maxlength="40" minlength="5"/>
                                </div>
                            </div>

                            <div class="row"><!--  TIPO Y FOTO -->
                                <div class="col s6">
                                    <label for="tipo">Tipo de evento *</label>
                                    <select id="tipo" name="tipo">
                                        <option value="A" selected>ADMINISTRATIVO</option>
                                        <option value="R">RECREACIONAL</option>
                                        <option value="C">COMERCIAL</option>
                                    </select>
                                </div>
                                
                                <!--   
                                <div class="col s6">
                                    <label for="foto">Foto</label>
                                    <input type="file" name="foto" id="foto"/>
                                </div>
                                -->
                                <div class="file-field input-field col s6">
                                        <div class="btn">
                                                <span>Foto</span>
                                                <input type="file" name="foto" id="foto"/>
                                        </div>
                                        <div class="file-path-wrapper">
                                                <input class="file-path validate" type="text">
                                        </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col s6">
                                    <label for="inicio">Fecha de Inicio *</label>
                                    <input type="text" class="datepicker" required="true" name="inicio">
                                </div>

                                <div class="col s6">
                                    <label for="fin">Hora de Inicio *</label>
                                    <input type="text" class="timepicker" required="true" name="h1">
                                </div>
                            </div>
                            
                            <div class="row">
                                <div class="col s6">
                                    <label for="inicio">Fecha de Finalizacion</label>
                                    <input type="text" class="datepicker" name="fin">
                                </div>

                                <div class="col s6">
                                    <label for="fin">Hora de Finalizacion</label>
                                    <input type="text" class="timepicker" name="h2">
                                </div>
                            </div>

                            <button id="btnGuardar" class="waves-effect waves-light btn" type="submit">Guardar</button>
                        </form>
                     
                </div>
            </div>
          
        </main> 
        
        <%@include file="../platillas/footer.html" %>
    </body>
</html>