    
document.addEventListener('DOMContentLoaded', function() {
    var elems = document.querySelectorAll('select');
    var instances = M.FormSelect.init(elems);
});

document.addEventListener('DOMContentLoaded', function() {
    var elems = document.querySelectorAll('.modal');
    var instances = M.Modal.init(elems);
  });
  
 
function listaApts() {
    
    var id = document.getElementsByName("torre")[0].value;
    var cadena = "";
    $.ajax({
        url:'http://localhost:8084/Admin/api/form/apt-disp/'+id,
        type: 'GET',
        success: function (data) {
            $.each(data, function(index,value){                
                var detalles = value.piso+"0"+value.numero+" "+value.descripcion;
                var idApt = value.id;
                var argumento = idApt+",'"+detalles+"'";
                console.log(">>>>>>>" + detalles);
                //cadena += "<li> <a class='waves-effect' onclick='eleccion("+argumento+")'> "+detalles+"</a> </li>";
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