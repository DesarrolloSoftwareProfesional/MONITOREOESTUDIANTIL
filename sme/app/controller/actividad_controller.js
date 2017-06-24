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
  getAllGrupoAcademicoLst();

  getAllGrupoAcademico();
  getAllCursos();
  getEmpleados();
  //Accion al hacer click en boton  Registrar Alumno
  $('#nuevaActividad').click(function() {
    document.getElementById("guardarActividad").value = ACCION_REGISTRAR;
    clearInputs();
    showModal();
  });

  //Accion en el boton del modal
  $('#guardarActividad').click(function() {
    saveActividad();
  });

  $('#slnGrupoAcademico').on('change', function() {
    getActividadByIdGpoAcademico();

  })
}


//listar todas la actrividades
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
          value['codGrupoAcademico'] + "</td><td>" +
          value['nomCompleto'] + "</td><td>" +
          value['nomActividad'] + "</td><td>" +
          value['descrActividad'] + "</td><td>" +
          value['nomCurso'] + "</td><td>" +
          value['fechaRealizacion'] + "</td><td>" +
          value['horaInicio'] + "</td><td>" +
          value['horaFin'] + "</td><td>" +
          "<button type='button' class='btn btn-xs btn-success' onclick='searchActividad(" + value['idActividad'] + ")'>" +
          "<span class='glyphicon glyphicon-pencil'></button></td><td>" +
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

//listar todos los cursos
function getAllCursos() {
  $.ajax({
    dataType: DATA_TYPE_JSON,
    contentType: CONTEN_TYPE_JSON,
    type: METHOD_GET,
    url: CURSO_URL_LISTAR,
    success: function(data) {
      $("#idCurso").html('');
      $("#idCurso").append("<option value='0' disabled selected> Seleccione Curso </option>");
      $.each(data, function(key, value) {
        var newrow = "<option value='" + value['idCurso'] + "'>" + value['nomCurso'] + "</option>";
        $("#idCurso").append(newrow);
      });
    },
    error: function(data) {
      console.log(data);
    }
  });
}

//Listar todos los empleados(profesores)

function getEmpleados(){
  $.ajax({
    dataType: DATA_TYPE_JSON,
    contentType: CONTEN_TYPE_JSON,
    type: METHOD_GET,
    url: EMPLEADO_URL_LISTAR,
    success: function(data) {
      $("#idEmpleado").html('');
      $("#idEmpleado").append("<option value='0' disabled selected> Seleccione Profesor </option>");
      $.each(data, function(key, value) {
        var newrow = "<option value='" + value['idEmpleado'] + "'>" + value['nomEmpleado'] + "</option>";
        $("#idEmpleado").append(newrow);
      });
    },
    error: function(data) {
      console.log(data);
    }
  });
}

//listar todos los grupos academicos, DEL MODAL
function getAllGrupoAcademico() {
  $.ajax({
    dataType: DATA_TYPE_JSON,
    contentType: CONTEN_TYPE_JSON,
    type: METHOD_GET,
    url: GRUPOACADEMICO_URL_LISTAR,
    success: function(data) {
      $("#codGrupoAcademico").html('');
      $("#codGrupoAcademico").append("<option value='0' disabled selected> Seleccione Grupo </option>");
      $.each(data, function(key, value) {
        var newrow = "<option value='" + value['codGrupoAcademico'] + "'>" +
          value['idGrado'] + "° " +
          value['codSeccion'] + " - " +
          value['anio'] +
          "</option>";
        $("#codGrupoAcademico").append(newrow);
      });
    },
    error: function(data) {
      console.log(data);
    }
  });
}

//listar todos los grupos academicos, DE LA LISTA COMPLETA
function getAllGrupoAcademicoLst() {
  $.ajax({
    dataType: DATA_TYPE_JSON,
    contentType: CONTEN_TYPE_JSON,
    type: METHOD_GET,
    url: GRUPOACADEMICO_URL_LISTAR,
    success: function(data) {
      $("#slnGrupoAcademico").html('');
      $("#slnGrupoAcademico").append("<option value='0' selected='selected'> Todos </option>");
      $.each(data, function(key, value) {
        var newrow = "<option value='" + value['codGrupoAcademico'] + "'>" +
          value['idGrado'] + "° " +
          value['codSeccion'] + " - " +
          value['anio'] +
          "</option>";
        $("#slnGrupoAcademico").append(newrow);
      });
    },
    error: function(data) {
      console.log(data);
    }
  });
}

