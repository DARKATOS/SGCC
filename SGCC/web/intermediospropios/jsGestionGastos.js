/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(function ()
{

    $("#nuevoGasto").on("click", nuevoGasto);
    $("#modificarGasto").on("click", modificarGasto);
    $("#eliminarGasto").on("click", eliminarGasto);
    $("#buscarMG").on("click", buscarMG);
    $("#buscarEG").on("click", buscarEG);
    
    $(document).ready(function () {
        leerGastos();
    });


    function leerGastos()
    {
        //Aqui se crean variables y captura informacion
        var tabla=document.getElementById("tabla");
        $.post("Controladora", {
            operacion:"leerGastos"
            //Aqui van los parametros
        }, function (data) {
            var resultado = data;
            for (var i=0; resultado.length; i++)
            {
           
                var tr = document.createElement("tr");
                var td1 = document.createElement("td");
                var texto1 = document.createTextNode(resultado[i].identificador);
                td1.appendChild(texto1);
                var td2 = document.createElement("td");
                var texto2 = document.createTextNode(resultado[i].fecha);
                td2.appendChild(texto2);
                var td3 = document.createElement("td");
                var texto3 = document.createTextNode(resultado[i].empresa);
                td3.appendChild(texto3);
                var td4 = document.createElement("td");
                var texto4 = document.createTextNode(resultado[i].concepto.nombre);
                td4.appendChild(texto4);
                var td5 = document.createElement("td");
                var texto5 = document.createTextNode(resultado[i].valortotal);
                td5.appendChild(texto5);
                var td6 = document.createElement("td");
                var texto6 = document.createTextNode(resultado[i].fuente.nombre);
                td6.appendChild(texto6);
                //Link de soportes
//                var td7 = document.createElement("td");
//                var link = document.createElement("button");
//                link.setAttribute("id","soportes");
//                link.setAttribute("class","form-control");
//                link.setAttribute("value",resultado[i].identificador);
//                td7.appendChild(link);
                tr.appendChild(td1);
                tr.appendChild(td2);
                tr.appendChild(td3);
                tr.appendChild(td4);
                tr.appendChild(td5);
                tr.appendChild(td6);
                //tr.appendChild(td7);
                tabla.appendChild(tr);
            }
        });
    }
    function nuevoGasto()
    {
        //Aqui se crean variables y captura informacion
        var fecha=document.getElementById("fechaNG").value;
        var empresa=document.getElementById("empresaNG").value;
        var concepto=document.getElementById("conceptoNG").value;
        var valortotal=document.getElementById("valortotalNG").value;
        var fuente=document.getElementById("fuenteNG").value;
        var idsoporte=document.getElementById("idsoporteNG").value;
        var soporte=document.getElementById("soporteNG").value;
        $.post("Controladora", {
            oper: "nuevoGasto",
            fecha:fecha,
            empresa: empresa,
            concepto: concepto,
            valortotal: valortotal,
            fuente:fuente,
            idsoporte: idsoporte,
            soporte: soporte 
        }, function (data) {
            var resultado = data;
            alert(data);
        });
    }
    function modificarGasto()
    {
        //Aqui se crean variables y captura informacion
        $.post("Controladora", {
            //Aqui van los parametros
        }, function (data) {
            var resultado = data;
            
        });
    }

    function eliminarGasto()
    {
        //Aqui se crean variables y captura informacion
        $.post("Servlet", {
            //Aqui van los parametros
        }, function (data) {
            var resultado = data;
            
        });
    }

    function buscarMG()
    {
        //Aqui se crean variables y captura informacion
        $.post("Servlet", {
            //Aqui van los parametros
        }, function (data) {
            var resultado = data;
            
        });
    }
    function buscarEG()
    {
        //Aqui se crean variables y captura informacion
        
        $.post("Servlet", {
            //Aqui van los parametros
        }, function (data) {
            var resultado = data;
            
        });
    }
});

