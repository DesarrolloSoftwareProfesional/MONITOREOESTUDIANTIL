<!-- Modal de Registro -->
<div class="modal fade" id="modalRegistroNotas" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
		<div class="modal-content">
	        <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	          <h4 class="modal-title" id="myModalLabel"><b>Registro de Notas</b></h4>
	        </div>
	        <form class=""  method="post">
		        <div class="modal-body" id="datosAqui">
					<div class="modal-body">
						<div class="form-group">
						  <select class="form-control" id="slnCurso">
						  	<option value='0' disabled selected> Seleccione Curso </option>"
						  </select>
						</div>

						<div class="form-group">
							<select class="form-control" id="slnPeriodo">
								<option value='0' disabled selected> Seleccione Periodo </option>"
							</select>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading">Datos de Alumno</div>
							<div class="panel-body">
								<div class="form-group">
									<label for="txtDNI">N° Documento</label>
									<input type="text" class="form-control" id="txtDNI">	
								</div>
								<div class="form-group">
									<label for="txtNombreAlum">Nombre</label>
									<input type="text" class="form-control" id="txtNombreAlum">	
								</div>
								<div class="form-group">
									<label for="txtApellidos">Apellidos</label>
									<input type="text" class="form-control" id="txtApellAlumn" name="">	
								</div>
							</div>
						</div>
						<hr>
						<div class="form-inline">
							<label >Lista de Notas</label>
							<input type="button" class="btn btn-warning pull-right" style="margin:-7px 5px 5px 5px" id="btnBuscarNotas" value="Buscar Notas">
						</div>
						
						<div id="divTablaNotas">
							<table class="table table-striped table-responsive table-bordered table-condensed table-hover">
						 		<thead>
							 		<tr class="warning">
							 			<th>Tipo de Examen</th>
							 			<th>Fecha de Registro</th>
							 			<th>Nota</th>
							 			<th colspan="2">Acciones</th>
							 		</tr>
							 	</thead>
							 	<tbody id="tblNotas">
							 		 
							 	</tbody>
						 	</table>
						</div>
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-warning btn-block " id="btnguardarNota" value="Adicionar Nota">
					</div>
		        </div>
	        </form>

      	</div>
    </div>
 </div>
<!-- /Modal de Registro -->
