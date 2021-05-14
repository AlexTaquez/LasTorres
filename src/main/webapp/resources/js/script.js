    
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
    
   // $.getJSON("https://conjuntocerrado01.herokuapp.com/api/form/apt-disp/"+id, function(data){
	
        // limpiamos el contenedor del resultado de la búsqueda.
        //$("#selApts").empty();
	  
          // por cada uno de los items que contiene el objeto JSON obtenido invoca a una función que recibe el ordinal y el propio item
       // $.each(data.items, function(i,item){
      //      console.log(">>>>>>>" + item);
            //$("<img/>").attr("src", item.media.m).attr("alt", item.title).attr("title", item.title).appendTo("#images");
	    
       // });
   // });
    
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