//Metodo para registrar o actualizar
function saveActividad() {
  let opcion = document.getElementById("guardarActividad").value;

  let url_select = (opcion === ACCION_REGISTRAR) ? ACTIVIDAD_URL_REGISTAR : ACTIVIDAD_URL_ACTUALIZAR;

  let objActividad = getActividadValue();

  jQuery.ajax({
    dataType: DATA_TYPE_JSON,
    contentType: CONTEN_TYPE_JSON,
    type: METHOD_POST,
    data: JSON.stringify(objActividad.toString()),
    url: url_select,
    success: function(data) {

      ("true" === data.state) ? msg_success(data.msg): msg_error(data.msg);

      if ("true" === data.state) {
        dataForNotification(objActividad.id);
      }
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
  //getAllGrupoAcademico();
  //getAllCursos();
  //getEmpleados();
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

function getActividadByIdGpoAcademico(){
  
  var idGpoAcademico=$("#slnGrupoAcademico").val();
  let url_select = (idGpoAcademico=="0")?ACTIVIDAD_URL_LISTAR:ACTIVIDAD_URL_BUSCAR_GPO + idGpoAcademico;

  $.ajax({
      dataType: DATA_TYPE_JSON,
      contentType: CONTEN_TYPE_JSON,
      type: METHOD_GET,
      url:  url_select,
      success: function(data) {
        $("#tblActividad").html('');

        $.each(data, function(key, value) {
          var newrow = "<tr><td>" +
            value['codGrupoAcademico'] + "</td><td>" +
            value['nomCompleto'] + "</td><td>" +
            value['nomActividad'] + "</td><td>" +
            value['descrActividad'] + "</td><td>" +
            value['nomCurso'] + "</td><td>" +
            value['fechaRealizacion'] + "</td><td>" +
            value['horaInicio'] + "</td><td>" +
            value['horaFin'] + "</td><td>" +
            "<button type='button' class='btn btn-xs btn-success' onclick='searchActividad(" + value['idActividad'] + ")'>" +
            "<span class='glyphicon glyphicon-pencil'></button></td><td>" +
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

function dataForNotification(id) {
  let url_select = ("" === id) ? ACTIVIDAD_URL_ULTIMO_REGISTRO : ACTIVIDAD_URL_BUSCAR_NOTIFICACION + id;

  $.ajax({
    dataType: DATA_TYPE_JSON,
    contentType: CONTEN_TYPE_JSON,
    type: METHOD_GET,
    url: url_select,
    success: function(data) {
      ("" !== data.message_id) ? msg_info("notificacion enviado correctamente"): msg_error("notificacion no se pudo enviar");
      console.log(data);
    },
    error: function(data) {
      console.log(data);
    }
  });
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
  document.getElementById("codGrupoAcademico").value = '0';
  document.getElementById("nomActividad").value = '';
  document.getElementById("descrActividad").value = '';
  document.getElementById("idCurso").value = '0';
  document.getElementById("idEmpleado").value = '0';
  document.getElementById("fechaRealizacion").value = '';
  document.getElementById("horaInicio").value = '';
  document.getElementById("horaFin").value = '';
}

function setInputs(value) {
  document.getElementById("id").value = value['idActividad'];
  document.getElementById("codGrupoAcademico").value = value['codGrupoAcademico'];
  document.getElementById("nomActividad").value = value['nomActividad'];
  document.getElementById("descrActividad").value = value['descrActividad'];
  document.getElementById("idCurso").value = value['idCurso'];
  document.getElementById("idEmpleado").value = value['idEmpleado'];
  document.getElementById("fechaRealizacion").value = value['fechaRealizacion'];
  document.getElementById("horaInicio").value = value['horaInicio'];
  document.getElementById("horaFin").value = value['horaFin'];
}

//obtener valores de los inputs
function getActividadValue() {
  let id = document.getElementById("id").value;
  let codGrupoAcademico = document.getElementById("codGrupoAcademico").value;
  let nomActividad = document.getElementById("nomActividad").value;
  let descrActividad = document.getElementById("descrActividad").value;
  let idCurso = document.getElementById("idCurso").value;
  let idEmpleado = document.getElementById("idEmpleado").value;
  let fechaRealizacion = document.getElementById("fechaRealizacion").value;
  let horaInicio = document.getElementById("horaInicio").value;
  let horaFin = document.getElementById("horaFin").value;
  let frecuenciaAviso = 1;
  let objActividad = new ActidadModel(id, idEmpleado, idCurso, codGrupoAcademico, nomActividad, descrActividad,
    fechaRealizacion, horaInicio, horaFin, frecuenciaAviso);

  return objActividad;
}
