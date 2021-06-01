$(document).ready(function(){
    var t1 = document.getElementsByName("TORRE 1")[0].value;
    var t2 = document.getElementsByName("TORRE 2")[0].value;
    var t3 = document.getElementsByName("TORRE 3")[0].value;
    var t4 = document.getElementsByName("TORRE 4")[0].value;
    var tt = parseInt(t1) + parseInt(t2) + parseInt(t3) + parseInt(t4);
    document.getElementById("progreso").value = tt;
    
    $(".circle").knob({
        "min":0,
        "max":80,
        "width":200,
        "height":200,
        "fgColor":"#00bfa5",
        "thickness":".6",
        "angleOffset":"200",
        "readOnly":true
    }); 
});

