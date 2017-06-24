//Importar los archivos necesarios
$.when(
	$.getScript("app/util/service_manager.js"),
	$.getScript("app/model/nota_model.js"),
	$.Deferred(function(deferred) {
	  $(deferred.resolve);
	})
).done(function() {});	

document.onkeypress=function(e){
	var esIE=(document.all);
	var esNS=(document.layers);
	tecla=(esIE) ? event.keyCode : e.which;
	if(tecla==13){
		getAlumnoPorDni();
	}
}

function getParameterByName(name) {
    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
    results = regex.exec(location.search);
    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}

$(document).ready(main);
	//Funciones de Arranque
	function main() {
	   	getPeriodos();
		var DNI = getParameterByName('DNI');
	  	$("#txtDNI").val(DNI);
	  	getAlumnoPorDni();

	  	$("#btnBuscarAlumnoPorDni").click(function(){
	  		getAlumnoPorDni();
	  	});
	
		 $("#btnBuscarNotas").click(function(){
		  		BuscarNotasAlumno();
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

function validarDatos(){
	if ($("#hdnidAlumno").val()==""){
		return false;
	}else if ($("#slnPeriodo").val()=="0" || $("#slnPeriodo").val()==null) 
	{
		return false;
	}
	return true;
}

function generarNota(){
	var idNota 		= 0;
	var	idAlumno	= $("#hdnidAlumno").val();
	var	idCurso		= 0;
	var	idPeriodo	= $("#slnPeriodo").val();
	var	idEmpleado	= 1;
	var	idTipoNota	= 0;
	var	nota 		= 0;
	var modelNota = new notaModel(	idNota,
									idAlumno,
									idCurso,
									idPeriodo,
									idEmpleado,
									idTipoNota,
									nota); 
	return modelNota;
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
	          value['nomCurso']	+ "</td><td>" +
	          value['periodo']	+ "</td><td>" +
	          value['nomCompleto'] 	+ "</td><td>" +
	          value['nomTipoNota'] 	+ "</td><td>" +
	          value['nota'] 	+ 
	          "</td></tr>";

	        $("#tblNotas").parent().append(newrow);
	      });
	    },
	    error: function(data) {
	      console.log(data);
	    }
  	});		
}