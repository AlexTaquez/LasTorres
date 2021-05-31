
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
                    <h1>TORRES </h1>
        
                    <table class="responsive striped">
                       <tr>                
                           <td>Torre</td>
                           <td>N° Pisos</td>
                           <td>N° APTS</td>
                           <td>Ocupados</td>
                           <td>Desocupados</td>
                           <td>En Mantenimiento</td>
                           <td>..</td>
                       </tr>
                       <c:forEach var="lista" items="${lista}">
                       <tr>
                           <td> <c:out value="${lista.nombre}"></c:out> </td>
                           <td> <c:out value="${lista.pisos}"></c:out> </td>
                           <td> <c:out value="${lista.apts}"></c:out> </td>
                           <td> <c:out value="${lista.ocupados}"></c:out> </td>
                           <td> <c:out value="${lista.disponibles}"></c:out> </td>
                           <td> <c:out value="${lista.reparacion}"></c:out> </td>
                           <td> <a href="apt?torre=${lista.id}" >ver</a> </td>
                       </tr>
                       </c:forEach>
                   </table>
                </div>
            </div>
        </main>     
        
        <%@include file="../platillas/footer.html" %>            
    </body>
</html>
