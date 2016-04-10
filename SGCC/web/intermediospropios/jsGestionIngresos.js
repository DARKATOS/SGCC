/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



$(function ()
{
    $("#nuevoIngreso").on("click", nuevoIngreso);
    $("#modificarIngreso").on("click", modificarIngreso);
    $("#buscarMI").on("click", buscarMI);
    $("#buscarEI").on("click", buscarEI);
    $("#eliminarIngreso").on("click", eliminarIngreso);
    
    $("#valortNI").on("focus", calcularValorTotal);
    

    $(document).ready(function () {
        leerIngresos();
        leerConceptos();
        leerFuentes();
    });


    function leerIngresos()
    {
        //Aqui se crean variables y captura informacion
        $.post("Controladora", {
            operacion:"leerIngresos"
        }, function (data) {
            var resultado = data;
            
            

        }).fail(function ()
        {
            alert("Error en la operacion");
        });

    }
    function nuevoIngreso()
    {
        var fecha=document.getElementById("fechaNI").value;
        var empresa=document.getElementById("empresaNI").value;
        var concepto=document.getElementById("conceptoNI").value;
        var cantidad=document.getElementById("cantidadNI").value;
        var valorunitario=document.getElementById("valoruNI").value;
        var valortotal=document.getElementById("valortNI").value;
        var fuente=document.getElementById("fuenteNI").value;
        var idsoporte=document.getElementById("idsoporteNI").value;
        var soporte=null;
        $.post("Controladora", {
            operacion:"nuevoIngreso",
            fecha: fecha,
            empresa:empresa,
            concepto:concepto,
            valorunitario:valorunitario,
            cantidad: cantidad,
            valortotal:valortotal,
            fuente:fuente,
            idsoporte:idsoporte,
            soporte:soporte
        }, function (data) {
            var resultado = data;
            alert(resultado);

        }).fail(function()
        {
            alert("Error en la operacion");
        });
    }
    function modificarIngreso()
    {
        //Aqui se crean variables y captura informacion
        $.post("Controladora", {
            //Aqui van los parametros
        }, function (data) {
            var resultado = data;

        });
    }
    function buscarMI()
    {
        //Aqui se crean variables y captura informacion
        var identificador=document.getElementById("idOMI").value;
        $.post("Controladora", {
            operacion:"buscarIngreso",
            identificador:identificador
        }, function (data) {
            var resultado = data;
            
        }).fail(function()
        {
            alert("error en la operacion");
        });
    }
    function buscarEI()
    {
        //Aqui se crean variables y captura informacion
        $.post("Controladora", {
            //Aqui van los parametros
        }, function (data) {
            var resultado = data;

        });
    }

    function eliminarIngreso()
    {
        //Aqui se crean variables y captura informacion
        $.post("Controladora", {
            //Aqui van los parametros
        }, function (data) {
            var resultado = data;

        });
    }

    function leerConceptos()
    {
        $.post("Controladora", {
            operacion: "leerConceptosIngreso"
        }, function (data) {
            var resultado = data;
            var select = document.getElementById("conceptoNI");
            for (var i = 0; i < resultado.length; i++)
            {
                var option = document.createElement("option");
                option.setAttribute("value", resultado[i].identificador);
                option.innerHTML = resultado[i].nombre;
                select.appendChild(option);
            }
        }).fail(function ()
        {
            alert("Error en la operacion");
        });
    }

    function leerFuentes()
    {
        $.post("Controladora", {
            operacion: "leerFuentes"
        }, function (data) {
            var resultado = data;
            var select = document.getElementById("fuenteNI");
            for (var i = 0; i < resultado.length; i++)
            {
                var option = document.createElement("option");
                option.setAttribute("value", resultado[i].identificador);
                option.innerHTML = resultado[i].nombre;
                select.appendChild(option);
            }

        }).fail(function ()
        {
            alert("Error en la operacion");
        });
    }
    
    function calcularValorTotal()
    {
        var valorunitario=document.getElementById("valoruNI").value;
        var cantidad=document.getElementById("cantidadNI").value;
        var total=valorunitario*cantidad;
        document.getElementById("valortNI").value=total;
    }

});
