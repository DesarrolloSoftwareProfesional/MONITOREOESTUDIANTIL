create database BD_SGMEv3;

-- drop database BD_SGMEv3;
use BD_SGMEv3;

-- edadAlumno int as SELECT YEAR(CURDATE())-YEAR('1983-04-23') + IF(DATE_FORMAT(CURDATE(),'%m-%d') > DATE_FORMAT('1983-04-23','%m-%d'), 0, -1)

CREATE TABLE Perfiles(
	idPerfil int auto_increment,
	nomPerfil varchar(30) not null,
	estadoRegistro bit default 1,

	constraint Pk_Perfiles primary key(idPerfil)
);

-- CREATE TABLE Usuarios(
-- 	idUsuario int auto_increment,
-- 	idPerfil int,
-- 	userUsuario varchar(30) not null,
-- 	passUsuario varchar(30) not null,
-- 	tipoUsuario int not null,
-- 	estadoRegistro bit,
-- 	constraint Pk_Usuarios primary key (idUsuario),
-- 	constraint Fk_idPerfil_Perfiles_Usuarios foreign key (idPerfil) references Perfiles(idPerfil)
-- );



CREATE TABLE Alumnos(
	idAlumno int auto_increment,
	apPaternoAlumno varchar(60),
	apMaternoAlumno varchar(60),
	nombresAlumno varchar(60),
	dniAlumno char(8),
	fechaNacAlumno Date,
	direccionAlumno varchar(150),
	nomCompleto varchar(200),
    -- idUsuario int,
	estadoRegistro bit default 1,

	constraint Pk_Alumnos primary key (idAlumno),
    constraint Ak_dniAlumno_Alumnos unique(dniAlumno)
    -- constraint Fk_idUsuario_Usuarios_Alumnos foreign key (idUsuario) references Usuarios(idUsuario)
);

CREATE TABLE Usuario_Alumno
(
	idAlumno int not null,
	-- idPerfil int,
	userAlumno varchar(30) not null,
	passAlumno varchar(30) not null,
	-- tipoUsuario int not null,
	estadoRegistro bit default 1,

	constraint Pk_Usuario_Alumno primary key (idAlumno),
	constraint Fk_idAlumno_Alumnos_Usuario_Alumno foreign key (idAlumno) references Alumnos(idAlumno),
    constraint Ak_userAlumno_Usuario_Alumno unique(userAlumno)
);

CREATE TABLE Grados(
	idGrado int auto_increment,
	nomGrado varchar(20),
	estadoRegistro bit default 1,

	constraint Pk_Grados primary key (idGrado)
);

CREATE TABLE Secciones(
	codSeccion char(1),
	estadoRegistro bit default 1,

	constraint Pk_Secciones primary key (codSeccion)
);

CREATE TABLE Cursos(
	idCurso int auto_increment,
	nomCurso varchar(50),
	abrevCurso varchar(4),
	estadoRegistro bit default 1,

	constraint Pk_Cursos primary key (idCurso)
);

CREATE TABLE GrupoAcademico
(
	codGrupoAcademico char(6),
    idGrado int,
    codSeccion char(1),
    anio int,
    estadoRegistro bit default 1,

    constraint Pk_Grupo_Academico primary key (codGrupoAcademico),
	constraint Fk_idGrado_Grados_GrupoAcademico foreign key (idGrado) references Grados(idGrado),
	constraint Fk_codSeccion_Secciones_GrupoAcademico foreign key (codSeccion) references Secciones(codSeccion)
);

CREATE TABLE Alumnos_GrupoAcademico
(
	idAlumno int,
    codGrupoAcademico char(6),
    estadoRegistro bit default 1,

    constraint Pk_Alumnos_GrupoAcademico primary key (idAlumno,codGrupoAcademico),
	constraint Fk_idAlumno_Alumnos_Alumnos_GrupoAcademico foreign key (idAlumno) references Alumnos(idAlumno),
	constraint Fk_codGrupoAcademico_GrupoAcademico_Alumnos_GrupoAcademico foreign key (codGrupoAcademico) references GrupoAcademico(codGrupoAcademico)
);


CREATE TABLE Periodos(
	idPeriodo int auto_increment,
	anio int not null,
	trimestre int not null,
	fechaIni date,
	fechaFin date,
	estadoRegistro bit default 1,

	constraint Pk_Periodos primary key (idPeriodo),
    constraint Ak_anio_trimestre unique(anio,trimestre)
);

CREATE TABLE Cargos(
	idCargo int auto_increment,
	nomCargo varchar(60),
	estadoRegistro bit default 1,

	constraint Pk_Cargos primary key (idCargo)
);

CREATE TABLE DetalleAcademico(
	idAlumno int auto_increment,
	idGrado int,
	codSeccion char(1),
	idPeriodo int,

	constraint Pk_DetalleAcademico primary key (idAlumno),
	constraint Fk_idGrado_Grados_DetalleAcademico foreign key (idGrado) references Grados(idGrado),
	constraint Fk_codSeccion_Secciones_DetalleAcademico foreign key (codSeccion) references Secciones(codSeccion),
	constraint Fk_idPeriodo_Periodos_DetalleAcademico foreign key (idPeriodo) references Periodos(idPeriodo)
);

