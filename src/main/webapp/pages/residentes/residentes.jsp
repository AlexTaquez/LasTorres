<%-- 
    Created on : 5/05/2021, 04:48:21 PM
    Author     : Usuario
<% request.getAttribute("lista"); %>
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

                    
                        <h1 style="text-align:center;">Residentes</h1>

    
                        <ul id="dropdown2" class="dropdown-content" >
                            <li><a  href="residente?torre=1">1</a></li>
                            <li><a  href="residente?torre=2">2</a></li>
                            <li><a  href="residente?torre=3">3</a></li>
                            <li><a  href="residente?torre=4">4</a></li>
                            <li><a  href="residente?torre=0">Inactivos</a></li>
                        </ul>
                        <a class="btn dropdown-trigger" href="#!" data-target="dropdown2"><% out.print(request.getAttribute("torre"));%><i class="material-icons right">arrow_drop_down</i></a>
                        <a href="/Admin/residente?" class="waves-effect waves-light btn">Registrar</a>
                             
                    
                        <table class="highlight responsive-table  #cfd8dc blue-grey lighten-4" style="margin-top: 15px;">
                            <thead>
                                <tr>
                                    <td>N° Identificación</td>
                                    <td>Tipo</td>
                                    <td>Nombres</td>
                                    <td>Apellidos</td>
                                    <td>Usuario</td>
                                    <td>Contacto</td>
                                    <td>Titular</td>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="lista" items="${lista}">

                                    <tr>
                                        <td> <c:out value="${lista.numero}"></c:out> </td>
                                        <td> <c:out value="${lista.tipoId}"></c:out> </td>
                                        <td> <c:out value="${lista.nombres}"></c:out> </td>
                                        <td> <c:out value="${lista.apellidos}"></c:out> </td>
                                        <td> <c:out value="${lista.usuario}"></c:out> </td>
                                        <td> <c:out value="${lista.contacto}"></c:out> </td>     

                                        <td> 
                                            <c:if test="${lista.titular==0}">SI</c:if>
                                            <c:if test="${lista.titular==1}"><c:out value="${lista.contacto}"></c:out></c:if>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>

                </div>
            </div>
                        
                        
        </main>            
            
        <%@include file="../platillas/footer.html" %>
    </body>
</html>
