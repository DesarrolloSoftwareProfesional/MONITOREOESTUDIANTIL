//importamos los archivos

$.when(
	$.getScript("app/util/service_manager.js"),
	$.getScript("app/model/apoderado_model.js"),
	$.Deferred(function(deferred){
		$(deferred.resolve);
	})
	).done(function(){});

//levantar el documento

$(document).ready(main);

//funcion de arranque

function main(){

	getAllApoderado();

	//Accion onClick en boton registrar

	$('#nuevoApoderado').click(function(){
		document.getElementById("guardarApoderado").value = ACCION_REGISTRAR;
		clearInputs();
		showModal();
	});

	//Accion para el boton modal

	$("guardarApoderado").click(function(){
		saveApoderado();
	});
}

//listar todas las categorias

	function getAllApoderado(){
		$.ajax({
			datatype: DATA_TYPE_JSON,
			contentType: CONTENT_TYPE_JSON,
			type: METHOD_POST,
			url: URL_APODERADO_LISTAR,
			success: function(data){
				$("#tblApoderado").html('');

				$.each(data,function(key, value){
					var newrow = "<tr><td>"+
					value['idApoderado'] + "</td><td>" +
					value['apPaternoApoderado'] + "</td><td>" +
					value['apMaternoApoderado'] + "</td><td>" +
					value['nombresApoderado'] + "</td><td>" +
					value['dniApoderado'] + "</td><td>" +
					value['fechaNacApoderado'] + "</td><td>" +
					value['direccionApoderado'] + "</td><td>" +
					"<button type='button' class='btn btn-xs btn-success' onclick='searchApoderado(" + value['idApoderado'] + ")'>" +
			        "<span class='glyphicon glyphicon-refresh'></button></td><td>" +
			        "<button type='button' class='btn btn-xs btn-danger' onclick='deleteApoderado(" + value['idApoderado'] + ")'>" +
			        "<span class='glyphicon glyphicon-trash'></button></td><tr>";

        $("#tblApoderado").parent().append(newrow);
				});				
			},
			error: function(data){
				console.log(data);
			}
		});
	}

	//metodod para registrar o actualizar

	function saveApoderado(){
		let opcion = document.getElementById("guardarApoderado").value;

		let url_select = (opcion === ACCION_REGISTRAR) ? URL_APODERADO_REGISTRAR : URL_APODERADO_ACTUALIZAR;

		let objApoderado = getApoderadoValue().toString();

		jQuery.ajax({
			datatype: DATA_TYPE_JSON,
			contentType: CONTENT_TYPE_JSON,
			type: METHOD_POST,
			data: JSON.stringify(objApoderado),
			url: url_select,
			success: function(data){
				("true" === data.state) ? msg_success(data.msg): msg_error(data.msg);
				console.log(data);
				getAllApoderado();
				hideModal();
			},
			error: function(data){
				console.log(data);
			}
		});
	}

	//metodo para buscar un apoderado por su id

	function searchApoderado(id){
		$.ajax({
			 dataType: DATA_TYPE_JSON,
		    contentType: CONTEN_TYPE_JSON,
		    type: METHOD_GET,
		    url: URL_APODERADO_BUSCAR + id,
		    success: function(data) {

		      document.getElementById("guardarApoderado").value = ACCION_ACTUALIZAR;

		      $.each(data, function(key, value) {
		        setInputs(value);
		      });

		      showModal();

		    },
		    error: function(data) {
		      console.log(data);
		    }
		});
	}

//Metodo para eliminar una categoria por su ID

function deleteApoderado(id) {

  // //Accion al hacer click en boton Eliminar
  // $(".btn").zzConfirm({
  //   content: '¿Seguro que quiere Eliminar?',
  //   ok: function(ele, box) {
  //     msg_info("no se cancelo");
  //   },
  //   cancel: function(ele, box) {
  //     msg_warning("Se cancelo la operacion");
  //   }
  // });

  if (confirm('Desea eliminar este registo?')) {

    $.ajax({
      dataType: DATA_TYPE_JSON,
      contentType: CONTEN_TYPE_JSON,
      type: METHOD_DELETE,
      url: URL_APODERADO_ELIMINAR + id,
      success: function(data) {
        ("true" === data.state) ? msg_success(data.msg): msg_error(data.msg);
        console.log(data);
        getAllApoderado();
      },
      error: function(data) {
        console.log(data);
      }
    });

  }
}


function showModal(){

	$('#modalApoderado').modal({
		show: true,
		backdrop: 'static',
	});
}

function hideModal(){
	$('#modalApoderado').modal('toggle');
}

function clearInputs() {
  document.getElementById("id").value = '';
  document.getElementById("apPaterno").value = '';
  document.getElementById("apMaterno").value = '';
  document.getElementById("nombres").value = '';
  document.getElementById("dni").value = '';
  document.getElementById("fechaNac").value = '';
  document.getElementById("direccion").value = '';
}

function setInputs(value) {
  document.getElementById("id").value = value['idApoderado'];
  document.getElementById("apPaterno").value = value['apPaternoApoderado'];
  document.getElementById("apMaterno").value = value['apMaternoApoderado'];
  document.getElementById("nombres").value = value['nombresApoderado'];
  document.getElementById("dni").value = value['dniApoderado'];
  document.getElementById("fechaNac").value = value['fechaNacApoderado'];
  document.getElementById("direccion").value = value['direccionApoderado'];
}

//obtener valores de los inputs
function getApoderadoValue() {
  let id = document.getElementById("id").value;
  let apPaterno = document.getElementById("apPaterno").value;
  let apMaterno = document.getElementById("apMaterno").value;
  let nombres = document.getElementById("nombres").value;
  let dni = document.getElementById("dni").value;
  let fechaNac = document.getElementById("fechaNac").value;
  let direccion = document.getElementById("direccion").value;

  let objApoderado = new ApoderadoModel(id, apPaterno, apMaterno, nombres, dni, fechaNac, direccion);

  return objApoderado;
}