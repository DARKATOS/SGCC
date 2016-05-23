/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function ()
{
    $("#iniciarSesion").on("click", iniciarSesion);
    function iniciarSesion()
    {
        var cedula = document.getElementById("cedula").value;
        var contrasena = document.getElementById("contrasena").value;
        $.post("Controladora", {
            operacion: "iniciarSesion",
            cedula: cedula,
            contrasena: contrasena
        }, function (data) {
            var resultado=data;
            alert(data);
            if (resultado=="1")
            {  
                alert("Ha iniciado sesion correctamente");
                window.location="gestionIngresos.jsp";
            }
            else
            {
                alert("Error al iniciar sesion");
                location.reload(true);
            }
            
        }).fail(function ()
        {
            alert("Error en la operacion");
        });
    }
});
