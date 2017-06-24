<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Gestión de Notas</title>
	<link rel="stylesheet" href="resources/css/notify.min.css">
	<link rel="stylesheet" href="resources/css/bootstrap.min.css">
  	<link rel="stylesheet" href="resources/css/bootstrap-theme.min.css">
  	<link rel="stylesheet" href="resources/css/jquery.zzconfirm.min.css">

  	<style type="text/css">
	  	th{
	  		text-align: center;
	  	}
	  	.modal-dialog{
		    overflow-y: initial !important
		}
		.modal-body{
		    height: 550px;
		    overflow-y: auto;
		}
		.glyphicon >.glyphicon-remove{
			text-align: center;
		}
  	</style>
</head>
<body>
<?php include_once 'template/main-menu.php';?>
	<div class="container">
		<div id="divbotones">
			<button type="button" class="btn btn-warning" onclick="javascript:window.print()" id="btnRegistroNotas">Imprimir Consulta de Notas</button>
		</div>
		<hr>
		<div class="">
				<div class="form-group">
					<select class="form-control" id="slnPeriodo">
						<option value='0' disabled selected> Seleccione Periodo </option>"
					</select>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading">Datos de Alumno</div>
					<div class="panel-body">
						<div class="form-inline">
							<div class="form-group">
								<input type="hidden" id="hdnidAlumno">
								<label for="txtDNI">N° DNI</label>
								<input type="text" placeholder="DNI" class="form-control" id="txtDNI" maxlength="8">
								<button type="button" class='btn btn-xs btn-info' id="btnBuscarAlumnoPorDni" >
									<span class='glyphicon glyphicon-search'>
								</button>
						    </div>
						    <div class="form-group">
								<label class="sr-only" for="txtNombreAlum">Nombre</label>
								<input placeholder="Nombre" disabled="disabled" type="text" class="form-control" id="txtNombreAlum" width="200px">
								<label class="sr-only" for="txtApellAlumn">Apellidos</label>
								<input placeholder="Apellidos" type="text" disabled="disabled" class="form-control" id="txtApellAlumn">
							</div>
						</div>
					</div>
				</div>
				<hr>
				<div class="form-inline">
					<label >Lista de Notas</label>
					<input type="button" class="btn btn-warning pull-right" style="margin:-7px 5px 5px 5px" id="btnBuscarNotas" value="Buscar Notas">
				</div>
			</div>
		<div id="divTabla">
		 	<table class="table table-striped table-responsive table-bordered table-condensed table-hover">
		 		<thead>
			 		<tr class="warning">
			 			<th>Curso</th>
			 			<th>Periodo</th>
			 			<th>Nombre Empleado</th>
			 			<th>Tipo de Examen</th>
			 			<th>Nota</th>
			 		</tr>
			 	</thead>
			 	<tbody id="tblNotas">

			 	</tbody>
		 	</table>
		</div>
	</div>

<?php include_once 'template/main-footer.php';?>
<?php include_once 'notaDetalle.php';?>

	<script src="resources/js/vendor/modernizr-2.8.3.min.js"></script>
  	<script src="resources/js/vendor/jquery-1.11.2.min.js"></script>
  	<script src="resources/js/vendor/bootstrap.min.js"></script>
  	<script src="resources/js/vendor/jquery.zzconfirm.js"></script>

	<script src="resources/js/vendor/notify.min.js"></script>
  	<script src="resources/js/vendor/jquery.zzconfirm.js"></script>

  	<script src="app/util/service_manager.js"></script>
  	<script src="app/util/message.js"></script>
  	<script src="app/model/nota_model.js"></script>
  	<script src="app/controller/notaImpresion_controller.js"></script>

</body>
</html>
