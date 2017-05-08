

//CLASE DE APODERADO

class ApoderadoModel{

	constructor(id,apPaterno,apMaterno, nombres, dni, fechaNac, direccion){
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
      "idApoderado": this.id,
      "apPaternoApoderado": this.apPaterno,
      "apMaternoApoderado": this.apMaterno,
      "nombresApoderado": this.nombres,
      "dniApoderado": this.dni,
      "fechaNacApoderado": this.fechaNac,
      "direccionApoderado": this.direccion
    }
	}

}