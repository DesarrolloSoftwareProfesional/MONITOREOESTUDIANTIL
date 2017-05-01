/*
Clase Alumno
 */
class AlumnoModel {
  constructor(id, apPaterno, apMaterno, nombres, dni, fechaNac, direccion) {
    this.id = id;
    this.apPaterno = apPaterno;
    this.apMaterno = apMaterno;
    this.nombres = nombres;
    this.dni = dni;
    this.fechaNac = fechaNac;
    this.direccion = direccion;
  }
  //Metodo para crear un objeto tipo Json
  toString() {
    return {
      "idAlumno": this.id,
      "apPaternoAlumno": this.apPaterno,
      "apMaternoAlumno": this.apMaterno,
      "nombresAlumno": this.nombres,
      "dniAlumno": this.dni,
      "fechaNacAlumno": this.fechaNac,
      "direccionAlumno": this.direccion
    }
  }

}
