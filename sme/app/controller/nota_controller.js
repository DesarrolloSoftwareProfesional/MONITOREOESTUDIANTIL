//Importar los archivos necesarios
$.when(
  $.getScript("app/util/service_manager.js"),
  $.getScript("app/model/nota_model.js"),
  $.Deferred(function(deferred) {
    $(deferred.resolve);
  })
).done(function() {});

$(document).ready(main);
	//Funciones de Arranque
	function main() {
	  	getAllAlumnos();
	  //Accion al hacer click en boton  Registrar Alumno
	  $('#btnRegistroNotas').click(function() {
	    //document.getElementById("guardarActividad").value = ACCION_REGISTRAR;
	    //clearInputs();
	    //getAllGrupoAcademico();
	   //getAllCursos();
	   getTipoNotas()
	   showModal();
	  });
	  $("#btnBuscarAlumnoPorDni").click(function(){
	  	getAlumnoPorDni($("#txtDNI").val());
	  });
	  //Accion en el boton del modal
	  $('#guardarActividad').click(function() {
	    saveActividad();
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

function getAlumnoPorDni(){
	$.ajax({
	    dataType: DATA_TYPE_JSON,
	    contentType: CONTEN_TYPE_JSON,
	    type: METHOD_GET,
	    url: NOTA_URL_LISTAR_ALUMNO_DNI,
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
