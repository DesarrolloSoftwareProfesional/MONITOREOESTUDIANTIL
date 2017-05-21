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
<?php include_once 'template/main-menu.php'; ?>
<!-- /menu -->

<!-- contenedor -->
<div class="container">
  <!-- nuevo registro -->
  <div class="row" style="padding: 1em;">
    <input type="button" value="AGREGAR NUEVO REGISTRO" id="nuevaActividad" class="btn btn-primary"/>
  </div>
  <!-- /nuevo registro -->
  <!-- listado -->
  <div style="text-align: center;">
    <table class="table table-bordered table-hover table-condensed">
      <thead style="background:#419641; color:#fff; text-align:center;">
        <tr>
          <th style="text-align:center;">Cod</th>
          <th style="text-align:center;">Grupo Academico</th>
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
<?php include_once 'template/main-footer.php'; ?>
<!-- /fotter -->


<!-- Modal de Registro -->
<div class="modal fade" id="modalActividad" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          <h4 class="modal-title" id="myModalLabel"><b>Datos del Alumno</b></h4>
        </div>
        <form class=""  method="post">
        <input type="hidden" id="id">
        <div class="modal-body" id="datosAqui">
          <div class="modal-body">

              <div class="form-group">
                <input type="text" class="form-control" id="apPaterno" placeholder="Apellido paterno" required="true">
              </div>

              <div class="form-group">
                <input type="text" class="form-control" id="apMaterno" placeholder="Apellido materno" required="true">
              </div>

              <div class="form-group">
                <input type="text" class="form-control" id="nombres" placeholder="Nombres" required="true">
              </div>

              <div class="form-group">
                <input type="text" class="form-control" id="dni" placeholder="Dni" required="true">
              </div>

              <div class="form-group">
                <input type="date" class="form-control" id="fechaNac" placeholder="Fecha de nacimiento" required="true">
              </div>

              <div class="form-group">
                  <div class='input-group date' id='datetimepicker1'>
                      <input type='text' class="form-control" />
                      <span class="input-group-addon">
                            <span class="glyphicon glyphicon-calendar"></span>
                      </span>
                  </div>
              </div>
              <div class="form-group">
                              <div class='input-group date' id='datetimepicker3'>
                                  <input type='text' class="form-control" />
                                  <span class="input-group-addon">
                                      <span class="glyphicon glyphicon-time"></span>
                                  </span>
                              </div>
              </div>
              <div class="form-group">
                <input type="text" class="form-control" id="direccion" placeholder="Direccion" required="true">
              </div>
          </div>
          <div class="modal-footer">
            <input type="button" class="btn btn-primary btn-block " id="guardarActividad" value="Registrar">
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
          $('#datetimepicker1').datetimepicker();

          $('#datetimepicker3').datetimepicker({
                    format: 'LT'
                });
      });
  </script>
</body>

</html>
