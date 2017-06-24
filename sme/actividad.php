<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js" lang="">
<!--<![endif]-->

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>Actividades</title>
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <link rel="stylesheet" href="resources/css/bootstrap.min.css">
   <link rel="stylesheet" href="resources/css/bootstrap-theme.min.css">
  <link rel="stylesheet" href="resources/css/main.css">
  <link rel="stylesheet" href="resources/css/notify.min.css">
  <link rel="stylesheet" href="resources/css/font-awesome.min.css">
  <link rel="stylesheet" href="resources/css/jquery.zzconfirm.min.css">
  <link rel="stylesheet" href="resources/css/bootstrap-datetimepicker.min.css">
  <link rel="stylesheet" href="resources/css/bootstrap-datetimepicker-standalone.css">

  <style media="screen">
    .navbar {
      border-radius: 0;
    }
  </style>
  <script src="resources/js/vendor/modernizr-2.8.3.min.js"></script>
</head>

<body>
  <!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->
<!--menu  -->
<?php include_once 'template/main-menu.php';?>
<!-- /menu -->

<!-- contenedor -->
<div class="container">
  <!-- nuevo registro -->
  <div class="row" style="padding: 1em;">
    <button type="button" class="btn btn-warning"  id="nuevaActividad">Nuevo Registro</button>
    <!-- <input type="button" value="AGREGAR NUEVO REGISTRO" id="nuevaActividad" class="btn btn-primary"/> -->
    <button type="button" class="btn btn-warning" onclick="javascript:window.print()" id="btnImprimirActividades">Imprimir Actividades</button>
  </div>
  <!-- /nuevo registro -->
  <!-- listado -->
  <div style="text-align: center;">
<<<<<<< HEAD
    <table class="table table-bordered table-hover table-condensed">
      <thead style="background:#419641; color:#fff; text-align:center;">
        <tr>
=======
    <table class="table table-striped table-responsive table-bordered table-condensed table-hover">
      <thead >
        <tr class="warning">
          <th style="text-align:center;">Cod</th>
>>>>>>> origin/master
          <th style="text-align:center;">Grupo Academico</th>
          <th style="text-align:center;">Profesor</th>
          <th style="text-align:center;">Actividad</th>
          <th style="text-align:center;">Detalle</th>
          <th style="text-align:center;">Curso</th>
          <th style="text-align:center;">Fecha</th>
          <th style="text-align:center;">Hora Inicio</th>
          <th style="text-align:center;">Hora Fin</th>
          <th style="text-align:center;" colspan="2">Acciones</th>
        </tr>
      </thead>
      <tbody id="tblActividad">

      </tbody>
    </table>

  </div>
  <!-- /listado -->
</div>
<!-- /contenedor -->

<!-- footer -->
<?php include_once 'template/main-footer.php';?>
<!-- /fotter -->


<!-- Modal de Registro -->
<div class="modal fade" id="modalActividad" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          <h4 class="modal-title" id="myModalLabel"><b>Datos de Actividad</b></h4>
        </div>
        <form class=""  method="post">
        <input type="hidden" id="id">
        <div class="modal-body" id="datosAqui">
          <div class="modal-body">

            <div class="form-group">
              <select class="form-control" id="codGrupoAcademico">
              </select>
            </div>

            <div class="form-group">
                <select class="form-control" id="idCurso">
                </select>
              </div>

              <div class="form-group">
                <select class="form-control" id="idEmpleado">
                </select>
              </div>

              <div class="form-group">
                <input type="text" class="form-control" id="nomActividad" placeholder="Actividad" required="true">
              </div>

              <div class="form-group">
                <textarea class="form-control" rows="3" id="descrActividad" placeholder="Descripcion de actividad" required="true"></textarea>
              </div>

              <div class="form-group">
                  <div class='input-group date' id='dtfechaRealizacion'>
                      <input type='text' id="fechaRealizacion" class="form-control" placeholder="Fecha de realizacion"/>
                      <span class="input-group-addon">
                            <span class="glyphicon glyphicon-calendar"></span>
                      </span>
                  </div>
              </div>
              <div class="form-group grupo-fecha">
                <div class="item-fecha">
                  <div class='input-group date' id='dthoraInicio'>
                    <input type='text' id="horaInicio" class="form-control" placeholder="Hora inicio" />
                      <span class="input-group-addon">
                          <span class="glyphicon glyphicon-time"></span>
                      </span>
                </div>
                </div>
                <div class="item-fecha">
                  <div class='input-group date' id='dthoraFin'>
                    <input type='text' id="horaFin" class="form-control" placeholder="Hora fin"/>
                      <span class="input-group-addon">
                          <span class="glyphicon glyphicon-time"></span>
                      </span>
                </div>
                </div>

              </div>
          </div>
          <div class="modal-footer">
            <!-- <input type="button" class="btn btn-primary btn-block " id="guardarActividad" value="Registrar"> -->
            <button type="button" class="btn btn-warning btn-block"  id="guardarActividad">Registrar</button>
          </div>
        </div>
        </form>

      </div>
    </div>
  </div>
<!-- /Modal de Registro -->



  <script src="resources/js/vendor/jquery-1.11.2.min.js"></script>
  <script src="resources/js/vendor/bootstrap.min.js"></script>
  <script src="resources/js/vendor/moment.min.js"></script>
  <script src="resources/js/vendor/bootstrap-datetimepicker.min.js"></script>
  <script src="resources/js/main.js"></script>
  <script src="resources/js/vendor/notify.min.js"></script>
  <script src="resources/js/vendor/jquery.zzconfirm.js"></script>
  <script src="app/util/service_manager.js"></script>
  <script src="app/util/message.js"></script>
  <script src="app/model/actividad_model.js"></script>
  <script src="app/controller/actividad_controller.js"></script>

  <script type="text/javascript">
      $(function () {
          $('#dtfechaRealizacion').datetimepicker({
            format: 'DD-MM-YYYY'
          });

          $('#dthoraInicio').datetimepicker({
                    format: 'LT'
                });
          $('#dthoraFin').datetimepicker({
                          format: 'LT'
                      });
      });
  </script>
</body>

</html>
