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
}
