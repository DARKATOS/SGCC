<%-- 
    Document   : gestionNomina
    Created on : 14/05/2016, 10:36:38 AM
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
        <script type="text/javascript" src="intermediospropios/jsGestionNomina.js"></script>
        <title>Gestion de Nomina</title>
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
                    <h1 class="page-header">Gestion de Nomina</h1>

                    <a class="btn btn-default" href="#" role="button" data-toggle="modal" data-target="#NLModal">Nueva Liquidacion»</a>
                    <a class="btn btn-default" href="#" role="button" data-toggle="modal" data-target="#MLModal">Modificar Liquidacion »</a>
                    <a class="btn btn-default" href="#" role="button" data-toggle="modal" data-target="#ELModal">Eliminar Liquidacion »</a>
                    <br>

                    <!-- Modal INSERTAR -->
                    <div class="modal fade" id="NLModal" tabindex="-1" role="dialog" aria-labelledby="ImyModalLabel">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                    <h4 class="modal-title" id="ImyModalLabel">CREAR NUEVA LIQUIDACION</h4>
                                </div>
                                <div class="modal-body">
                                    <h5>Nombre del empleado:</h5>
                                    <select name="empleadoNL" id="empleadoNL" class="form-control">
                                        <option value="0" selected="">Seleccione un nombre de empleado</option>
                                    </select>
                                    <br>
                                    <h5>fecha:</h5>
                                    <input type="date" class="form-control" id="fechaNL">
                                    <br>
                                    <h5>Salario Basico:</h5>
                                    <input type="number" min="0" class="form-control" id="salarioBasicoNL">
                                    <br> 
                                    <h5>Comisiones:</h5>
                                    <input type="number" min="0" class="form-control" id="comisionesNL">
                                    <br>
                                    <h5>Auxilio de Transporte:</h5>
                                    <input type="number" min="0" class="form-control" id="auxilioTransporteNL" value="77700" disabled="">
                                    <br>
                                    <h5>Valor Hora Extra:</h5>
                                    <input type="number" min="0" class="form-control" id="valorHoraExtraNL">
                                    <br>
                                    <h5>Numero de Horas Extra:</h5>
                                    <input type="number" min="0" class="form-control" id="numeroHorasExtraNL">
                                    <br>
                                    <h5>Valor Total Horas Extra:</h5>
                                    <input type="number" min="0" class="form-control" id="totalHorasExtraNL">
                                    <br>
                                    <h5>Valor Salud:</h5>
                                    <input type="number" min="0" class="form-control" id="saludNL">
                                    <br>
                                    <h5>Valor Pension:</h5>
                                    <input type="number" min="0" class="form-control" id="pensionNL">
                                    <br>
                                    <h5>Salario Neto:</h5>
                                    <input type="number" min="0" class="form-control" id="salarioNetoNL">
                                    <br>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                                    <button type="button" class="btn btn-primary" id="nuevaLiquidacion">Guardar</button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Modal MODIFICAR -->
                    <div class="modal fade" id="MLModal" tabindex="-1" role="dialog" aria-labelledby="MmyModalLabel">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                    <h4 class="modal-title" id="MmyModalLabel">Modificar Liquidacion</h4>
                                </div>
                                <div class="modal-body">
                                    <h5>Identificador</h5>
                                    <select name="liquidacionML" id="liquidacionML" class="form-control">
                                        <option value="0" selected="">Seleccione una liquidacion</option>
                                    </select>
                                    <br>
                                    <button class="btn btn-success" id="buscarML">Buscar</button>
                                    <br>
                                    <h5>Nombre del empleado:</h5>
                                    <input type="text" class="form-control" id="nombreML" disabled="">
                                    <br>
                                    <h5>fecha:</h5>
                                    <input type="date" class="form-control" id="fechaML">
                                    <br>
                                    <h5>Salario Basico:</h5>
                                    <input type="number" min="0" class="form-control" id="salarioBasicoML" disabled="">
                                    <br>
                                    <h5>Comisiones:</h5>
                                    <input type="number" class="form-control" id="comisionesML">
                                    <br>
                                    <h5>Auxilio de Transporte:</h5>
                                    <input type="number" min="0" class="form-control" id="auxilioTransporteML" value="77700" disabled="">
                                    <br>
                                    <h5>Valor Hora Extra:</h5>
                                    <input type="number" min="0" class="form-control" id="valorHoraExtraML">
                                    <br>
                                    <h5>Numero de Horas Extra:</h5>
                                    <input type="number" min="0" class="form-control" id="numeroHorasExtraML">
                                    <br>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                                    <button type="button" class="btn btn-primary" id="modificarLiquidacion">Guardar</button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Modal ELIMINAR -->
                    <div class="modal fade" id="ELModal" tabindex="-1" role="dialog" aria-labelledby="EmyModalLabel">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                    <h4 class="modal-title" id="EmyModalLabel">ELIMINAR LIQUIDACIÓN</h4>
                                </div>
                                <div class="modal-body">
                                    <h5>Identificador</h5>
                                    <select name="liquidacionEL" id="liquidacionEL" class="form-control">
                                        <option value="0" selected="">Seleccione una liquidacion</option>
                                    </select>
                                    <br>
                                    <button class="btn btn-success" id="buscarEL">Buscar</button>
                                    <br>
                                    <h5>Nombre del empleado:</h5>
                                    <input type="text" class="form-control" id="nombreEL" disabled="">
                                    <br>
                                    <h5>fecha:</h5>
                                    <input type="date" class="form-control" id="fechaEL" disabled="">
                                    <br>                                  
                                    <h5>Comisiones:</h5>
                                    <input type="text" class="form-control" id="comisionesEL" disabled="">
                                    <br>
                                    <h5>Auxilio de Transporte:</h5>
                                    <input type="number" min="0" class="form-control" id="auxilioTransporteEL" disabled="">
                                    <br>
                                    <h5>Valor Hora Extra:</h5>
                                    <input type="number" min="0" class="form-control" id="valorHoraExtraEL" disabled="">
                                    <br>
                                    <h5>Numero de Horas Extra:</h5>
                                    <input type="number" min="0" class="form-control" id="numeroHorasExtraEL" disabled="">
                                    <br>
                                    <h5>Valort Total Horas Extra:</h5>
                                    <input type="number" min="0" class="form-control" id="totalHorasExtraEL" disabled="">
                                    <br>
                                    <h5>Valor salud:</h5>
                                    <input type="number" min="0" class="form-control" id="saludEL" disabled="">
                                    <br>
                                    <h5>Valor Pension:</h5>
                                    <input type="number" min="0" class="form-control" id="pensionEL" disabled="">
                                    <br>
                                    <h5>Salario Neto:</h5>
                                    <input type="number" min="0" class="form-control" id="salarioNetoEL" disabled="">
                                    <br>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                                    <button type="button" class="btn btn-primary" id="eliminarLiquidacion">Eliminar</button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <h2 class="sub-header">Tabla de Liquidacion</h2>
                    <div class="table-responsive">
                        <table class="table table-striped" id="leerIngresos">
                            <thead>
                                <tr>
                                    <th>Identificador</th>
                                    <th>Fecha</th>
                                    <th>Comisiones</th>
                                    <th>Auxilio Transporte</th>
                                    <th>Valor Hora Extra</th>
                                    <th>Numero Horas Extra</th>
                                    <th>Valor Total Horas Extra</th>
                                    <th>Valor Salud</th>
                                    <th>Valor pension</th>
                                    <th>Salario Neto</th>
                                    <th>Empleado</th>
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
