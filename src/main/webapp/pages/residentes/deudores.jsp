<%-- 
    Document   : deudores
    Created on : 5/05/2021, 05:10:05 PM
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

           <div class="card #eceff1 blue-grey lighten-5">
                <div class="card-content">
                    <h3 style="text-align:center;">Deudores</h3>
                    
                    <table class="highlight responsive-table  #cfd8dc blue-grey lighten-4" style="margin-top: 15px;">
                            <thead>
                                <tr>
                                    <td>Nombres</td>
                                    <td>Apellidos</td>
                                    <td>Apartamento</td>
                                    <td>Torre</td>
                                    <td>Deuda</td>
                                    <td>Factura vencida</td>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="lista" items="${lista}">

                                    <tr>
                                        <td> <c:out value="${lista.nombres}"></c:out> </td>
                                        <td> <c:out value="${lista.apellidos}"></c:out> </td>
                                        <td> <c:out value="${lista.apartamento}"></c:out> </td>
                                        <td> <c:out value="${lista.torre}"></c:out> </td>
                                        <td> <c:out value="${lista.valor}"></c:out> </td>
                                        <td> <c:out value="${lista.termino}"></c:out> </td>

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
