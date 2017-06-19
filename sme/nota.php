<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Gestión de Notas</title>
	<link rel="stylesheet" href="resources/css/bootstrap.min.css">
  	<link rel="stylesheet" href="resources/css/bootstrap-theme.min.css">
  	<link rel="stylesheet" href="resources/css/jquery.zzconfirm.min.css">
  	<style type="text/css">
	  	th{
	  		text-align: center;
	  	}
  	</style>
</head>
<body>
<?php include_once 'template/main-menu.php'; ?>
	<div class="container">
	 <div id="divbotones">
	 	<button type="button" class="btn btn-warning" id="btnRegistroNotas">Registrar Notas</button>
	 </div>
	 <hr>
	 <div id="divTabla">
	 	<table class="table table-striped table-responsive table-bordered table-condensed table-hover">
	 		<thead>
	 		<tr class="warning">
	 			<th>Apellido Paterno</th>
	 			<th>Apellido Materno</th>
	 			<th>Nombres</th>
	 			<th>Nro Documento</th>
	 			<th>Fecha de Nacimiento</th>
	 			<th>Dirección</th>
	 			<th>Grupo Académico</th>
	 			<th colspan="2">Acciones</th>
	 		</tr>
	 	</thead>
	 	<tbody id="tblAlumnos">
	 		 
	 	</tbody>
	 	</table>
	 </div>

	</div>
<?php include_once 'template/main-footer.php'; ?>

<!-- Modal de Registro -->
<div class="modal fade" id="modalRegistroNotas" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          <h4 class="modal-title" id="myModalLabel"><b>Registro de Notas</b></h4>
        </div>
        <form class=""  method="post">
        <input type="hidden" id="id">
        <div class="modal-body" id="datosAqui">
          <div class="modal-body">

            <div class="form-group">
              <select class="form-control" id="slnCurso">
              	<option value='0' disabled="selected"> Seleccione Curso </option>"
              </select>
            </div>

              <div class="form-group">
                <select class="form-control" id="slnPeriodo">
                <option value='0' disabled="selected"> Seleccione Periodo </option>"
                </select>
              </div>
          </div>
          <div class="modal-footer">
            <input type="button" class="btn btn-warning btn-block " id="guardarNota" value="Adicionar Nota">
          </div>
        </div>
        </form>

      </div>
    </div>
  </div>
<!-- /Modal de Registro -->


	<script src="resources/js/vendor/modernizr-2.8.3.min.js"></script>
  	<script src="resources/js/vendor/jquery-1.11.2.min.js"></script>
  	<script src="resources/js/vendor/bootstrap.min.js"></script>
  	<script src="resources/js/vendor/jquery.zzconfirm.js"></script>

  	<script src="app/util/service_manager.js"></script>
  	<script src="app/util/message.js"></script>
  	<script src="app/model/nota_model.js"></script>
  	<script src="app/controller/nota_controller.js"></script>

</body>
</html>