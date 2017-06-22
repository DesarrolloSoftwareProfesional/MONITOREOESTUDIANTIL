//Importar los archivos necesarios
$.when(
  $.getScript("app/util/service_manager.js"),
  $.getScript("app/model/nota_model.js"),
  $.Deferred(function(deferred) {
    $(deferred.resolve);
  })
).done(function() {});

var variables = {
	abrioDetalle : false
}

document.onkeypress=function(e){
var esIE=(document.all);
var esNS=(document.layers);
tecla=(esIE) ? event.keyCode : e.which;
if(tecla==13 && variables.abrioDetalle){
	if ($("#txtDNI").val()=="")
	{
		msg_error("Indicar nro de Documento");
		$("#txtDNI").focus();
		return false;
	}
	getAlumnoPorDni($("#txtDNI").val());
  }
}

$(document).ready(main);
	//Funciones de Arranque
	function main() {
	  	getAllAlumnos();
	  //Accion al hacer click en boton  Registrar Alumno
	  $('#btnRegistroNotas').click(function() {
	   getTipoNotas();
	   getCursos();
	   getPeriodos();
	   showModal();
	   variables.abrioDetalle = true;
	  });

	  $("#btnBuscarAlumnoPorDni").click(function(){
	  	getAlumnoPorDni($("#txtDNI").val());
	  });

	  $("#btnguardarNota").click(function(){
	  	postguardarNota();
	  });
}

function showModal() {
  $('#modalRegistroNotas').modal({
    show: true,
    backdrop: 'static'
  });
}

function hideModal() {
  $("#modalRegistroNotas").modal('toggle');
  variables.abrioDetalle = false;
}

function getAllAlumnos() {
	$.ajax({
	    dataType: DATA_TYPE_JSON,
	    contentType: CONTEN_TYPE_JSON,
	    type: METHOD_GET,
	    url: NOTA_URL_LISTAR_ALUMNO,
	    success: function(data) {
	      $("#tblAlumnos").html('');
	      $.each(data, function(key, value) {
	        var newrow = "<tr><td>" 	+
	          //value['idAlumno'] 		+ "</td><td>" +
	          value['apPaternoAlumno']	+ "</td><td>" +
	          value['apMaternoAlumno'] 	+ "</td><td>" +
	          value['nombresAlumno'] 	+ "</td><td>" +
	          value['dniAlumno'] 		+ "</td><td>" +
	          value['fechaNacAlumno'] 	+ "</td><td>" +
	          value['direccionAlumno'] 	+ "</td><td>" +
	          value['codGrupoAcademico']+ "</td><td>" +
	          "<button type='button' class='btn btn-xs btn-success' onclick='editarNotas(" + value['idAlumno'] + "," + value['codGrupoAcademico'] + ")'>" +
	          	"<span class='glyphicon glyphicon-pencil'>" + 
	          "</button>" 				+ "</td><td>" +
	          "<button type='button' class='btn btn-xs btn-info' onclick='consultarNotas(" + value['idAlumno'] + "," +  value['codGrupoAcademico'] + ")'>" +
	          	"<span class='glyphicon glyphicon-search'>" +
	          "</button>" +
	          "</td></tr>";

	        $("#tblAlumnos").parent().append(newrow);
	      });
	    },
	    error: function(data) {
	      console.log(data);
	    }
	  });
}


function getTipoNotas() {
  $.ajax({
    dataType: DATA_TYPE_JSON,
    contentType: CONTEN_TYPE_JSON,
    type: METHOD_GET,
    url: NOTA_URL_LISTAR_TIPONOTA,
    success: function(data) {
      $("#slnTipoNota").html('');
      $("#slnTipoNota").append("<option value='0' disabled selected> Seleccione Tipo de Nota </option>");
      $.each(data, function(key, value) {
        var newrow ="<option value='" + value['idTipoNota'] + "'>" +
					         value['nomTipoNota'] +
				    "</option>";
        $("#slnTipoNota").append(newrow);
      });
    },
    error: function(data) {
      console.log(data);
    }
  });
}

function getPeriodos() {
  $.ajax({
    dataType: DATA_TYPE_JSON,
    contentType: CONTEN_TYPE_JSON,
    type: METHOD_GET,
    url: NOTA_URL_LISTAR_PERIODO,
    success: function(data) {
      $("#slnPeriodo").html('');
      $("#slnPeriodo").append("<option value='0' disabled selected> Seleccione Periodo </option>");
      $.each(data, function(key, value) {
        var newrow ="<option value='" + value['idPeriodo'] + "'>" +
					         value['periodo'] +
				    "</option>";
        $("#slnPeriodo").append(newrow);
      });
    },
    error: function(data) {
      console.log(data);
    }
  });
}