CREATE TABLE Empleados(
	idEmpleado int auto_increment,
	idCargo int,
	apPaternoEmpleado varchar(60),
	apMaternoEmpleado varchar(60),
	nombresEmpleado varchar(60),
	dniEmpleado char(8),
	fechaNacEmpleado Date,
	direccionEmpleado varchar(250),
	nomCompleto varchar(200),
    -- idUsuario int,
	estadoRegistro bit default 1,

	constraint Pk_Empleados primary key (idEmpleado),
	constraint Fk_idCargo_Cargos foreign key (idCargo) references Cargos(idCargo),
    constraint Ak_dniEmpleado_Empleados unique(dniEmpleado)
    -- constraint Fk_idUsuario_Usuarios_Empleados foreign key (idUsuario) references Usuarios(idUsuario)
);

CREATE TABLE Usuario_Empleado
(
	idEmpleado int not null,
	-- idPerfil int,
	userEmpleado varchar(30) not null,
	passEmpleado varchar(30) not null,
	-- tipoUsuario int not null,
	estadoRegistro bit default 1,

	constraint Pk_Usuario_Empleado primary key (idEmpleado),
	constraint Fk_idEmpleado_Empleados_Usuario_Empleado foreign key (idEmpleado) references Empleados(idEmpleado),
    constraint Ak_userAlumno_Usuario_Empleado unique(userEmpleado)
);

CREATE TABLE TipoNotas(
	idTipoNota int Auto_increment,
	nomTipoNota varchar(60),
	estadoRegistro bit default 1,

    constraint Pk_TipoNotas primary key(idTipoNota)
);

CREATE TABLE Notas(
	idNota int auto_increment,
	idAlumno int,
	idCurso int,
    idPeriodo int,
    idEmpleado int,
    idTipoNota int,
	nota int,
	estadoRegistro bit default 1,

	constraint Pk_Notas primary key (idNota),
	constraint Fk_idAlumno_Alumnos_Notas foreign key (idAlumno) references Alumnos(idAlumno),
	constraint Fk_idCurso_Cursos_Notas foreign key (idCurso) references Cursos(idCurso),
    constraint Fk_idPeriodo_Periodos_Actividades foreign key (idPeriodo) references Periodos(idPeriodo),
	constraint Fk_idEmpleado_Empleados_Notas foreign key (idEmpleado) references Empleados(idEmpleado),
    constraint Fk_idTipoNota_TipoNotas_Notas foreign key (idTipoNota) references TipoNotas(idTipoNota)
);

CREATE TABLE Apoderados(
	idApoderado int auto_increment,
	apPaternoApoderado varchar(60),
	apMaternoApoderado varchar(60),
	nombresApoderado varchar(60),
	dniApoderado char(8),
	fechaNacApoderado Date,
	direccionApoderado varchar(250),
	nomCompleto varchar(200),
    -- idUsuario int,
	estadoRegistro bit default 1,

	constraint Pk_Apoderados primary key (idApoderado),
    constraint Ak_dniApoderado_Apoderados unique(dniApoderado)
    -- constraint Fk_idUsuario_Usuarios_Apoderados foreign key (idUsuario) references Usuarios(idUsuario)
);

CREATE TABLE Usuario_Apoderado
(
	idApoderado int not null,
	-- idPerfil int,
	userApoderado varchar(30) not null,
	passApoderado varchar(30) not null,
	-- tipoUsuario int not null,
	estadoRegistro bit default 1,

	constraint Pk_Usuario_Apoderados primary key (idApoderado),
	constraint Fk_idApoderado_Apoderados_Usuario_Apoderado foreign key (idApoderado) references Apoderados(idApoderado),
    constraint Ak_userApoderados_Usuario_Apoderado unique(userApoderado)
);


CREATE TABLE Alumnos_Apoderados
(
	idAlumno int,
	idApoderado int,

    constraint Pk_Alumnos_Apoderados primary key (idAlumno,idApoderado),
	constraint Fk_idAlumno_Alumnos_Alumnos_Apoderados foreign key (idAlumno) references Alumnos(idAlumno),
	constraint Fk_idApoderado_Apoderados_Alumnos_Apoderados foreign key (idApoderado) references Apoderados(idApoderado)
);



CREATE TABLE Actividades(
	idActividad int auto_increment,
	idEmpleado int,
	-- idAlumno int,
	idCurso int,
    codGrupoAcademico char(6),
	nomActividad varchar(50),
	descrActividad varchar(600),
	fechaRealizacion date,
	horaInicio time,
	horaFin time,
	frecuenciaAviso int,
	flag_Notificado bit,

	constraint Pk_Actividades primary key (idActividad),
	constraint Fk_idEmpleado_Empleados_Actividades foreign key (idEmpleado) references Empleados(idEmpleado),
	-- constraint Fk_idAlumno_Alumnos_Actividades foreign key (idAlumno) references Alumnos(idAlumno),
	constraint Fk_idCurso_Cursos_Actividades foreign key (idCurso) references Cursos(idCurso),
	constraint Fk_codGrupoAcademico_GrupoAcademico_Actividades foreign key (codGrupoAcademico) references GrupoAcademico(codGrupoAcademico)
);

-- SELECT YEAR(CURDATE())-YEAR('1983-04-23') + IF(DATE_FORMAT(CURDATE(),'%m-%d') > DATE_FORMAT('1983-04-23','%m-%d'), 0, -1) AS `EDAD_ACTUAL`;
