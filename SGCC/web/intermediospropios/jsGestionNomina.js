/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function ()
{
    $("#nuevaLiquidacion").on("click", nuevaLiquidacion);
    $("#modificarLiquidacion").on("click", modificarLiquidacion);
    $("#eliminarLiquidacion").on("click", eliminarLiquidacion);
    $("#buscarML").on("click", buscarML);
    $("#buscarEL").on("click", buscarEL);
    
    $("#salarioBasicoNL").on("focus", obtenerSalarioBasico);
    $("#saludNL").on("focus", calcularSalud);
    $("#pensionNL").on("focus", calcularPension);
    $("#totalHorasExtraNL").on("focus", calcularTotalHorasExtra);
    $("#salarioNetoNL").on("focus", calcularSalarioNeto);
    
    $(document).ready(function () {
        leerLiquidaciones();
        leerIdentifidoresModificar();
        leerIdentificadoresEliminar();
    });
    
    function obtenerSalarioBasico()
    {
        var empleado=$('select[name=empleadoNL]').val();
        $.post("ControladoraGestionNomina", {
            operacion: "leerSalarioBasicoCedula",
            empleado: empleado
        }, function (data) {
            var resultado = data;
            document.getElementById("salarioBasicoNL").value=resultado;
        }).fail(function ()
        {
            alert("error en la operacion de ingresar un nuevo empleado");
        });
    }
    
    function calcularSalarioNeto()
    {
        var salarioBasico=document.getElementById("salarioBasicoNL").value;
        var comisiones=document.getElementById("comisionesNL").value
        var auxilioTransporte=77700;
        var totalHorasExtra=document.getElementById("totalHorasExtraNL").value;
        var salud=document.getElementById("saludNL").value;
        var pension=document.getElementById("pensionNL").value;
        var salarioNeto=salarioBasico+comisiones+auxilioTransporte+totalHorasExtra-salud-pension;
        document.getElementById("salarioNetoNL").value=salarioNeto;
    }
    
    function calcularSalud()
    {
        var salarioBasico=document.getElementById("salarioBasicoNL").value;
        var comisiones=document.getElementById("comisionesNL").value;
        var totalHorasExtra=document.getElementById("totalHorasExtraNL").value;
        var salud=(salarioBasico+comisiones+totalHorasExtra)*0.04;
        document.getElementById("saludNL").value=salud;
    }
    
    function calcularPension()
    {
        var salarioBasico=document.getElementById("salarioBasicoNL").value;
        var comisiones=document.getElementById("comisionesNL").value;
        var totalHorasExtra=document.getElementById("totalHorasExtraNL").value;
        var pension=(salarioBasico+comisiones+totalHorasExtra)*0.04;
        document.getElementById("pensionNL").value=pension;
    }
    
    function calcularTotalHorasExtra()
    {
        var valorHoraExtra=document.getElementById("valorHoraExtraNL").value;
        var numeroHorasExtra=document.getElementById("numeroHorasExtraNL").value;
        var totalHorasExtra=valorHoraExtra*numeroHorasExtra;
        document.getElementById("totalHorasExtraNL").value=totalHorasExtra;
    }

    function leerLiquidaciones()
    {
        //Aqui se crean variables y captura informacion
        $.post("ControladoraGestionNomina", {
            operacion: "leerLiquidaciones"
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
                var texto3 = document.createTextNode(resultado[i].comisiones);
                td3.appendChild(texto3);
                var td4 = document.createElement("td");
                var texto4 = document.createTextNode(resultado[i].auxilioTransporte);
                td4.appendChild(texto4);
                var td5 = document.createElement("td");
                var texto5 = document.createTextNode(resultado[i].valorHoraExtra);
                td5.appendChild(texto5);
                var td6 = document.createElement("td");
                var texto6 = document.createTextNode(resultado[i].NumeroHorasExtra);
                td6.appendChild(texto6);
                var td7 = document.createElement("td");
                var texto7 = document.createTextNode(resultado[i].totalHorasExtra);
                td7.appendChild(texto7);
                var td8 = document.createElement("td");
                var texto8 = document.createTextNode(resultado[i].salud);
                td8.appendChild(texto8);
                var td9 = document.createElement("td");
                var texto9 = document.createTextNode(resultado[i].pension);
                td9.appendChild(texto9);
                var td10 = document.createElement("td");
                var texto10 = document.createTextNode(resultado[i].salarioNeto);
                td10.appendChild(texto10);
                var td11 = document.createElement("td");
                var texto11 = document.createTextNode(resultado[i].empleado.nombre);
                td11.appendChild(texto11);
                tr.appendChild(td1);
                tr.appendChild(td2);
                tr.appendChild(td3);
                tr.appendChild(td4);
                tr.appendChild(td5);
                tr.appendChild(td6);
                tr.appendChild(td7);
                tr.appendChild(td8);
                tr.appendChild(td9);
                tr.appendChild(td10);
                tr.appendChild(td11);
                tabla.appendChild(tr);
            }
        }).fail(function ()
        {
            alert("error en la operacion de leer empleados");
        });
    }

    function nuevaLiquidacion()
    {
        var fecha = document.getElementById("fechaNL").value;
        var salarioBasico=document.getElementById("salarioBasicoNL").value;
        var comisiones=document.getElementById("comisionesNL").value;
        var valorHoraExtra = document.getElementById("valorHoraExtraNL").value;
        var numeroHorasExtra = document.getElementById("numeroHorasExtraNL").value;
        var empleado=document.getElementById("empleadoNL").value;
        
        $.post("ControladoraGestionNomina", {
            operacion: "nuevaLiquidacion",
            fecha: fecha,
            salarioBasico: salarioBasico,
            comisiones: comisiones,
            valorHoraExtra: valorHoraExtra,
            numeroHorasExtra: numeroHorasExtra,
            empleado: empleado
        }, function (data) {
            var resultado = data;
            alert(resultado);
            location.reload(true);
        }).fail(function ()
        {
            alert("error en la operacion de ingresar un nuevo empleado");
        });
    }

    function modificarLiquidacion()
    {
        var identificador = $('select[name=liquidacionML]').val();
        var fecha = document.getElementById("fechaML").value;
        var salarioBasico = document.getElementById("salarioBasicoML").value;
        var comisiones=document.getElementById("comisionesML").value;
        var valorHoraExtra = document.getElementById("valorHoraExtraML").value;
        var numeroHorasExtra = document.getElementById("numeroHorasExtraML").value;
        
        $.post("ControladoraGestionNomina", {
            operacion: "modificarLiquidacion",
            identificador: identificador,
            fecha: fecha,
            salarioBasico: salarioBasico,
            comisiones: comisiones,
            valorHoraExtra: valorHoraExtra,
            numeroHorasExtra: numeroHorasExtra
        }, function (data) {
            var resultado = data;
            alert(resultado);
            location.reload(true);
        }).fail(function ()
        {
            alert("error en la operacion de modificar una liquidacion");
        });
    }

    function eliminarLiquidacion()
    {
        var identificador = $('select[name=liquidacionML]').val();
        
        $.post("ControladoraGestionNomina", {
            operacion: "eliminarLiquidacion",
            identificador: identificador,
        }, function (data) {
            var resultado = data;
            alert(resultado);
            location.reload(true);
        }).fail(function ()
        {
            alert("error en la operacion de eliminar una liquidacion");
        });
    }

    //Voy aqui
    function buscarML()
    {
        var identificador = $('select[name=liquidacionML]').val();
        $.post("ControladoraGestionNomina", {
            operacion: "buscarLiquidacionModificar",
            identificador: identificador
        }, function (data) {
            var resultado = data;
            document.getElementById("nombreML").value = resultado.empleado.nombre;
            document.getElementById("fechaML").value = resultado.fecha;
            document.getElementById("comisionesML").value = resultado.comisiones;
            document.getElementById("auxilioTransporteML").value = resultado.auxilioTransporte;
            document.getElementById("valorHoraExtraML").value = resultado.valorHoraExtra;
            document.getElementById("numeroHorasExtraML").value = resultado.numeroHorasExtra;
        }).fail(function ()
        {
            alert("error en la operacion de buscar usuario");
        });
    }
    function buscarEL()
    {
        var identificador = $('select[name=liquidacionEL]').val();
        $.post("ControladoraGestionNomina", {
            operacion: "buscarLiquidacionEliminar",
            identificador: identificador
        }, function (data) {
            var resultado = data;
            document.getElementById("nombreEL").value = resultado.empleado.nombre;
            document.getElementById("fechaEL").value = resultado.fecha;
            document.getElementById("comisionesEL").value = resultado.comisiones;
            document.getElementById("auxilioTransporteEL").value = resultado.auxilioTransporte;
            document.getElementById("valorHoraExtraEL").value = resultado.valorHoraExtra;
            document.getElementById("numeroHorasExtraEL").value = resultado.numeroHorasExtra;
        }).fail(function ()
        {
            alert("error en la operacion de buscar usuario");
        });
    }

    function leerIdentifidoresModificar()
    {
        $.post("ControladoraGestionNomina", {
            operacion: "leerIdentificadoresModificar"
        }, function (data) {
            var resultado = data;
            var select = document.getElementById("liquidacionML");
            for (var i = 0; i < resultado.length; i++)
            {
                var option = document.createElement("option");
                option.setAttribute("value", resultado[i].identificador);
                option.innerHTML = resultado[i].identificador+ " - " +resultado[i].fecha+" - "+resultado[i].empleado.nombre;
                select.appendChild(option);
            }
        }).fail(function ()
        {
            alert("Error en la operacion de leer las cedulas para eliminacion de empleado");
        });
    }

    function leerIdentificadoresEliminar()
    {
        $.post("ControladoraGestionNomina", {
            operacion: "leerIdentificadoresEliminar"
        }, function (data) {
            var resultado = data;
            var select = document.getElementById("liquidacionEL");
            for (var i = 0; i < resultado.length; i++)
            {
                var option = document.createElement("option");
                option.setAttribute("value", resultado[i].identificador);
                option.innerHTML = resultado[i].identificador+ " - " +resultado[i].fecha+" - "+resultado[i].empleado.nombre;
                select.appendChild(option);
            }
        }).fail(function ()
        {
            alert("Error en la operacion de leer los identificadores para eliminar");
        });
    }

});
