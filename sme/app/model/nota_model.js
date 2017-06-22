class alumnoModel{
	constructor(idAlumno, 
				apPaternoAlumno, 
				apMaternoAlumno, 
				nombresAlumno, 
				dniAlumno, 
				fechaNacAlumno, 
				direccionAlumno, 
				codGrupoAcademico)
	{
	this.idAlumno			= idAlumno, 
	this.apPaternoAlumno	= apPaternoAlumno, 
	this.apMaternoAlumno	= apMaternoAlumno, 
	this.nombresAlumno		= nombresAlumno, 
	this.dniAlumno 			= dniAlumno, 
	this.fechaNacAlumno		= fechaNacAlumno, 
	this.direccionAlumno	= direccionAlumno, 
	this.codGrupoAcademico	= codGrupoAcademico
	}

	toString(){
	return{
		"idAlumno":this.idAlumno,
		"apPaternoAlumno":this.apPaternoAlumno,
		"apMaternoAlumno":this.apMaternoAlumno,
		"nombresAlumno":this.nombresAlumno,
		"dniAlumno":this.dniAlumno,
		"fechaNacAlumno":this.fechaNacAlumno,
		"direccionAlumno":this.direccionAlumno,
		"codGrupoAcademico":this.codGrupoAcademico
		}
	}
}

class notaModel{
	constructor( 
				idNota,
			  	idAlumno,
			  	idCurso, 
			  	idPeriodo, 
			    idEmpleado, 
			    idTipoNota, 
			    nota,
			    estadoregistro){
	this.idNota 		= idNota, 
  	this.idAlumno 		= idAlumno, 
  	this.idCurso		= idCurso, 
  	this.idPeriodo		= idPeriodo, 
    this.idEmpleado		= idEmpleado, 
    this.idTipoNota		= idTipoNota,
    this.nota 			= nota,			
    this.estadoregistro = estadoregistro
	}

	toString(){
		return{
			"idNota" 		: this.idNota,  
			"idAlumno" 		: this.idAlumno,  
			"idCurso"		: this.idCurso,  
			"idPeriodo"		: this.idPeriodo,  
			"idEmpleado"	: this.idEmpleado,  	
			"idTipoNota"	: this.idTipoNota, 
			"nota"	:  this.nota,			
			"estadoregistro": this.estadoregistro  
		}
	}
}
