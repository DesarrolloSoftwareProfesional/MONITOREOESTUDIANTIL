/*
Clase Actividad
 */
class ActidadModel {
  constructor(id, idEmpleado, idCurso, codGrupoAcademico, nomActividad, descrActividad,
    fechaRealizacion, horaInicio, horaFin, frecuenciaAviso) {
    this.id = id;
    this.idEmpleado = idEmpleado;
    this.idCurso = idCurso;
    this.codGrupoAcademico = codGrupoAcademico;
    this.nomActividad = nomActividad;
    this.descrActividad = descrActividad;
    this.fechaRealizacion = fechaRealizacion;
    this.horaInicio = horaInicio;
    this.horaFin = horaFin;
    this.frecuenciaAviso = frecuenciaAviso;
  }
  //Metodo para crear un objeto tipo Json
  toString() {
    return {
      "idActividad": this.id,
      "idEmpleado": this.idEmpleado,
      "idCurso": this.idCurso,
      "codGrupoAcademico": this.codGrupoAcademico,
      "nomActividad": this.nomActividad,
      "descrActividad": this.descrActividad,
      "fechaRealizacion": this.fechaRealizacion,
      "horaInicio": this.horaInicio,
      "horaFin": this.horaFin,
      "frecuenciaAviso": this.frecuenciaAviso
    }
  }

}
