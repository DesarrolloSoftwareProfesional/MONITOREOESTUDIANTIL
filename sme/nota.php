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
<?php include_once 'template/main-menu.php';?>
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

<?php include_once 'template/main-footer.php';?>
<?php include_once 'notaDetalle.php';?>

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