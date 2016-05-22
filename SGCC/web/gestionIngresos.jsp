<%-- 
    Document   : gestionIngresos
    Created on : 18/03/2016, 09:06:35 AM
    Author     : Jorge Alejandro, Jhonny Lenadro Melo, Samael Cardona, Juan David
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="intermedios/bootstrap.min.css">
        <link type="text/css" rel="stylesheet" href="intermedios/carousel.css">
        <link type="text/css" rel="stylesheet" href="intermedios/ie10-viewport-bug-workaround.css">
        <link type="text/css" rel="stylesheet" href="intermedios/dashboard.css">
        <script type="text/javascript" src="intermedios/jquery.min.js"></script>
        <script type="text/javascript" src="intermedios/bootstrap.min.js"></script>
        <script type="text/javascript" src="intermedios/holder.min.js"></script>
        <script type="text/javascript" src="intermedios/ie-emulation-modes-warning.js"></script>
        <script type="text/javascript" src="intermedios/ie10-viewport-bug-workaround.js"></script>
        <script type="text/javascript" src="intermediospropios/jsGestionIngresos.js"></script>
        <title>Gestion de ingresos</title>
        
    </head>
    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="principal.jsp">SGCC</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#" id="nombreusuario">Melin pro</a></li>
                        <li><a href="#">Opciones</a></li>
                        <li><a href="#">Cerrar Sesion</a></li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-3 col-md-2 sidebar">
                    <ul class="nav nav-sidebar">
                        <li><a href="principal.jsp">Resumen <span class="sr-only">(current)</span></a></li>
                        <li class="active"><a href="gestionIngresos.jsp">Ingresos</a></li>
                        <li><a href="gestionGastos.jsp">Gastos</a></li>
                    </ul>
                    <ul class="nav nav-sidebar" id="menuADM">
                        <li><a href="administracionEmpleados.jsp">Empleados</a></li>
                        <li><a href="gestionNomina.jsp">Nomina</a></li>
                        <li><a href="gestionInfomes.jsp">Informes</a></li>
                        <!--<li><a href="">Nav item again</a></li>
                        <li><a href="">One more nav</a></li>
                        <li><a href="">Another nav item</a></li>
                        <li><a href="">More navigation</a></li>-->
                    </ul>
                    <!--<ul class="nav nav-sidebar">
                        <li><a href="">Nav item again</a></li>
                        <li><a href="">One more nav</a></li>
                        <li><a href="">Another nav item</a></li>
                    </ul>-->
                </div>
                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                    <h1 class="page-header">Gestion de Ingresos</h1>

                    <a class="btn btn-default" href="#" role="button" data-toggle="modal" data-target="#NIModal">Nuevo Ingreso »</a>
                    <a class="btn btn-default" href="#" role="button" data-toggle="modal" data-target="#MIModal">Modificar Ingreso »</a>
                    <a class="btn btn-default" href="#" role="button" data-toggle="modal" data-target="#EIModal">Eliminar Ingreso »</a>
                    <br>
             
                    <!-- Modal INSERTAR -->
                    <div class="modal fade" id="NIModal" tabindex="-1" role="dialog" aria-labelledby="ImyModalLabel">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                    <h4 class="modal-title" id="ImyModalLabel">CREAR NUEVO INGRESO</h4>
                                </div>
                                <div class="modal-body">
                                    <h5>Fecha:</h5>
                                    <input type="date" class="form-control" id="fechaNI">
                                    <br>
                                    <h5>Empresa:</h5>
                                    <input type="text" class="form-control" id="empresaNI">
                                    <br>
                                    <h5>Concepto:</h5>
                                    <select name="conceptoNI" id="conceptoNI" class="form-control">
                                        <option value="0" selected="">Seleccione una opcion</option>
                                    </select>
                                    <br>
                                    <h5>Cantidad:</h5>
                                    <input type="number" min="1" class="form-control" id="cantidadNI">
                                    <br>
                                    <h5>Valor Unitario</h5>
                                    <input type="number" min="50" class="form-control" id="valoruNI">
                                    <br>
                                    <h5>Valor Total</h5>
                                    <input type="number" min="50" class="form-control" id="valortNI">
                                    <br>
                                    <h5>Fuente</h5>
                                    <select name="fuenteNI" id="fuenteNI" class="form-control">
                                        <option value="0" selected="">Seleccione una fuente</option>
                                    </select>
                                    <br>
                                    <h5>Id del soporte</h5>
                                    <input type="text" class="form-control" id="idsoporteNI">
                                    <br>
                                    <h5>Soporte</h5>
                                    <input type="file" class="form-control" id="soporteNI">
                                    <br>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                                    <button type="button" class="btn btn-primary" id="nuevoIngreso">Guardar</button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Modal MODIFICAR -->
                    <div class="modal fade" id="MIModal" tabindex="-1" role="dialog" aria-labelledby="MmyModalLabel">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                    <h4 class="modal-title" id="MmyModalLabel">MODIFICAR INGRESO</h4>
                                </div>
                                <div class="modal-body">
                                    <h5>Identificador</h5>
                                    <input type="number" class="form-control" id="idOMI">
                                    <br>
                                    <button class="btn btn-success" id="buscarMI">Buscar</button>
                                    <br>
                                    <h5>Fecha:</h5>
                                    <input type="text" class="form-control" id="fechaMI">
                                    <br>
                                    <h5>Empresa:</h5>
                                    <input type="text" class="form-control" id="empresaMI">
                                    <br>
                                    <h5>Concepto:</h5>
                                    <select name="conceptoMI" class="form-control" id="conceptoMI">
                                        <option value="0">Seleccione una opcion</option>
                                    </select>
                                    <br>
                                    <h5>Valor Unitario:</h5>
                                    <input type="number" min="50" class="form-control" id="valoruMI">
                                    <br>
                                    <h5>Cantidad:</h5>
                                    <input type="text" min="1" class="form-control" id="cantidadMI">
                                    <br>
                                    <h5>Valor total:</h5>
                                    <input type="number" min="50" class="form-control" id="valortMI">
                                    <br>
                                    <h5>Fuente</h5>
                                    <select name="fuenteMI" class="form-control" id="fuenteMI">
                                        <option value="0">Seleccione una fuente</option>
                                    </select>
                                    <br>
                                    <h5>Identificador del soporte</h5>
                                    <input type="text" class="form-control" id="idsoporteMI">
                                    <br>
                                    <h5>Soporte:</h5>
                                    <input type="file" class="form-control" id="soporteMI">
                                    <br>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                                    <button type="button" class="btn btn-primary" id="modificarIngreso">Guardar</button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Modal ELIMINAR -->
                    <div class="modal fade" id="EIModal" tabindex="-1" role="dialog" aria-labelledby="EmyModalLabel">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                    <h4 class="modal-title" id="EmyModalLabel">ELIMINAR INGRESO</h4>
                                </div>
                                <div class="modal-body">
                                    <h5>Identificador</h5>
                                    <input type="number" class="form-control" id="idOEI">
                                    <br>
                                    <button class="btn btn-success" id="buscarEI">Buscar</button>
                                    <br>
                                    <h5>Fecha:</h5>
                                    <input type="text" class="form-control" id="fechaEI" disabled="">
                                    <br>
                                    <h5>Empresa:</h5>
                                    <input type="text" class="form-control" id="empresaEI" disabled="">
                                    <br>
                                    <h5>Concepto:</h5>
                                    <input type="text" class="form-control" id="conceptoEI" disabled="">
                                    <br>
                                    <h5>Valor Unitario:</h5>
                                    <input type="text" class="form-control" id="valoruEI" disabled="">
                                    <br>
                                    <h5>Cantidad:</h5>
                                    <input type="text" class="form-control" id="cantidadEI" disabled="">
                                    <br>
                                    <h5>Valor Total:</h5>
                                    <input type="text" class="form-control" id="valortEI" disabled="">
                                    <br>
                                    <h5>Fuente:</h5>
                                    <input type="text" class="form-control" id="fuenteEI" disabled="">
                                    <br>
                                    <h5>Soporte para eliminación</h5>
                                    <input type="file" class="form-control" id="soporteEI" disabled="">
                                    <br>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                                    <button type="button" class="btn btn-primary" id="eliminarIngreso">Eliminar</button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <h2 class="sub-header">Tabla de ingresos</h2>
                    <div class="table-responsive">
                        <table class="table table-striped" id="leerIngresos">
                            <thead>
                                <tr>
                                    <th>Identificador</th>
                                    <th>Fecha</th>
                                    <th>Empresa</th>
                                    <th>Concepto</th>
                                    <th>Cantidad</th>
                                    <th>Valor Unitario</th>
                                    <th>Valor Total</th>
                                    <th>Fuente</th>
                                </tr>
                            </thead>
                            <tbody id="tabla">
                                
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
