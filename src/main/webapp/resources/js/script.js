    
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
   
    $.ajax({
        url:'http://localhost:8084/Admin/api/form/apt-disp/'+id,
        type: 'GET',
        success: function (data) {
            $.each(data, function(index,value){
                console.log(">>>>>>>" + value.id);
            });
        }
    });
    
    var cadena = "";
    for (var i = 0; i < 9; i++) {
        cadena += "<li> <a class='waves-effect' onclick='eleccion("+i+")'> APT FOR "+i+" TORRE "+id+" </a> </li>";
    }
    
    document.getElementById("selApts").innerHTML = cadena;
    
}

function eleccion(id) {
    //var id = document.getElementsByName("selApt")[0].value;
    document.getElementById("apt").value = id;
    document.getElementById("btnGuardar").disabled = false;
                
}