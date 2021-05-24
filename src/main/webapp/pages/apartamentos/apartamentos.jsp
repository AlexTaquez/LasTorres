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
                        
                    

                        
                    
                        <h1 style="text-align:center;">Apartamentos</h1>
                    
                        <ul id="dropdown2" class="dropdown-content" >
                            <li><a href="apt?torre=35">1</a></li>
                            <li><a href="apt?torre=36">2</a></li>
                            <li><a href="apt?torre=37">3</a></li>
                            <li><a href="apt?torre=38">4</a></li>
                        </ul>
                        <a class="btn dropdown-trigger" href="#!" data-target="dropdown2"><% out.print(request.getAttribute("torre"));%><i class="material-icons right">arrow_drop_down</i></a>    
                    

                    <table class="highlight responsive-table  #cfd8dc blue-grey lighten-4" style="margin-top: 15px;">
                        <thead>
                        <tr>                
                                <td>Número</td>
                                <td>Piso</td>
                                <td>Propiedad</td>
                                <td>Arriendo</td>
                                <td>Estado</td>
                                <td>..</td>
                            </tr>
                        </thead>
                         <tbody>
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
                            </tbody>
                    </table>
                        
                </div>
           </div>
        </main>
        
        
            
            
         <%@include file="../platillas/footer.html" %>   
                    
    </body>
</html>
