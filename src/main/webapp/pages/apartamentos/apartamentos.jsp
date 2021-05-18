<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <%@include file="../platillas/head.html" %>
    <body>
        <%@include file="../platillas/menubar.html" %>
        <h1><c:out value="${opcion}"></c:out></h1>
         
            <h3> <% out.print(request.getAttribute("torre")); %>  </h3>
            
            <li><a href="residente?torre=1">1</a></li>
            <li><a href="residente?torre=2">2</a></li>
            <li><a href="residente?torre=3">3</a></li>
            <li><a href="residente?torre=4">4</a></li>

        
        <table class="responsive striped">
            <tr>                
                <td>Número</td>
                <td>Piso</td>
                <td>Propiedad</td>
                <td>Arriendo</td>
                <td>Estado</td>
                <td>..</td>
            </tr>
            <c:forEach var="lista" items="${lista}">
            <tr>
                <td> <c:out value="${lista.piso} 0 ${lista.numero}"></c:out> </td>
                <td> <c:out value="${lista.piso}"></c:out> </td>
                <td> <c:out value="${lista.propiedad}"></c:out> </td>

                <td> 
                    <c:if test="${lista.arriendo==0}">NO</c:if>
                    <c:if test="${lista.arriendo!=0}">
                        <c:out value="${lista.arriendo}"></c:out>
                    </c:if>
                </td>     
                
                <td> 
                    <c:if test="${lista.estado=='O'}">OCUPADO</c:if>
                    <c:if test="${lista.estado=='D'}">DESOCUPADO </c:if>
                    <c:if test="${lista.estado=='M'}">EN MANTENIMIENTO</c:if>
                </td>
                <td> <a href="apt?get=${lista.id}" >actualizar</a> </td>
                
            </tr>
            </c:forEach>
        </table>
                    
    </body>
</html>