function getCursos() {
	$.ajax({
		dataType: DATA_TYPE_JSON,
	    contentType: CONTEN_TYPE_JSON,
	    type: METHOD_GET,
		url: NOTA_URL_LISTAR_CURSO,
		success: function(data){
			$("#slnCurso").html('');
			$("#slnCurso").append("<option value='0' disabled selected> Seleccione Curso </option>");
			$.each(data, function(key, value){
			  var newrow = "<option value='" + value['idCurso'] + "'>" +
								  value['nomCurso'] +
						 "</option>";
			  $("#slnCurso").append(newrow);
			});
		},
		error: function(data){
			console.log(data);
		}
	});
}

function getAlumnoPorDni(dni){
	$.ajax({
	    dataType: DATA_TYPE_JSON,
	    contentType: CONTEN_TYPE_JSON,
	    type: METHOD_GET,
	    url: NOTA_URL_LISTAR_ALUMNO_DNI + dni,
	    success: function(data) {
	      $.each(data, function(key, value) {
	      		$("#txtNombreAlum").val(value["nombresAlumno"]);
	      		$("#txtApellAlumn").val(value["apPaternoAlumno"] + " " + value["apMaternoAlumno"]);
	      });
	    },
	    error: function(data) {
	      console.log(data);
	    }
  	});	
}

function validarFormulario(){
	if ($("#slnCurso").val()=="0") 
	{
		msg_error("Seleccione Curso");
		return false;
	}else if ($("#slnPeriodo").val()=="0") 
	{
		msg_error("Seleccione Periodo");
		return false;
	}else if ($("#slnTipoNota").val()=="0") 
	{
		msg_error("Seleccione Tipo de Nota");
		return false;
	}else if ($("#txtvalornota").val()=="") 
	{
		msg_error("Ingrese Nota");
		return false;
	}
} 

function generarNota(){
	var idNota 		= 0;
	var	idAlumno	= 1;
	var	idCurso		= $("#slnCurso").val();
	var	idPeriodo	= $("#slnPeriodo").val();
	var	idEmpleado	= 1;
	var	idTipoNota	= $("#slnTipoNota").val();
	var	nota 		= $("#txtvalornota").val();
	var modelNota = new notaModel(	idNota,
									idAlumno,
									idCurso,
									idPeriodo,
									idEmpleado,
									idTipoNota,
									nota); 
	return modelNota;
}

function postguardarNota(){
	validarFormulario();
	var Nota = generarNota();
	jQuery.ajax({
	    dataType: DATA_TYPE_JSON,
	    contentType: CONTEN_TYPE_JSON,
	    type: METHOD_POST,
	    data: JSON.stringify(Nota.toString()),
	    url: NOTA_URL_REGISTRO,
	    success: function(data) {
	      ("true" === data.state) ? msg_success(data.msg): msg_error(data.msg);

	      if ("true" === data.state) {
	        //dataForNotification(objActividad.id);
	      }
	      console.log(data);
	      BuscarNotasAlumno(1);
	      //hideModal();
	    },
	    error: function(data) {
	      console.log(data);
	    }
  	});
}

function BuscarNotasAlumno(id){
	$.ajax({
	    dataType: DATA_TYPE_JSON,
	    contentType: CONTEN_TYPE_JSON,
	    type: METHOD_GET,
	    url: NOTA_URL_LISTAR_NOTAS_ALUMNO + id,
	    success: function(data) {
	      $("#tblNotas").html('');
	      $.each(data, function(key, value) {
	        var newrow = "<tr><td>" 	+
	          //value['idAlumno'] 		+ "</td><td>" +
	          value['nomTipoNota']	+ "</td><td>" +
	          value['nomCurso'] 	+ "</td><td>" +
	          value['nota'] 	+ "</td><td>" +
	          "<button type='button' class='btn btn-xs btn-success' onclick='editarNotas(" + value['idCurso'] + "," + value['idCurso'] + ")'>" +
	          	"<span class='glyphicon glyphicon-pencil'>" + 
	          "</button>" 				+ "</td><td>" +
	          "<button type='button' class='btn btn-xs btn-info' onclick='consultarNotas(" + value['idCurso'] + "," +  value['idCurso'] + ")'>" +
	          	"<span class='glyphicon glyphicon-search'>" +
	          "</button>" +
	          "</td></tr>";

	        $("#tblNotas").parent().append(newrow);
	      });
	    },
	    error: function(data) {
	      console.log(data);
	    }
  	});		
}