
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
                    <div class="row">
                        <div class="col s4">
                            <h1>TORRES </h1>
                        </div>
                        <div class="col s3" style="padding-top: 60px; text-align: right">
                            <h5> Apartamentos <br> Ocupados </h5>
                        </div>
                        <div class="col s4">
                            <input id="progreso" type="text" class="circle" value="53"/>
                        </div>
                        
                    </div>                    
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
                           <td> <c:out value="${lista.ocupados}"></c:out></td>
                           <td> <c:out value="${lista.disponibles}"></c:out> </td>
                           <td> <c:out value="${lista.reparacion}"></c:out> </td>
                           <td> <a href="apt?torre=${lista.id}" >ver</a> 
                               <input type="number" name="${lista.nombre}" value="${lista.ocupados}" hidden="true"/>
                           </td>
                       </tr>
                       </c:forEach>
                   </table>
                </div>
            </div>
        </main>     
        
        <%@include file="../platillas/footer.html" %>
        <script src="http://anthonyterrien.com/demo/knob/jquery.knob.min.js"></script>
        <script src="/Admin/resources/js/efectos.js"></script>
    </body>
</html>
