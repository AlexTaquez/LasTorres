    
document.addEventListener('DOMContentLoaded', function() {
    var elems = document.querySelectorAll('select');
    var instances = M.FormSelect.init(elems);
});

document.addEventListener('DOMContentLoaded', function() {
    var elems = document.querySelectorAll('.modal');
    var instances = M.Modal.init(elems);
  });
  
/* Script para menu responsive  AG*/
document.addEventListener('DOMContentLoaded', function () {
    var elems = document.querySelectorAll('.sidenav');
    var instances = M.Sidenav.init(elems);
});

/* Script para FECHAS  */
$(document).ready(function(){
    $('.datepicker').datepicker({
        format:'yyyy-mm-dd'
    });
});
/* Script para TIME  */
$(document).ready(function(){
    $('.timepicker').timepicker();
});

function listaDisp() {
    console.log(">>>>>>>");
    var id = document.getElementsByName("torre")[0].value;
    var cadena = "";
    $.ajax({
        url:'http://localhost:8080/Admin/api/form/apt-disp/'+id,
        type: 'GET',
        success: function (data) {
            $.each(data, function(index,value){                
                var detalles = value.piso+"0"+value.numero+" "+value.descripcion;
                var idApt = value.id;
                var argumento = idApt+",'"+detalles+"'";                
                cadena += '<li> <a class="waves-effect" onclick="eleccion('+argumento+')"> '+detalles+' </a> </li>';
            });
            document.getElementById("selApts").innerHTML = cadena;
            document.getElementById("btnModal").disabled = false;
        }
    });           
}

function eleccion(id, numero) {
    //var id = document.getElementsByName("selApt")[0].value;
    document.getElementById("apt").value = numero;
    document.getElementById("aptID").value = id;
    document.getElementById("btnGuardar").disabled = false;
                
}


function test() {
    //var id = document.getElementsByName("selApt")[0].value;
    var t = document.getElementById("titulo").value;
    var d = document.getElementById("detalles").value;
    
    console.log("T>>> "+t+" d>> "+d);      
}