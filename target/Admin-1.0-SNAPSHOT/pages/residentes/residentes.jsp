<%-- 
    Document   : residentes
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
        
        <main class="container">
            <div class="card #eceff1 blue-grey lighten-5 ">
                <div class="card-content">

                    <div class="container">
                        <h1>Residentes</h1>

                        <li><a href="/Admin/residente?">Registrar</a></li>

                        <h3> <% out.print(request.getAttribute("torre"));%>  </h3>

                        <li><a href="residente?torre=1">1</a></li>
                        <li><a href="residente?torre=2">2</a></li>
                        <li><a href="residente?torre=3">3</a></li>
                        <li><a href="residente?torre=4">4</a></li>
                        <li><a href="residente?torre=0">Inactivos</a></li>

                    </div>
                    <table class="highlight responsive-table  #cfd8dc blue-grey lighten-4">
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
                                        <c:if test="${lista.titular==1}">
                                            <c:out value="${lista.contacto}"></c:out>
                                        </c:if>
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
