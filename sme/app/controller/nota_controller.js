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
		getAlumnoPorDni();
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
	  	getAlumnoPorDni();
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

function getAlumnoPorDni(){
	if ($("#txtDNI").val()=="")
	{
		msg_error("Indicar nro de Documento");
		$("#txtDNI").focus();
		return false;
	}
	var dni=$("#txtDNI").val();
	$.ajax({
	    dataType: DATA_TYPE_JSON,
	    contentType: CONTEN_TYPE_JSON,
	    type: METHOD_GET,
	    url: NOTA_URL_LISTAR_ALUMNO_DNI + dni,
	    success: function(data) {
        	$.each(data, function(key, value) {
			  	$("#hdnidAlumno").val(value["idAlumno"]);
			  	$("#txtNombreAlum").val(value["nombresAlumno"]);
			  	$("#txtApellAlumn").val(value["apPaternoAlumno"] + " " + value["apMaternoAlumno"]);
		 	});
		 	BuscarNotasAlumno();
	    },
	    error: function(data) {
	      console.log(data);
	    }
  	});	
}

function generarNota(){
	var idNota 		= 0;
	var	idAlumno	= $("#hdnidAlumno").val();
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
	if ($("#slnCurso").val()=="0" || $("#slnCurso").val()==null) 
	{
		msg_error("Seleccione Curso");
		$("#slnCurso").focus();	
		return false;
	}else if ($("#slnPeriodo").val()=="0" || $("#slnPeriodo").val()==null) 
	{
		msg_error("Seleccione Periodo");
		$("#slnPeriodo").focus();
		return false;
	}else if ($("#slnTipoNota").val()=="0" || $("#slnTipoNota").val()==null) 
	{
		msg_error("Seleccione Tipo de Nota");
		$("#slnTipoNota").focus();
		return false;
	}else if ($("#txtvalornota").val()=="") 
	{
		msg_error("Ingrese Nota");
		$("#txtvalornota").focus();
		return false;
	}else if ($("#txtDNI").val().length !=8) {
		msg_error("Verificar Nro de DNI");
		$("#txtDNI").focus();
		return false;
	}
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
	      BuscarNotasAlumno();
	      //hideModal();
	    },
	    error: function(data) {
	      console.log(data);
	    }
  	});
}

function validarDatos(){
	if ($("#hdnidAlumno").val()==""){
		return false;
	}if ($("#slnCurso").val()=="0" || $("#slnCurso").val()==null) 
	{
		return false;
	}else if ($("#slnPeriodo").val()=="0" || $("#slnPeriodo").val()==null) 
	{
		return false;
	}
	return true;
}

function BuscarNotasAlumno(){
	if (!validarDatos()) {
		return false;	
	}
	var Nota = generarNota();
	$.ajax({
	    dataType: DATA_TYPE_JSON,
	    contentType: CONTEN_TYPE_JSON,
	    type: METHOD_POST,
	    url: NOTA_URL_LISTAR_NOTAS_ALUMNO_CURSO_PERIODO,
	    data: JSON.stringify(Nota.toString()),
	    success: function(data) {
	      $("#tblNotas").html('');
	      $.each(data, function(key, value) {
	        var newrow = "<tr><td>" 	+
	          //value['idAlumno'] 		+ "</td><td>" +
	          value['nomTipoNota']	+ "</td><td>" +
	          value['dniEmpleado'] 	+ "</td><td>" +
	          value['nota'] 	+ "</td><td>" +
	          "<button type='button' class='btn btn-xs btn-warning' onclick='editarNotas(" + value['idCurso'] + "," + value['idCurso'] + ")'>" +
	          	"<span class='glyphicon glyphicon-pencil'>" + 
	          "</button>" 				+ 
	          "</td></tr>";

	        $("#tblNotas").parent().append(newrow);
	      });
	    },
	    error: function(data) {
	      console.log(data);
	    }
  	});		
}