<%-- 
    Document   : administracionUsuarios
    Created on : 18/03/2016, 09:22:54 AM
    Author     : Jorge Alejandro
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
        <script type="text/javascript" src="intermediospropios/jsAdministracionEmpleados.js"></script>
        <title>Administracion de usuarios</title>
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
                        <li><a href="#" id="nombreusuario"></a></li>
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
                        <li><a href="gestionIngresos.jsp">Ingresos</a></li>
                        <li class="active"><a href="gestionGastos.jsp">Gastos</a></li>
                        <li><a href="gestionNomina.jsp">Nomina</a></li>
                        <li><a href="gestionInfomes.jsp">Informes</a></li>
                    </ul>
                    <ul class="nav nav-sidebar">
                        <li><a href="administracionEmpleados.jsp">Empleados</a></li>
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
                    <h1 class="page-header">Administracion de usuarios</h1>

                    <a class="btn btn-default" href="#" role="button" data-toggle="modal" data-target="#NEModal">Nuevo Empleado »</a>
                    <a class="btn btn-default" href="#" role="button" data-toggle="modal" data-target="#MEModal">Modificar Empleado »</a>
                    <a class="btn btn-default" href="#" role="button" data-toggle="modal" data-target="#EEModal">Eliminar Empleado »</a>
                    <br>

                    <!-- Modal INSERTAR -->
                    <div class="modal fade" id="NEModal" tabindex="-1" role="dialog" aria-labelledby="ImyModalLabel">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                    <h4 class="modal-title" id="ImyModalLabel">CREAR NUEVO EMPLEADO</h4>
                                </div>
                                <div class="modal-body">
                                    <h5>Nombre</h5>
                                    <input type="text" class="form-control" id="nombreNE" required="">
                                    <br>     
                                    <h5>Cedula:</h5>
                                    <input type="text" class="form-control" id="cedulaNE" required="">
                                    <br>
                                    <h5>Correo:</h5>
                                    <input type="email" class="form-control" id="correoNE" required="">
                                    <br>
                                    <h5>Cargo:</h5>
                                    <input type="text" class="form-control" id="cargoNE">
                                    <br>
                                    <h5>Salario Basico:</h5>
                                    <input type="number" min="100" class="form-control" id="salarioNE" required="">
                                    <br>
                                    <h5>Contraseña:</h5>
                                    <input type="password" class="form-control" id="contrasenaNE" required="">
                                    <br>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                                    <button type="button" class="btn btn-primary" id="nuevoEmpleado">Guardar</button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Modal MODIFICAR -->
                    <div class="modal fade" id="MEModal" tabindex="-1" role="dialog" aria-labelledby="MmyModalLabel">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                    <h4 class="modal-title" id="MmyModalLabel">MODIFICAR EMPLEADO</h4>
                                </div>
                                <div class="modal-body">
                                    <h5>Cedula:</h5>
                                    <select name="cedulaME" id="cedulaME" class="form-control">
                                        <option value="0" selected="">Seleccione una opcion</option>
                                    </select>
                                    <br>
                                    <button class="btn btn-success" id="buscarME">Buscar</button>
                                    <br>
                                    <h5>Nombre:</h5>
                                    <input type="text" class="form-control" id="nombreME" required="">
                                    <br>                                  
                                    <h5>Correo:</h5>
                                    <input type="email" class="form-control" id="correoME" required="">
                                    <br>
                                    <h5>Cargo:</h5>
                                    <input type="text" class="form-control" id="cargoME">
                                    <br>
                                    <h5>Salario Basico:</h5>
                                    <input type="number" min="100" class="form-control" id="salarioME">
                                    <br>
                                    <h5>Contraseña:</h5>
                                    <input type="password" class="form-control" id="contrasenaME">
                                    <br>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                                    <button type="button" class="btn btn-primary" id="modificarEmpleado">Guardar</button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Modal ELIMINAR -->
                    <div class="modal fade" id="EEModal" tabindex="-1" role="dialog" aria-labelledby="EmyModalLabel">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                    <h4 class="modal-title" id="EmyModalLabel">ELIMINAR EMPLEADO</h4>
                                </div>
                                <div class="modal-body">
                                    <h5>Cedula</h5>
                                    <select name="cedulaEE" id="cedulaEE" class="form-control">
                                        <option value="0" selected="">Seleccione una opcion</option>
                                    </select>
                                    <br>
                                    <button class="btn btn-success" id="buscarEE">Buscar</button>
                                    <br>
                                    <h5>Nombre:</h5>
                                    <input type="text" class="form-control" id="nombreEE" disabled="">
                                    <br>
                                    <h5>Correo:</h5>
                                    <input type="text" class="form-control" id="correoEE" disabled="">
                                    <br>
                                    <h5>Cargo:</h5>
                                    <input type="text" class="form-control" id="cargoEE" disabled="">
                                    <br>
                                    <h5>Salario Basico:</h5>
                                    <input type="text" class="form-control" id="salarioEE" disabled="">
                                    <br>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                                    <button type="button" class="btn btn-primary" id="eliminarEmpleado">Eliminar</button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <h2 class="sub-header">Tabla de Empleados</h2>
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>Identificador</th>
                                    <th>Nombre</th>
                                    <th>Cedula</th>
                                    <th>Correo</th>
                                    <th>Cargo</th>
                                    <th>Salario Basico</th>
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
