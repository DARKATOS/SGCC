/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function ()
{
    $("#leerIngresos").on("load", leerIngresos);
    $("#nuevoIngreso").on("click", nuevoIngreso);
    $("#modificarIngreso").on("click", modificarIngreso);
    $("#buscarMI").on("click", buscarMI);
    $("#buscarEI").on("click", buscarEI);
    $("#eliminarIngreso").on("click", eliminarIngreso);
    
    function leerIngresos()
    {
        //Aqui se crean variables y captura informacion
        $.post("Controladora", {
            oper: "leerIngresos"
        }, function (data) {
            var resultado = data;
            for (var i=0; i<resultado.length; i++)
            {
                
            }
            
        });
    }
    function nuevoIngreso()
    {
        //Aqui se crean variables y captura informacion
        $.post("Controladora", {
            //Aqui van los parametros
        }, function (data) {
            var resultado = data;
            
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
        $.post("Controladora", {
            //Aqui van los parametros
        }, function (data) {
            var resultado = data;
            
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
    
});
