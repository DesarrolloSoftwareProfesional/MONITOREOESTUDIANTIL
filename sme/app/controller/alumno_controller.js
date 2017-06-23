//Importar los archivos necesarios
$.when(
  $.getScript("app/util/service_manager.js"),
  $.getScript("app/model/alumno_model.js"),
  $.Deferred(function(deferred) {
    $(deferred.resolve);
  })
).done(function() {});

// Levantar el documento
$(document).ready(main);
//Funciones de Arranque
function main() {

  getAllAlumno();

  //Accion al hacer click en boton  Registrar Alumno
  $('#nuevoAlumno').click(function() {
    document.getElementById("guardarAlumno").value = ACCION_REGISTRAR;
    clearInputs();
    showModal();
  });

  //Accion en el boton del modal
  $('#guardarAlumno').click(function() {
    saveAlumno();
  });

}


//listar todas las categorias
function getAllAlumno() {
  $.ajax({
    dataType: DATA_TYPE_JSON,
    contentType: CONTEN_TYPE_JSON,
    type: METHOD_GET,
    url: ALUMNO_URL_LISTAR,
    success: function(data) {
      $("#tblAlumno").html('');

      $.each(data, function(key, value) {
        var newrow = "<tr><td>" +
          value['idAlumno'] + "</td><td>" +
          value['apPaternoAlumno'] + "</td><td>" +
          value['apMaternoAlumno'] + "</td><td>" +
          value['nombresAlumno'] + "</td><td>" +
          value['dniAlumno'] + "</td><td>" +
          value['fechaNacAlumno'] + "</td><td>" +
          value['direccionAlumno'] + "</td><td>" +
          "<button type='button' class='btn btn-xs btn-success' onclick='searchAlumno(" + value['idAlumno'] + ")'>" +
          "<span class='glyphicon glyphicon-refresh'></button></td><td>" +
          "<button type='button' class='btn btn-xs btn-danger' onclick='deleteAlumno(" + value['idAlumno'] + ")'>" +
          "<span class='glyphicon glyphicon-trash'></button></td><tr>";

        $("#tblAlumno").parent().append(newrow);
      });
    },
    error: function(data) {
      console.log(data);
    }
  });
}

//Metodo para registrar o actualizar
function saveAlumno() {
  let opcion = document.getElementById("guardarAlumno").value;

  let url_select = (opcion === ACCION_REGISTRAR) ? ALUMNO_URL_REGISTAR : ALUMNO_URL_ACTUALIZAR;

  let objAlumno = getAlumnoValue().toString();

  jQuery.ajax({
    dataType: DATA_TYPE_JSON,
    contentType: CONTEN_TYPE_JSON,
    type: METHOD_POST,
    data: JSON.stringify(objAlumno),
    url: url_select,
    success: function(data) {

      ("true" === data.state) ? msg_success(data.msg): msg_error(data.msg);
      console.log(data);
      getAllAlumno();
      hideModal();
    },
    error: function(data) {
      console.log(data);
    }

  });


}

//Metodo para buscar una categoria por su ID
function searchAlumno(id) {

  $.ajax({
    dataType: DATA_TYPE_JSON,
    contentType: CONTEN_TYPE_JSON,
    type: METHOD_GET,
    url: ALUMNO_URL_BUSCAR + id,
    success: function(data) {

      document.getElementById("guardarAlumno").value = ACCION_ACTUALIZAR;

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
function deleteAlumno(id) {
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
      url: ALUMNO_URL_ELIMINAR + id,
      success: function(data) {
        ("true" === data.state) ? msg_success(data.msg): msg_error(data.msg);
        console.log(data);
        getAllAlumno();
      },
      error: function(data) {
        console.log(data);
      }
    });

  }
}



function showModal() {
  $('#modalAlumno').modal({
    show: true,
    backdrop: 'static',
  });
}

function hideModal() {
  $("#modalAlumno").modal('toggle');
}

function clearInputs() {
  document.getElementById("id").value = '';
  document.getElementById("apPaterno").value = '';
  document.getElementById("apMaterno").value = '';
  document.getElementById("nombres").value = '';
  document.getElementById("dni").value = '';
  document.getElementById("fechaNacimiento").value = '';
  document.getElementById("direccion").value = '';
}

function setInputs(value) {
  document.getElementById("id").value = value['idAlumno'];
  document.getElementById("apPaterno").value = value['apPaternoAlumno'];
  document.getElementById("apMaterno").value = value['apMaternoAlumno'];
  document.getElementById("nombres").value = value['nombresAlumno'];
  document.getElementById("dni").value = value['dniAlumno'];
  document.getElementById("fechaNacimiento").value = value['fechaNacAlumno'];
  document.getElementById("direccion").value = value['direccionAlumno'];
}

//obtener valores de los inputs
function getAlumnoValue() {
  let id = document.getElementById("id").value;
  let apPaterno = document.getElementById("apPaterno").value;
  let apMaterno = document.getElementById("apMaterno").value;
  let nombres = document.getElementById("nombres").value;
  let dni = document.getElementById("dni").value;
  let fechaNac = document.getElementById("fechaNacimiento").value;
  let direccion = document.getElementById("direccion").value;

  let objAlumno = new AlumnoModel(id, apPaterno, apMaterno, nombres, dni, fechaNac, direccion);

  return objAlumno;
}
