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
	   getEmpleados();
	   variables.abrioDetalle = true;
	  });

	  $("#btnBuscarAlumnoPorDni").click(function(){
	  	getAlumnoPorDni();
	  });

	  $("#btnguardarNota").click(function(){
	  	postguardarNota();
	  });

	  $("#btnBuscarNotas").click(function(){
	  	BuscarNotasAlumno();
	  });

	}

function showModal() {
  $('#modalRegistroNotas').modal({
    show: true,
    backdrop: 'static'
  });
}

function limpiarDatos(){
	$("#txtDNI").val("");
	$("#hdnidAlumno").val("");
	$("#txtvalornota").val("");
  	$("#txtNombreAlum").val("");
  	$("#txtApellAlumn").val("");
  	$("#tblNotas").html('');
}

function hideModal() {
  $("#modalRegistroNotas").modal('toggle');
  variables.abrioDetalle = false;
  limpiarDatos();
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
	          "<button type='button' class='btn btn-xs btn-success' onclick='editarNotas(" + value['idAlumno'] + "," + value['dniAlumno'] + ")'>" +
	          	"<span class='glyphicon glyphicon-pencil'>" + 
	          "</button>" 				+ "</td><td>" +
	          "<button type='button' class='btn btn-xs btn-info' onclick='consultarNotas(" + value['idAlumno'] + "," +  value['dniAlumno'] + ")'>" +
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

function editarNotas(idAlumno,dniAlumno){
	getTipoNotas();
	getCursos();
	getPeriodos();
	getEmpleados();
	showModal();
	variables.abrioDetalle = true;
	$("#txtDNI").val(dniAlumno);
	getAlumnoPorDni();
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


function getEmpleados() {
  $.ajax({
    dataType: DATA_TYPE_JSON,
    contentType: CONTEN_TYPE_JSON,
    type: METHOD_GET,
    url: NOTA_URL_LISTAR_EMPLEADO,
    success: function(data) {
      $("#slnEmpleados").html('');
      $("#slnEmpleados").append("<option value='0' disabled selected> Seleccione Empleado </option>");
      $.each(data, function(key, value) {
        var newrow ="<option value='" + value['idEmpleado'] + "'>" +
					         value['nomEmpleado'] +
				    "</option>";
        $("#slnEmpleados").append(newrow);
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
	    	if (data.length>0) {
	    		$.each(data, function(key, value) {
				  	$("#hdnidAlumno").val(value["idAlumno"]);
				  	$("#txtNombreAlum").val(value["nombresAlumno"]);
				  	$("#txtApellAlumn").val(value["apPaternoAlumno"] + " " + value["apMaternoAlumno"]);
		 		});
		 	BuscarNotasAlumno();
	    	}else{
	    		$("#hdnidAlumno").val("");
				$("#txtvalornota").val("");
			  	$("#txtNombreAlum").val("");
			  	$("#txtApellAlumn").val("");
			  	$("#tblNotas").html('');
	    	}
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
	var	idEmpleado	= $("#slnEmpleados").val();
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
		msg_error("Seleccione curso");
		$("#slnCurso").focus();	
		return false;
	}else if ($("#slnPeriodo").val()=="0" || $("#slnPeriodo").val()==null) 
	{
		msg_error("Seleccione periodo");
		$("#slnPeriodo").focus();
		return false;
	}else if ($("#slnEmpleados").val()=="0" || $("#slnEmpleados").val()==null) 
	{
		msg_error("Seleccione Empleado");
		$("#slnEmpleados").focus();
		return false;
	}else if ($("#slnTipoNota").val()=="0" || $("#slnTipoNota").val()==null) 
	{
		msg_error("Seleccione tipo de nota");
		$("#slnTipoNota").focus();
		return false;
	}else if ($("#txtvalornota").val()=="") 
	{
		msg_error("Ingrese nota");
		$("#txtvalornota").focus();
		return false;
	}else if ($("#txtDNI").val().length !=8) {
		msg_error("Verificar nro de DNI");
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
	    		NotificarNota();
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
	}else if ($("#slnCurso").val()=="0" || $("#slnCurso").val()==null) 
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
		msg_error("Validar datos para buscar notas.");
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
	          value['nomCompleto'] 	+ "</td><td>" +
	          value['nota'] 	+ "</td><td style='text-align: center;'>" +
	          "<button type='button' class='btn btn-xs btn-danger' onclick='eliminarNota(" + value['idNota'] +")'>" +
	          	"<span class='glyphicon glyphicon-remove'>" + 
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

function eliminarNota(idNota){
	if (confirm('Desea eliminar este registo?')) 
	{
	    $.ajax({
		    dataType: DATA_TYPE_JSON,
		    contentType: CONTEN_TYPE_JSON,
		    type: METHOD_DELETE,
		    url: NOTA_URL_ELIMINAR + idNota,
		    success: function(data) {
		      ("true" === data.state) ? msg_success(data.msg): msg_error(data.msg);
		      console.log(data);
		      BuscarNotasAlumno();
		    },
		    error: function(data) {
		      console.log(data);
		    }
	    });

  	}	
}

function consultarNotas(idAlumno,dniAlumno){
	window.open("notaImpresion.php"+"?DNI="+dniAlumno);
}

function notificarNota() {
	
}
