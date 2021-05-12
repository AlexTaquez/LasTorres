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
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>residentes</title>
    </head>
    <body>
        <%@include file="../platillas/menubar.html" %>
        <div class="container">
            <h1>Residentes</h1>

            <li><a href="pages/residentes/crear.jsp">Registrar</a></li>

            <h3> <% out.print(request.getAttribute("torre")); %>  </h3>
            
            <li><a href="residente?torre=1">1</a></li>
            <li><a href="residente?torre=2">2</a></li>
            <li><a href="residente?torre=3">3</a></li>
            <li><a href="residente?torre=4">4</a></li>
            <li><a href="residente?torre=4">Inactivos</a></li>
            
        </div>
        <table class="container">
            <tr>
                <td>N° Identificación</td>
                <td>Tipo</td>
                <td>Nombres</td>
                <td>Apellidos</td>
                <td>Usuario</td>
                <td>Contacto</td>
                <td>Titular</td>
            </tr>
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
        </table>
        
    </body>
</html>
