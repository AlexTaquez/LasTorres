<%-- 
    Document   : editar
    Created on : 17/05/2021, 08:59:24 PM
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <%@include file="../platillas/head.html" %>
    <body>
        <%@include file="../platillas/menubar.html" %>
        
        <main  class="container">
            
                <div class=" card #eceff1 blue-grey lighten-5" >
                        <div class="card-content">
                        <h2 style="text-align:center;"><c:out value="${opcion}"></c:out></h2>

                            <div class="row">
                                <form action="/Admin/apt" method="post"  class="col s12" style="margin-top: 15px;">

                                    <input type="number" name="id"value="${apartamento.id}" hidden="true"/>

                                <div class="row">                   
                                    <div class="col s6">
                                        <label for="piso">Piso</label>
                                        <input type="number" name="piso" id="piso" value="${apartamento.piso}" disabled/>
                                    </div>

                                    <div class="col s6">
                                        <label for="torre">Torre</label>
                                        <c:if test="${apartamento.torre==35}">
                                            <input type="text" name="torre" id="torre" value="TORRE 1" disabled/>
                                        </c:if>
                                        <c:if test="${apartamento.torre==36}">
                                            <input type="text" name="torre" id="torre" value="TORRE 2" disabled/>
                                        </c:if>
                                        <c:if test="${apartamento.torre==37}">
                                            <input type="text" name="torre" id="torre" value="TORRE 3" disabled/>
                                        </c:if>
                                        <c:if test="${apartamento.torre==38}">
                                            <input type="text" name="torre" id="torre" value="TORRE 4" disabled/>
                                        </c:if>
                                    </div>
                                </div>


                                <div class="row">
                                    <div class="col s6">
                                        <label for="estado">Estado del APT: *</label>
                                        <select id="estado" name="estado">
                                            <c:if test="${apartamento.estado=='O'}">
                                                <option value="O" selected>OCUPADO</option>
                                            </c:if>
                                            <c:if test="${apartamento.estado=='D'}">
                                                <option value="D" selected>DESOCUPADO</option>
                                            </c:if>
                                            <c:if test="${apartamento.estado=='M'}">
                                                <option value="M" selected>EN MANTENIMIENTO</option>
                                            </c:if>

                                            <c:if test="${apartamento.estado!='O'}">
                                                <option value="O">OCUPADO</option>
                                            </c:if>

                                            <c:if test="${apartamento.estado=='M'}">
                                                <option value="D">DESOCUPADO</option>
                                            </c:if>                                    
                                            <c:if test="${apartamento.estado=='D'}">
                                                <option value="M">EN MANTENIMIENTO</option>
                                            </c:if>
                                        </select>
                                    </div>

                                    <div class="col s6">
                                        <label for="propiedad">Propiedad del: *</label>
                                        <select id="propiedad" name="propiedad">                            
                                            <c:if test="${apartamento.propiedad==true}">
                                                <option value="1" selected>CONJUNTO</option>
                                            </c:if>
                                            <c:if test="${apartamento.propiedad==false}">
                                                <option value="0" selected>RESIDENTE</option>
                                            </c:if>
                                            <c:if test="${apartamento.propiedad==true}">
                                                <option value="0">RESIDENTE</option>
                                            </c:if>
                                            <c:if test="${apartamento.propiedad==false}">
                                                <option value="1">CONJUNTO</option>
                                            </c:if>
                                        </select>
                                    </div>
                                </div>

                                <div class="row">                   
                                    <div class="col s6">
                                        <label for="arriendo">Valor del arriendo: *</label>
                                        <input type="number" name="arriendo" id="arriendo" required="true" value="${apartamento.arriendo}" maxlength="7" minlength="1"/>
                                    </div>

                                    <div class="col s6">
                                        <label for="descripcion">Descripcion: *</label>
                                        <input type="text" name="descripcion" id="descripcion" value="${apartamento.descripcion}"/>
                                    </div>
                                </div>

                                <button id="btnGuardar" class="waves-effect waves-light btn" type="submit">Guardar</button>
                            </form>
                        </div>
                        </div>
                </div>
        </main>    
              
        
        
    <%@include file="../platillas/footer.html" %>
    </body>
</html>
