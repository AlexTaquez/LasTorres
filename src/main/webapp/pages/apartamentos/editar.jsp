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
        <h1><c:out value="${opcion}"></c:out></h1>

            <div class="row container  ">
                <form action="/Admin/apt" method="post"  class="col s12" style="margin-top: 15px;">

                    <div class="row">

                        <div class="col s6">
                            <label for="estado">Estado del APT: *</label>
                            <select id="estado" name="estado">
                            <c:if test="${apartamento.estado=='O'}">
                                <option value="null" selected>OCUPADO</option>
                            </c:if>
                            <c:if test="${apartamento.estado=='D'}">
                                <option value="null" selected>DESOCUPADO</option>
                            </c:if>
                            <c:if test="${apartamento.estado=='M'}">
                                <option value="null" selected>EN MANTENIMIENTO</option>
                            </c:if>
                            
                            <c:if test="${apartamento.estado!='O'}">
                                <option value="O">OCUPADO</option>
                            </c:if>

                            <c:if test="${apartamento.estado!='D'}">
                                <option value="D">DESOCUPADO</option>
                            </c:if>                                    
                            <c:if test="${apartamento.estado!='M'}">
                                <option value="M">EN MANTENIMIENTO</option>
                            </c:if>
                        </select>
                    </div>

                    <div class="col s6">
                        <label for="propiedad">Propiedad del: *</label>
                        <select id="propiedad" name="propiedad">                            
                                <c:if test="${apartamento.propiedad==true}">
                                    <option value="null" selected>CONJUNTO</option>
                                </c:if>
                                <c:if test="${apartamento.propiedad==false}">
                                    <option value="null" selected>RESIDENTE</option>
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
                        <input type="text" name="descripcion" id="descripcion" value="${apartamento.arriendo}"/>
                    </div>
                </div>

                <button id="btnGuardar" class="waves-effect waves-light btn" type="submit" disabled="true">Guardar</button>
            </form>
        </div>
    </form>


    <%@include file="../platillas/footer.html" %>
    </body>
</html>
