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

	}