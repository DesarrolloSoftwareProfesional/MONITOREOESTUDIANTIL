//Importar los archivos necesarios
$.when(
  $.getScript("app/util/service_manager.js"),
  $.getScript("app/model/actividad_model.js"),
  $.Deferred(function(deferred) {
    $(deferred.resolve);
  })
).done(function() {});

// Levantar el documento
$(document).ready(main);
//Funciones de Arranque
function main() {

  getAllActividad();

  //Accion al hacer click en boton  Registrar Alumno
  $('#nuevaActividad').click(function() {
    document.getElementById("guardarActividad").value = ACCION_REGISTRAR;
    clearInputs();
    showModal();
  });

  //Accion en el boton del modal
  $('#guardarActividad').click(function() {
    saveAlumno();
  });

}


//listar todas las categorias
function getAllActividad() {
  $.ajax({
    dataType: DATA_TYPE_JSON,
    contentType: CONTEN_TYPE_JSON,
    type: METHOD_GET,
    url: ACTIVIDAD_URL_LISTAR,
    success: function(data) {
      $("#tblActividad").html('');

      $.each(data, function(key, value) {
        var newrow = "<tr><td>" +
          value['idActividad'] + "</td><td>" +
          value['codGrupoAcademico'] + "</td><td>" +
          value['nomActividad'] + "</td><td>" +
          value['descrActividad'] + "</td><td>" +
          value['nomCurso'] + "</td><td>" +
          value['fechaRealizacion'] + "</td><td>" +
          value['horaInicio'] + "</td><td>" +
          value['horaFin'] + "</td><td>" +
          "<button type='button' class='btn btn-xs btn-success' onclick='searchActividad(" + value['idActividad'] + ")'>" +
          "<span class='glyphicon glyphicon-refresh'></button></td><td>" +
          "<button type='button' class='btn btn-xs btn-danger' onclick='deleteActividad(" + value['idActividad'] + ")'>" +
          "<span class='glyphicon glyphicon-trash'></button></td><tr>";

        $("#tblActividad").parent().append(newrow);
      });
    },
    error: function(data) {
      console.log(data);
    }
  });
}

//Metodo para registrar o actualizar
function saveAlumno() {
  let opcion = document.getElementById("guardarActividad").value;

  let url_select = (opcion === ACCION_REGISTRAR) ? ACTIVIDAD_URL_REGISTAR : ACTIVIDAD_URL_ACTUALIZAR;

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
      getAllActividad();
      hideModal();
    },
    error: function(data) {
      console.log(data);
    }

  });


}

//Metodo para buscar una categoria por su ID
function searchActividad(id) {

  $.ajax({
    dataType: DATA_TYPE_JSON,
    contentType: CONTEN_TYPE_JSON,
    type: METHOD_GET,
    url: ACTIVIDAD_URL_BUSCAR + id,
    success: function(data) {

      document.getElementById("guardarActividad").value = ACCION_ACTUALIZAR;

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
function deleteActividad(id) {

  if (confirm('Desea eliminar este registo?')) {

    $.ajax({
      dataType: DATA_TYPE_JSON,
      contentType: CONTEN_TYPE_JSON,
      type: METHOD_DELETE,
      url: ACTIVIDAD_URL_ELIMINAR + id,
      success: function(data) {
        ("true" === data.state) ? msg_success(data.msg): msg_error(data.msg);
        console.log(data);
        getAllActividad();
      },
      error: function(data) {
        console.log(data);
      }
    });

  }
}



function showModal() {
  $('#modalActividad').modal({
    show: true,
    backdrop: 'static',
  });
}

function hideModal() {
  $("#modalActividad").modal('toggle');
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
  document.getElementById("id").value = value['idAlumno'];
  document.getElementById("apPaterno").value = value['apPaternoAlumno'];
  document.getElementById("apMaterno").value = value['apMaternoAlumno'];
  document.getElementById("nombres").value = value['nombresAlumno'];
  document.getElementById("dni").value = value['dniAlumno'];
  document.getElementById("fechaNac").value = value['fechaNacAlumno'];
  document.getElementById("direccion").value = value['direccionAlumno'];
}

//obtener valores de los inputs
function getAlumnoValue() {
  let id = document.getElementById("id").value;
  let apPaterno = document.getElementById("apPaterno").value;
  let apMaterno = document.getElementById("apMaterno").value;
  let nombres = document.getElementById("nombres").value;
  let dni = document.getElementById("dni").value;
  let fechaNac = document.getElementById("fechaNac").value;
  let direccion = document.getElementById("direccion").value;

  let objAlumno = new AlumnoModel(id, apPaterno, apMaterno, nombres, dni, fechaNac, direccion);

  return objAlumno;
}
