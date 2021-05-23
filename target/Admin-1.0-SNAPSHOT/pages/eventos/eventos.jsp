<%-- 
    Document   : apartamentos
    Created on : 5/05/2021, 05:02:10 PM
    Author     : Usuario
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
                        <h1>Eventos</h1>

                        <li><a href="evento?">Nuevo Evento</a></li>

                        <h3> <% out.print(request.getAttribute("tipo"));%>  </h3>
                        <ul>
                            <li><a href="evento?tipo=1">Administracion</a></li>
                            <li><a href="evento?tipo=2">Residencial</a></li>
                        </ul>

                    </div>
                    <table class="highlight responsive-table  #cfd8dc blue-grey lighten-4">
                        <thead>
                            <tr>
                                <td>Foto</td>
                                <td>Titulo</td>
                                <td>Descripción</td>
                                <td>Lugar</td>
                                <td>Tipo</td>
                                <td>Inicio</td>
                                <td>Finalización</td>
                                <td>Usuario</td>
                                <td>..</td>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="lista" items="${lista}">

                                <tr>
                                    <td> <img src="/Admin/resources/img/cliente/${lista.foto}" style="height: 150px"> </td>
                                    <td> <c:out value="${lista.titulo}"></c:out> </td>
                                    <td> <c:out value="${lista.descripcion}"></c:out> </td>
                                    <td> <c:out value="${lista.lugar}"></c:out> </td>
                                    <td> <c:out value="${lista.tipo}"></c:out> </td>
                                    <td> <c:out value="${lista.inicio}"></c:out> </td>   
                                    <td> <c:out value="${lista.fin}"></c:out> </td>
                                    <c:if test="${lista.residente==5}"><td>ADMIN</td></c:if>
                                    <c:if test="${lista.residente!=5}">
                                    <td> <c:out value="${lista.usuario}"></c:out></td>
                                    </c:if>

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
