/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function ()
{
    $("#nuevoEmpleado").on("click", nuevoEmpleado);
    $("#modificarEmpleado").on("click", modificarEmpleado);
    $("#eliminarEmpleado").on("click", eliminarEmpleado);
    $("#buscarME").on("click", buscarME);
    $("#buscarEE").on("click", buscarEE);

    $(document).ready(function () {
        leerEmpleados();
        leerCedulaModificar();
        leerCedulaEliminar();
    });

    function leerEmpleados()
    {
        //Aqui se crean variables y captura informacion
        $.post("Controladora", {
            operacion: "leerEmpleados"
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
                var texto2 = document.createTextNode(resultado[i].nombre);
                td2.appendChild(texto2);
                var td3 = document.createElement("td");
                var texto3 = document.createTextNode(resultado[i].cedula);
                td3.appendChild(texto3);
                var td4 = document.createElement("td");
                var texto4 = document.createTextNode(resultado[i].correo);
                td4.appendChild(texto4);
                var td5 = document.createElement("td");
                var texto5 = document.createTextNode(resultado[i].cargo);
                td5.appendChild(texto5);
                var td6 = document.createElement("td");
                var texto6 = document.createTextNode(resultado[i].salarioBasico);
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
        }).fail(function ()
        {
            alert("error en la operacion de leer empleados");
        });
    }

    function nuevoEmpleado()
    {
        var nombre = document.getElementById("nombreNE").value;
        var cedula = document.getElementById("cedulaNE").value;
        var correo = document.getElementById("correoNE").value;
        var cargo = document.getElementById("cargoNE").value;
        var salarioBasico = document.getElementById("salarioNE").value;
        var contrasena = document.getElementById("contrasenaNE").value;
        $.post("Controladora", {
            operacion: "nuevoEmpleado",
            nombre: nombre,
            cedula: cedula,
            correo: correo,
            cargo: cargo,
            salarioBasico: salarioBasico,
            contrasena: contrasena
        }, function (data) {
            var resultado = data;
            alert(resultado);
//            leerUsuarios();
            location.reload(true);
        }).fail(function ()
        {
            alert("error en la operacion de ingresar un nuevo empleado");
        });
    }

    function modificarEmpleado()
    {
        //Aqui se crean variables y captura informacion
        var cedula = $('select[name=cedulaME]').val();
        var nombre = document.getElementById("nombreME").value;
        var correo = document.getElementById("correoME").value;
        var cargo = document.getElementById("cargoME").value;
        var salario = document.getElementById("salarioME").value;
        var contrasena = document.getElementById("contrasenaME").value;
        $.post("Controladora", {
            //Aqui van los parametros
            operacion: "modificarEmpleado",
            cedula: cedula,
            nombre: nombre,
            correo: correo,
            cargo: cargo,
            salario: salario,
            contrasena: contrasena
        }, function (data) {
            var resultado = data;
            alert(resultado);
            leerUsuarios();
        }).fail(function ()
        {
            alert("error en la operacion modificar un empleado");
        });
    }

    function eliminarEmpleado()
    {
        var cedula = $('select[name=cedulaEE]').val();
        $.post("Controladora", {
            operacion: "eliminarEmpleado",
            cedula: cedula
        }, function (data) {
            var resultado = data;
            alert(resultado);
            location.reload(true);
        });
    }

    function leerCedulaModificar()
    {
        $.post("Controladora", {
            operacion: "leerCedulaModificar"
        }, function (data) {
            var resultado = data;
            var select = document.getElementById("cedulaME");
            for (var i = 0; i < resultado.length; i++)
            {
                var option = document.createElement("option");
                option.setAttribute("value", resultado[i].cedula);
                option.innerHTML = resultado[i].cedula + " - " + resultado[i].nombre;
                select.appendChild(option);
            }
        }).fail(function ()
        {
            alert("Error en la operacion de leer las cedulas para modificar un empleado");
        });
    }
    function leerCedulaEliminar()
    {
        $.post("Controladora", {
            operacion: "leerCedulaEliminar"
        }, function (data) {
            var resultado = data;
            var select = document.getElementById("cedulaEE");
            for (var i = 0; i < resultado.length; i++)
            {
                var option = document.createElement("option");
                option.setAttribute("value", resultado[i].cedula);
                option.innerHTML = resultado[i].cedula + " - " + resultado[i].nombre;
                select.appendChild(option);
            }
        }).fail(function ()
        {
            alert("Error en la operacion de leer las cedulas para eliminacion de empleado");
        });
    }

    function buscarMU()
    {
        var cedula = $('select[name=cedulaMU]').val();
        $.post("Controladora", {
            operacion: "buscarUsuarioModificar",
            cedula: cedula
        }, function (data) {
            var resultado = data;
            document.getElementById("nombreMU").value = resultado.nombre;
            document.getElementById("correoMU").value = resultado.correo;
            document.getElementById("cargoMU").value = resultado.cargo;
            document.getElementById("salarioMU").value = resultado.salario_basico;
            document.getElementById("contrasenaMU").value = resultado.contrasena;

        }).fail(function ()
        {
            alert("error en la operacion de buscar usuario");
        });
    }

    function buscarEU()
    {
        var cedula = $('select[name=cedulaMU]').val();
        $.post("Controladora", {
            operacion: "buscarUsuarioModificar",
            cedula: cedula
        }, function (data) {
            var resultado = data;
            document.getElementById("nombreEU").value = resultado.nombre;
            document.getElementById("correoEU").value = resultado.correo;
            document.getElementById("cargoEU").value = resultado.cargo;
            document.getElementById("salarioEU").value = resultado.salario_basico;
            document.getElementById("contrasenaEU").value = resultado.contrasena;

        }).fail(function ()
        {
            alert("error en la operacion de buscar usuario");
        });
    }

});
