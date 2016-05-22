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
        verificarEmpleado();
        leerGastos();
        leerConceptos();
        leerFuentes();
    });

    function verificarEmpleado()
    {

        $.post("Controladora", {
            //Aqui van los parametros
            operacion: "verificarEmpleado"
        }, function (data) {
            var resultado = data;
            alert(resultado);
            if (resultado != "ADMINISTRADOR")
            {
                var tabla = document.getElementById("menuADM");
                if (tabla.hasChildNodes())
                {
                    while (tabla.childNodes.length >= 1)
                    {
                        tabla.removeChild(tabla.firstChild);
                    }
                }
            }
        }).fail(function ()
        {
            alert("error en la operacion modificarGasto");
        });
    }


    function leerGastos()
    {
        //Aqui se crean variables y captura informacion
        $.post("ControladoraGestionGastos", {
            operacion: "leerGastos"
                    //Aqui van los parametros
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
            for (var i = 0; i < resultado.length; i++)
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
        var fecha = document.getElementById("fechaNG").value;
        var empresa = document.getElementById("empresaNG").value;
        var concepto = $('select[name=conceptoNG]').val();
        var valortotal = document.getElementById("valortNG").value;
        var fuente = $('select[name=fuenteNG]').val();
        var idsoporte = document.getElementById("idsoporteNG").value;
        var soporte = null;
        $.post("ControladoraGestionGastos", {
            operacion: "nuevoGasto",
            fecha: fecha,
            empresa: empresa,
            concepto: concepto,
            valortotal: valortotal,
            fuente: fuente,
            idsoporte: idsoporte,
            soporte: soporte
        }, function (data) {
            var resultado = data;
            alert(resultado);
            leerGastos();
        });
    }
    function modificarGasto()
    {
        //Aqui se crean variables y captura informacion
        //Aqui se crean variables y captura informacion
        var identificador = document.getElementById("idOMG").value;
        var fecha = document.getElementById("fechaMG").value;
        var empresa = document.getElementById("empresaMG").value;
        var concepto = $('select[name=conceptoMG]').val();
        var valortotal = document.getElementById("valortMG").value;
        var fuente = $('select[name=fuenteMG]').val();
        var idsoporte = document.getElementById("idsoporteMG").value;
        var soporte = null;
        $.post("ControladoraGestionGastos", {
            //Aqui van los parametros
            operacion: "modificarGasto",
            identificador: identificador,
            fecha: fecha,
            empresa: empresa,
            concepto: concepto,
            valortotal: valortotal,
            fuente: fuente,
            idsoporte: idsoporte,
            soporte: soporte
        }, function (data) {
            var resultado = data;
            alert(resultado);
            leerGastos()();
        }).fail(function ()
        {
            alert("error en la operacion modificarGasto");
        });
    }

    function eliminarGasto()
    {
        var identificador = document.getElementById("idOEG").value;
        $.post("ControladoraGestionGastos", {
            operacion: "eliminarGasto",
            identificador: identificador
        }, function (data) {
            var resultado = data;
            alert(resultado);
            leerGastos();
        });
    }

    function buscarMG()
    {
        //Aqui se crean variables y captura informacion

        var identificador = document.getElementById("idOMG").value;
        $.post("ControladoraGestionGastos", {
            operacion: "buscarGasto",
            identificador: identificador
        }, function (data) {
            var resultado = data;
            document.getElementById("fechaMG").value = resultado.fecha;
            document.getElementById("empresaMG").value = resultado.empresa;
            leerConceptosModificar(resultado.concepto.identificador);
            document.getElementById("valortMG").value = resultado.valortotal;
            leerFuentesModificar(resultado.fuente.identificador);

        }).fail(function ()
        {
            alert("error en la operacion");
        });
    }
    function buscarEG()
    {
        //Aqui se crean variables y captura informacion
        var identificador = document.getElementById("idOEG").value;
        $.post("ControladoraGestionGastos", {
            //Aqui van los parametros
            operacion: "buscarGasto",
            identificador: identificador
        }, function (data) {
            var resultado = data;
            var resultado = data;
            document.getElementById("fechaEG").value = resultado.fecha;
            document.getElementById("empresaEG").value = resultado.empresa;
            document.getElementById("conceptoEG").value = resultado.concepto.nombre;
            document.getElementById("valortEG").value = resultado.valortotal;
            document.getElementById("fuenteEG").value = resultado.fuente.nombre;
        });
    }

    function leerConceptosModificar(seleccionado)
    {
        $.post("ControladoraGestionGastos", {
            operacion: "leerConceptosGasto"
        }, function (data) {
            var resultado = data;
            var select = document.getElementById("conceptoMG");
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
        $.post("ControladoraGestionGastos", {
            operacion: "leerFuentes"
        }, function (data) {
            var resultado = data;
            var select = document.getElementById("fuenteMG");
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

    function leerConceptos()
    {
        $.post("ControladoraGestionGastos", {
            operacion: "leerConceptosGasto"
        }, function (data) {
            var resultado = data;
            var select = document.getElementById("conceptoNG");
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

    function leerFuentes()
    {
        $.post("ControladoraGestionGastos", {
            operacion: "leerFuentes"
        }, function (data) {
            var resultado = data;
            var select = document.getElementById("fuenteNG");
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
});

