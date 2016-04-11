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
            operacion: "leerIngresos"
        }, function (data) {
            var resultado = data;
            var tabla = document.getElementById("tabla");
            if (tabla.hasChildNodes())
            {
                while (tabla.childNodes.length >= 1)
                {
                    tabla.removeChild(tabla.firstChild);
                }
            }
            for (var i = 0; resultado.length; i++)
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
                var texto5 = document.createTextNode(resultado[i].cantidad);
                td5.appendChild(texto5);
                var td6 = document.createElement("td");
                var texto6 = document.createTextNode(resultado[i].valorunitario);
                td6.appendChild(texto6);
                var td7 = document.createElement("td");
                var texto7 = document.createTextNode(resultado[i].valortotal);
                td7.appendChild(texto7);
                var td8 = document.createElement("td");
                var texto8 = document.createTextNode(resultado[i].fuente.nombre);
                td8.appendChild(texto8);
                tr.appendChild(td1);
                tr.appendChild(td2);
                tr.appendChild(td3);
                tr.appendChild(td4);
                tr.appendChild(td5);
                tr.appendChild(td6);
                tr.appendChild(td7);
                tr.appendChild(td8);
                tabla.appendChild(tr);
            }
        }).fail(function ()
        {
            alert("Error en la operacion leerIngresos");
        });

    }
    function nuevoIngreso()
    {
        var fecha = document.getElementById("fechaNI").value;
        var empresa = document.getElementById("empresaNI").value;
        var concepto = $('select[name=conceptoNI]').val();
        var cantidad = document.getElementById("cantidadNI").value;
        var valorunitario = document.getElementById("valoruNI").value;
        var valortotal = document.getElementById("valortNI").value;
        var fuente = $('select[name=fuenteNI]').val();
        var idsoporte = document.getElementById("idsoporteNI").value;
        var soporte = null;
        $.post("Controladora", {
            operacion: "nuevoIngreso",
            fecha: fecha,
            empresa: empresa,
            concepto: concepto,
            valorunitario: valorunitario,
            cantidad: cantidad,
            valortotal: valortotal,
            fuente: fuente,
            idsoporte: idsoporte,
            soporte: soporte
        }, function (data) {
            var resultado = data;
            alert(resultado);
            leerIngresos();

        }).fail(function ()
        {
            alert("Error en la operacion");
        });
    }
    function modificarIngreso()
    {
        //Aqui se crean variables y captura informacion
        var identificador = document.getElementById("idOMI").value;
        var fecha = document.getElementById("fechaMI").value;
        var empresa = document.getElementById("empresaMI").value;
        var concepto = $('select[name=conceptoMI]').val();
        var cantidad = document.getElementById("cantidadMI").value;
        var valorunitario = document.getElementById("valoruMI").value;
        var valortotal = document.getElementById("valortMI").value;
        var fuente = $('select[name=fuenteMI]').val();
        var idsoporte = document.getElementById("idsoporteMI").value;
        var soporte = null;
        $.post("Controladora", {
            //Aqui van los parametros
            operacion: "modificarIngreso",
            identificador: identificador,
            fecha: fecha,
            empresa: empresa,
            concepto: concepto,
            valorunitario: valorunitario,
            cantidad: cantidad,
            valortotal: valortotal,
            fuente: fuente,
            idsoporte: idsoporte,
            soporte: soporte
        }, function (data) {
            var resultado = data;
            alert(resultado);
            leerIngresos();
        }).fail(function ()
        {
            alert("error en la operacion modificarIngreso");
        });
    }
    function buscarMI()
    {
        //Aqui se crean variables y captura informacion
        var identificador = document.getElementById("idOMI").value;
        $.post("Controladora", {
            operacion: "buscarIngreso",
            identificador: identificador
        }, function (data) {
            var resultado = data;
            document.getElementById("fechaMI").value = resultado.fecha;
            document.getElementById("empresaMI").value = resultado.empresa;
            leerConceptosModificar(resultado.concepto.identificador);
            document.getElementById("valoruMI").value = resultado.valorunitario;
            document.getElementById("cantidadMI").value = resultado.cantidad;
            document.getElementById("valortMI").value = resultado.valortotal;
            leerFuentesModificar(resultado.fuente.identificador);

        }).fail(function ()
        {
            alert("error en la operacion");
        });
    }
    function buscarEI()
    {
        //Aqui se crean variables y captura informacion
        var identificador = document.getElementById("idOEI").value;
        $.post("Controladora", {
            //Aqui van los parametros
            operacion: "buscarIngreso",
            identificador: identificador
        }, function (data) {
            var resultado = data;
            var resultado = data;
            document.getElementById("fechaEI").value = resultado.fecha;
            document.getElementById("empresaEI").value = resultado.empresa;
            document.getElementById("conceptoEI").value = resultado.concepto.nombre;
            document.getElementById("valoruEI").value = resultado.valorunitario;
            document.getElementById("cantidadEI").value = resultado.cantidad;
            document.getElementById("valortEI").value = resultado.valorunitario;
            document.getElementById("fuenteEI").value = resultado.fuente.nombre;
        });
    }

    function eliminarIngreso()
    {
        //Aqui se crean variables y captura informacion
        var identificador=document.getElementById("idOEI").value;
        $.post("Controladora", {
            //Aqui van los parametros
            operacion:"eliminarIngreso",
            identificador:identificador
        }, function (data) {
            var resultado = data;
            alert(resultado);
            leerIngresos();
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
            alert("Error en la operacion leerConceptos");
        });
    }

    function leerConceptosModificar(seleccionado)
    {
        $.post("Controladora", {
            operacion: "leerConceptosIngreso"
        }, function (data) {
            var resultado = data;
            var select = document.getElementById("conceptoMI");
            if (select.hasChildNodes())
            {
                while (select.childNodes.length >= 1)
                {
                    select.removeChild(select.firstChild);
                }
            }
            for (var i = 0; i < resultado.length; i++)
            {
                var option = document.createElement("option");
                option.setAttribute("value", resultado[i].identificador);
                if (resultado[i].identificador == seleccionado)
                {
                    option.setAttribute("selected", "");
                }
                option.innerHTML = resultado[i].nombre;
                select.appendChild(option);
            }
        }).fail(function ()
        {
            alert("Error en la operacion leerConceptosModificar");
        });
    }

    function leerFuentesModificar(seleccionado)
    {
        $.post("Controladora", {
            operacion: "leerFuentes"
        }, function (data) {
            var resultado = data;
            var select = document.getElementById("fuenteMI");
            if (select.hasChildNodes())
            {
                while (select.childNodes.length >= 1)
                {
                    select.removeChild(select.firstChild);
                }
            }
            for (var i = 0; i < resultado.length; i++)
            {
                var option = document.createElement("option");
                option.setAttribute("value", resultado[i].identificador);
                if (seleccionado == resultado[i].identificador)
                {
                    option.setAttribute("selected", "");
                }
                option.innerHTML = resultado[i].nombre;
                select.appendChild(option);
            }

        }).fail(function ()
        {
            alert("Error en la operacion leerFuentes");
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
            alert("Error en la operacion leerFuentes");
        });
    }

    function calcularValorTotal()
    {
        var valorunitario = document.getElementById("valoruNI").value;
        var cantidad = document.getElementById("cantidadNI").value;
        var total = valorunitario * cantidad;
        document.getElementById("valortNI").value = total;
    }

});
