use BD_SGMEv3;

-- -------------------------------------------------------------
-- TABLA:					ALUMNOS , USUARIO_ALUMNO
-- STORE PROCEDURE:			SP_ALUMNOS_SELECT_LOGIN(?,?)
-- DESCRIPCIÓN:				Buscar alumno por usuario y pasword
-- FECHA DE CREACIÓN:		2017-04-27
-- CREADO POR:				Palomino Rojas J. Abel
-- FECHA DE MODIFICACIÓN:2017-05-04
-- MODIFICADO POR:  Palomino Rojas J. Abel
-- --------------------------------------------------------------

-- DROP PROCEDURE SP_ALUMNOS_SELECT_LOGIN;

DELIMITER //
CREATE PROCEDURE SP_ALUMNOS_SELECT_LOGIN(IN p_userAlumno VARCHAR(30), IN p_passAlumno VARCHAR(30))
 BEGIN
	SELECT
		A.idAlumno, A.apPaternoAlumno, A.apMaternoAlumno, A.nombresAlumno,
    A.dniAlumno, A.fechaNacAlumno, A.direccionAlumno, A.nomCompleto,
    U.userAlumno, A.estadoRegistro
	FROM ALUMNOS A INNER JOIN USUARIO_ALUMNO U ON A.idAlumno=U.idAlumno
	WHERE U.userAlumno=p_userAlumno AND U.passAlumno=p_passAlumno;
END //
DELIMITER ;

-- CALL SP_ALUMNOS_SELECT_LOGIN('apalomino@gmail.com','ap123');




-- -------------------------------------------------------------
-- TABLA:					ALUMNOS
-- STORE PROCEDURE:			SP_ALUMNOS_SELECT_ALL()
-- DESCRIPCIÓN:				Listado completo de alumnos
-- FECHA DE CREACIÓN:		2017-04-27
-- CREADO POR:				Palomino Rojas J. Abel
-- FECHA DE MODIFICACIÓN:
-- MODIFICADO POR:
-- --------------------------------------------------------------

-- DROP PROCEDURE SP_ALUMNOS_SELECT_ALL;

DELIMITER //
CREATE PROCEDURE SP_ALUMNOS_SELECT_ALL()
 BEGIN
	SELECT
		A.idAlumno, A.apPaternoAlumno, A.apMaternoAlumno, A.nombresAlumno,
        A.dniAlumno, A.fechaNacAlumno, A.direccionAlumno, A.nomCompleto, A.estadoRegistro
	FROM ALUMNOS A;
END //
DELIMITER ;

-- CALL SP_ALUMNOS_SELECT_ALL();



-- -------------------------------------------------------------
-- TABLA:					ALUMNOS
-- STORE PROCEDURE:			SP_ALUMNOS_SELECT_BY_ID()
-- DESCRIPCIÓN:				Obtiene un alumno por Id
-- FECHA DE CREACIÓN:		2017-04-27
-- CREADO POR:				Palomino Rojas J. Abel
-- FECHA DE MODIFICACIÓN:
-- MODIFICADO POR:
-- --------------------------------------------------------------

-- DROP PROCEDURE SP_ALUMNOS_SELECT_BY_ID;

DELIMITER //
CREATE PROCEDURE SP_ALUMNOS_SELECT_BY_ID(IN p_idAlumno INT)
 BEGIN
	SELECT
		A.idAlumno, A.apPaternoAlumno, A.apMaternoAlumno, A.nombresAlumno,
        A.dniAlumno, A.fechaNacAlumno, A.direccionAlumno, A.nomCompleto, A.estadoRegistro
	FROM ALUMNOS A WHERE A.idAlumno=p_idAlumno;
END //
DELIMITER ;

-- CALL SP_ALUMNOS_SELECT_BY_ID(1);



-- -------------------------------------------------------------
-- TABLA:					ALUMNOS
-- STORE PROCEDURE:			SP_ALUMNOS_INSERT(?,?,?,?,?,?)
-- DESCRIPCIÓN:				Insertar datos del alumno
-- FECHA DE CREACIÓN:		2017-04-27
-- CREADO POR:				Palomino Rojas J. Abel
-- FECHA DE MODIFICACIÓN:
-- MODIFICADO POR:
-- --------------------------------------------------------------

-- DROP PROCEDURE SP_ALUMNOS_INSERT;

DELIMITER //
CREATE PROCEDURE SP_ALUMNOS_INSERT
(
	IN p_apPaternoAlumno VARCHAR(60),
	IN p_apMaternoAlumno VARCHAR(60),
	IN p_nombresAlumno VARCHAR(60),
	IN p_dniAlumno CHAR(8),
    IN p_fechaNacAlumno DATE,
    IN p_direccionAlumno VARCHAR(150)
)
 BEGIN
	INSERT INTO ALUMNOS
    (apPaternoAlumno, apMaternoAlumno, nombresAlumno, dniAlumno, fechaNacAlumno, direccionAlumno, nomCompleto)
    VALUES
    (p_apPaternoAlumno, p_apMaternoAlumno, p_nombresAlumno, p_dniAlumno, p_fechaNacAlumno,
     p_direccionAlumno, concat(p_apPaternoAlumno,' ',p_apMaternoAlumno,' ', p_nombresAlumno)) ;
END //
DELIMITER ;

-- CALL SP_ALUMNOS_INSERT('FLORES','GARCIA','CRISTINA','4622522','1990-06-11','Av AVANCAY 954');




-- -------------------------------------------------------------
-- TABLA:					ALUMNOS
-- STORE PROCEDURE:			SP_ALUMNOS_UPDATE(?,?,?,?,?,?)
-- DESCRIPCIÓN:				Actualiza datos del alumno
-- FECHA DE CREACIÓN:		2017-04-27
-- CREADO POR:				Palomino Rojas J. Abel
-- FECHA DE MODIFICACIÓN:
-- MODIFICADO POR:
-- --------------------------------------------------------------

-- DROP PROCEDURE SP_ALUMNOS_UPDATE;

DELIMITER //
CREATE PROCEDURE SP_ALUMNOS_UPDATE
(
	IN p_apPaternoAlumno VARCHAR(60),
	IN p_apMaternoAlumno VARCHAR(60),
	IN p_nombresAlumno VARCHAR(60),
	IN p_dniAlumno CHAR(8),
    IN p_fechaNacAlumno DATE,
    IN p_direccionAlumno VARCHAR(150),
    IN p_idAlumno INT
)
 BEGIN
	UPDATE ALUMNOS SET
    apPaternoAlumno = p_apPaternoAlumno, apMaternoAlumno = p_apMaternoAlumno,
    nombresAlumno = p_nombresAlumno, dniAlumno = p_dniAlumno, fechaNacAlumno = p_fechaNacAlumno,
    direccionAlumno = p_direccionAlumno, nomCompleto = concat(p_apPaternoAlumno,' ',p_apMaternoAlumno,' ', p_nombresAlumno)
    WHERE idAlumno = p_idAlumno;
END //
DELIMITER ;

-- CALL SP_ALUMNOS_UPDATE('FLORES','GARCIA','CRISTINA','4622522','1990-06-11','Av AVANCAY 952',4);


-- -------------------------------------------------------------
-- TABLA:					NOTAS,
-- STORE PROCEDURE:			SP_NOTAS_SELECT_ALL_BY_ID(?)
-- DESCRIPCIÓN:				Listado de Notas por id del Alumno
-- FECHA DE CREACIÓN:		2017-05-06
-- CREADO POR:				Palomino Rojas J. Abel
-- FECHA DE MODIFICACIÓN:
-- MODIFICADO POR:
-- --------------------------------------------------------------

-- DROP PROCEDURE SP_NOTAS_SELECT_ALL_BY_ID;

DELIMITER //
CREATE PROCEDURE SP_NOTAS_SELECT_ALL_BY_ID (IN p_idAlumno INT)
 BEGIN
Select
	N.idNota, N.idAlumno, N.idPeriodo, P.trimestre,
    N.idTipoNota, T.nomTipoNota, N.idCurso, C.nomCurso,
    C.abrevCurso, N.nota, N.idEmpleado
from NOTAS N
	INNER JOIN TIPONOTAS T ON N.idTipoNota=T.idTipoNota
	INNER JOIN PERIODOS P ON N.idPeriodo=P.idPeriodo
	INNER JOIN CURSOS C ON N.idCurso=C.idCurso
WHERE N.idAlumno=p_idAlumno;
END //
DELIMITER ;

-- CALL SP_NOTAS_SELECT_ALL_BY_ID(1);

-- -------------------------------------------------------------
-- TABLA:					NOTAS,
-- STORE PROCEDURE:			SP_NOTAS_PROMEDIO_SELECT_ALL_BY_ID(?)
-- DESCRIPCIÓN:				Listado de promedio de Notas por id del Alumno
-- FECHA DE CREACIÓN:		2017-05-07
-- CREADO POR:				Palomino Rojas J. Abel
-- FECHA DE MODIFICACIÓN:
-- MODIFICADO POR:
-- --------------------------------------------------------------

-- DROP PROCEDURE SP_NOTAS_PROMEDIO_SELECT_ALL_BY_ID;

DELIMITER //
CREATE PROCEDURE SP_NOTAS_PROMEDIO_SELECT_ALL_BY_ID (IN p_idAlumno INT)
 BEGIN
	SELECT N.idCurso,ROUND(AVG(N.nota)) AS 'promedio',P.trimestre
	FROM NOTAS N INNER JOIN PERIODOS P ON N.idPeriodo=P.idPeriodo
	WHERE N.idAlumno=p_idAlumno
	GROUP BY N.idCurso
	ORDER BY N.idCurso;
END //
DELIMITER ;

-- CALL SP_NOTAS_PROMEDIO_SELECT_ALL_BY_ID(1);

-- -------------------------------------------------------------
-- TABLA:					NOTAS,
-- STORE PROCEDURE:			SP_NOTAS_PROMEDIO_TRIMESTRE_SELECT_ALL_BY_ID(?,?)
-- DESCRIPCIÓN:				Listado de promedio de Notas por id del Alumno y un trimestre
-- FECHA DE CREACIÓN:		2017-05-07
-- CREADO POR:				Palomino Rojas J. Abel
-- FECHA DE MODIFICACIÓN:
-- MODIFICADO POR:
-- --------------------------------------------------------------

-- DROP PROCEDURE SP_NOTAS_PROMEDIO_TRIMESTRE_SELECT_ALL_BY_ID;

DELIMITER //
CREATE PROCEDURE SP_NOTAS_PROMEDIO_TRIMESTRE_SELECT_ALL_BY_ID (IN p_idAlumno INT, IN p_trimestre INT)
 BEGIN
	SELECT N.idCurso,ROUND(AVG(N.nota)) AS 'promedio',P.trimestre
	FROM NOTAS N INNER JOIN PERIODOS P ON N.idPeriodo=P.idPeriodo
	WHERE N.idAlumno=p_idAlumno and P.trimestre=p_trimestre
	GROUP BY N.idCurso
	ORDER BY N.idCurso;
END //
DELIMITER ;

-- CALL SP_NOTAS_PROMEDIO_TRIMESTRE_SELECT_ALL_BY_ID(1,1);

-- -------------------------------------------------------------
-- TABLA:					APODERADOS
-- STORE PROCEDURE:			SP_APODERADOS_SELECT_ALL()
-- DESCRIPCIÓN:				Listado completo de apoderados
-- FECHA DE CREACIÓN:		2017-05-07
-- CREADO POR:				JHONATAN ARUHANCA VILCA
-- FECHA DE MODIFICACIÓN:
-- MODIFICADO POR:
-- --------------------------------------------------------------

-- DROP PROCEDURE SP_APODERADOS_SELECT_ALL;

DELIMITER //
CREATE PROCEDURE SP_APODERADOS_SELECT_ALL()
 BEGIN
	SELECT
    A.idApoderado, A.apPaternoApoderado, A.apMaternoApoderado,
    A.nombresApoderado, A.dniApoderado, A.fechaNacApoderado, A.direccionApoderado, A.nomCompleto, A.estadoRegistro

	FROM APODERADOS A;
END //
DELIMITER ;

-- CALL SP_ALUMNOS_SELECT_ALL();


-- -------------------------------------------------------------
-- TABLA:					APODERADOS
-- STORE PROCEDURE:			SP_APODERADOS_SELECT_LOGIN(?,?)
-- DESCRIPCIÓN:				Buscar apoderado por usuario y pasword
-- FECHA DE CREACIÓN:		2017-05-07
-- CREADO POR:				JHONATAN ARUHANCA VILCA
-- FECHA DE MODIFICACIÓN:
-- MODIFICADO POR:
-- --------------------------------------------------------------


DELIMITER //
CREATE PROCEDURE SP_APODERADOS_SELECT_LOGIN (IN p_userApoderado VARCHAR(30), IN p_passApoderado VARCHAR(30))
BEGIN
	SELECT
    A.idApoderado, A.apPaternoApoderado, A.apMaternoApoderado,
    A.nombresApoderado, A.dniApoderado, A.fechaNacApoderado, A.direccionApoderado, A.nomCompleto, U.userApoderado, A.estadoRegistro

	FROM APODERADOS A INNER JOIN USUARIO_APODERADO U ON A.idApoderado=U.idApoderado
	WHERE U.userApoderado=p_userApoderado AND U.passApoderado=p_passApoderado;
END //
DELIMITER ;

-- -------------------------------------------------------------
-- TABLA:					CURSOS
-- STORE PROCEDURE:			SP_CURSOS_SELECT_ALL()
-- DESCRIPCIÓN:				Listado de todos los cursos
-- FECHA DE CREACIÓN:		2017-05-21
-- CREADO POR:				Palomino Rojas J. Abel
-- FECHA DE MODIFICACIÓN:
-- MODIFICADO POR:
-- --------------------------------------------------------------

-- DROP PROCEDURE SP_CURSOS_SELECT_ALL;
DELIMITER //
CREATE PROCEDURE SP_CURSOS_SELECT_ALL()
BEGIN
	SELECT
		idCurso, nomCurso, abrevCurso, estadoRegistro
	FROM CURSOS
	ORDER BY idCurso;
END
//
DELIMITER ;

-- CALL SP_CURSOS_SELECT_ALL();

-- -------------------------------------------------------------
-- TABLA:					CUSOS
-- STORE PROCEDURE:			SP_CURSOS_SELECT_BY_ID()
-- DESCRIPCIÓN:				Obtiene un curso por Id
-- FECHA DE CREACIÓN:		2017-05-09
-- CREADO POR:				Palomino Rojas J. Abel
-- FECHA DE MODIFICACIÓN:
-- MODIFICADO POR:
-- --------------------------------------------------------------

-- DROP PROCEDURE SP_CURSOS_SELECT_BY_ID;

DELIMITER //
CREATE PROCEDURE SP_CURSOS_SELECT_BY_ID(IN p_idCurso INT)
 BEGIN
	SELECT
		idCurso, nomCurso, abrevCurso, estadoRegistro
	FROM CURSOS
	WHERE idCurso=p_idCurso;
END //
DELIMITER ;

-- CALL SP_CURSOS_SELECT_BY_ID(1);



-- -------------------------------------------------------------
-- TABLA:					ACTIVIDADES
-- STORE PROCEDURE:			SP_ACTIVIDADES_INSERT(?,?,?,?,?,?,?,?,?,?)
-- DESCRIPCIÓN:				Insertar datos de la actividad
-- FECHA DE CREACIÓN:		2017-05-21
-- CREADO POR:				Palomino Rojas J. Abel
-- FECHA DE MODIFICACIÓN:
-- MODIFICADO POR:
-- --------------------------------------------------------------

-- DROP PROCEDURE SP_ACTIVIDADES_INSERT;

DELIMITER //
CREATE PROCEDURE SP_ACTIVIDADES_INSERT
(
	IN p_idEmpleado int,
	IN p_idCurso int,
    IN p_codGrupoAcademico char(6),
	IN p_nomActividad varchar(50),
	IN p_descrActividad varchar(600),
	IN p_fechaRealizacion varchar(10),
	IN p_horaInicio varchar(10),
	IN p_horaFin varchar(10),
	IN p_frecuenciaAviso int
)
 BEGIN
	INSERT INTO ACTIVIDADES
    (idEmpleado, idCurso, codGrupoAcademico, nomActividad, descrActividad,
    fechaRealizacion, horaInicio, horaFin, frecuenciaAviso, flag_Notificado)
    VALUES
    (p_idEmpleado, p_idCurso, p_codGrupoAcademico, p_nomActividad, p_descrActividad,
    STR_TO_DATE(p_fechaRealizacion,'%d-%m-%Y'), STR_TO_DATE(p_horaInicio, '%h:%i %p'),
    STR_TO_DATE(p_horaFin, '%h:%i %p'), p_frecuenciaAviso, 1) ;
END //
DELIMITER ;

-- CALL SP_ACTIVIDADES_INSERT(1,3,'1A2017','examen final','examen','22-05-2017','8:30 PM','9:20 PM',1);



-- -------------------------------------------------------------
-- TABLA:					ACTIVIDADES
-- STORE PROCEDURE:			SP_ACTIVIDADES_UPDATE(?,?,?,?,?,?,?,?,?,?;?)
-- DESCRIPCIÓN:				Actualiza datos de la actividad
-- FECHA DE CREACIÓN:		2017-05-21
-- CREADO POR:				Palomino Rojas J. Abel
-- FECHA DE MODIFICACIÓN:
-- MODIFICADO POR:
-- --------------------------------------------------------------

-- DROP PROCEDURE SP_ACTIVIDADES_UPDATE;

DELIMITER //
CREATE PROCEDURE SP_ACTIVIDADES_UPDATE
(
	IN p_idEmpleado int,
	IN p_idCurso int,
    IN p_codGrupoAcademico char(6),
	IN p_nomActividad varchar(50),
	IN p_descrActividad varchar(600),
	IN p_fechaRealizacion varchar(10),
	IN p_horaInicio varchar(10),
	IN p_horaFin varchar(10),
	IN p_frecuenciaAviso int,
    IN p_idActividad int
)
 BEGIN
	UPDATE ACTIVIDADES SET
		idEmpleado=p_idEmpleado, idCurso=p_idCurso,
		codGrupoAcademico=p_codGrupoAcademico, nomActividad=p_nomActividad,
		descrActividad=p_descrActividad, fechaRealizacion=STR_TO_DATE(p_fechaRealizacion,'%d-%m-%Y'),
		horaInicio=STR_TO_DATE(p_horaInicio, '%h:%i %p'), horaFin=STR_TO_DATE(p_horaFin, '%h:%i %p'),
		frecuenciaAviso=p_frecuenciaAviso
    WHERE
		idActividad=p_idActividad;
END //
DELIMITER ;

-- CALL SP_ACTIVIDADES_UPDATE(1,3,'1A2017','examen final','examen','22-05-2017','8:30 PM','9:20 PM',1,2);


-- -------------------------------------------------------------
-- TABLA:					ACTIVIDADES
-- STORE PROCEDURE:			SP_ACTIVIDADES_SELECT_ALL()
-- DESCRIPCIÓN:				Listado de todas la actividades de forma desendente
-- FECHA DE CREACIÓN:		2017-05-21
-- CREADO POR:				Palomino Rojas J. Abel
-- FECHA DE MODIFICACIÓN:
-- MODIFICADO POR:
-- --------------------------------------------------------------

-- DROP PROCEDURE SP_ACTIVIDADES_SELECT_ALL;

DELIMITER //
CREATE PROCEDURE SP_ACTIVIDADES_SELECT_ALL()
 BEGIN
	SELECT
		A.idActividad,A.codGrupoAcademico,A.nomActividad, A.descrActividad,
		A.idCurso,C.nomCurso, DATE_FORMAT(A.fechaRealizacion,'%d-%m-%Y') as 'fechaRealizacion',
    TIME_FORMAT(A.horaInicio, '%h:%i %p') as 'horaInicio',TIME_FORMAT(A.horaFin, '%h:%i %p') as 'horaFin',
    A.frecuenciaAviso, A.flag_Notificado, A.idEmpleado
	FROM
		ACTIVIDADES A INNER JOIN CURSOS C ON A.idCurso = C.idCurso
	ORDER BY A.idActividad DESC;
END //
DELIMITER ;

-- CALL SP_ACTIVIDADES_SELECT_ALL();



-- -------------------------------------------------------------
-- TABLA:					ACTIVIDADES
-- STORE PROCEDURE:			SP_ACTIVIDADES_SELECT_BY_ID(?)
-- DESCRIPCIÓN:				Obtiene una actividad por ID
-- FECHA DE CREACIÓN:		2017-05-21
-- CREADO POR:				Palomino Rojas J. Abel
-- FECHA DE MODIFICACIÓN:
-- MODIFICADO POR:
-- --------------------------------------------------------------

-- DROP PROCEDURE SP_ACTIVIDADES_SELECT_BY_ID;

DELIMITER //
CREATE PROCEDURE SP_ACTIVIDADES_SELECT_BY_ID(IN p_idActividad INT)
 BEGIN
	SELECT
		A.idActividad,A.codGrupoAcademico,A.nomActividad, A.descrActividad,
		A.idCurso,C.nomCurso, DATE_FORMAT(A.fechaRealizacion,'%d-%m-%Y') as 'fechaRealizacion',
    TIME_FORMAT(A.horaInicio, '%h:%i %p') as 'horaInicio',TIME_FORMAT(A.horaFin, '%h:%i %p') as 'horaFin',
    A.frecuenciaAviso, A.flag_Notificado, A.idEmpleado
	FROM
		ACTIVIDADES A INNER JOIN CURSOS C ON A.idCurso = C.idCurso
	WHERE A.idActividad =p_idActividad;
END //
DELIMITER ;

-- CALL SP_ACTIVIDADES_SELECT_BY_ID(1);



-- -------------------------------------------------------------
-- TABLA:					ACTIVIDADES
-- STORE PROCEDURE:			SP_ACTIVIDADES_SELECT_ALL_PENDING()
-- DESCRIPCIÓN:				Listado de todas la actividades pendientes de forma desendente
-- FECHA DE CREACIÓN:		2017-05-21
-- CREADO POR:				Palomino Rojas J. Abel
-- FECHA DE MODIFICACIÓN:
-- MODIFICADO POR:
-- --------------------------------------------------------------

-- DROP PROCEDURE SP_ACTIVIDADES_SELECT_ALL_PENDING;

DELIMITER //
CREATE PROCEDURE SP_ACTIVIDADES_SELECT_ALL_PENDING()
 BEGIN
	SELECT
		A.idActividad,A.codGrupoAcademico,A.nomActividad, A.descrActividad,
		A.idCurso,C.nomCurso, DATE_FORMAT(A.fechaRealizacion,'%d-%m-%Y') as 'fechaRealizacion',
    TIME_FORMAT(A.horaInicio, '%h:%i %p') as 'horaInicio',TIME_FORMAT(A.horaFin, '%h:%i %p') as 'horaFin',
    A.frecuenciaAviso, A.flag_Notificado, A.idEmpleado
	FROM
		ACTIVIDADES A INNER JOIN CURSOS C ON A.idCurso = C.idCurso
	WHERE
		CONCAT(DATE(A.fechaRealizacion),'',A.horaFin) >= DATE_FORMAT(NOW(),'%Y-%m-%d %T')
	ORDER BY A.idActividad DESC;

END //
DELIMITER ;


-- -------------------------------------------------------------
-- TABLA:					ACTIVIDADES
-- STORE PROCEDURE:			SP_ACTIVIDADES_SELECT_LAST_INSERTED()
-- DESCRIPCIÓN:				Obtiene el ultimo registro
-- FECHA DE CREACIÓN:		2017-05-21
-- CREADO POR:				Palomino Rojas J. Abel
-- FECHA DE MODIFICACIÓN:
-- MODIFICADO POR:
-- --------------------------------------------------------------

-- DROP PROCEDURE SP_ACTIVIDADES_SELECT_LAST_INSERTED;

DELIMITER //
CREATE PROCEDURE SP_ACTIVIDADES_SELECT_LAST_INSERTED()
 BEGIN
 SELECT
   A.idActividad 'id',CONCAT(A.nomActividad,' - ',C.nomCurso) 'actividad',
   CONCAT(DATE_FORMAT(A.fechaRealizacion,'%d-%m-%Y'),' ', TIME_FORMAT(A.horaInicio, '%h:%i %p')) 'fecha'
 FROM
   ACTIVIDADES A INNER JOIN CURSOS C ON A.idCurso = C.idCurso
 ORDER BY A.idActividad DESC LIMIT 1;
END //
DELIMITER ;

-- CALL SP_ACTIVIDADES_SELECT_LAST_INSERTED();



-- DROP PROCEDURE SP_ACTIVIDADES_SELECT_NOTIFICATION_BY_ID;

DELIMITER //
CREATE PROCEDURE SP_ACTIVIDADES_SELECT_NOTIFICATION_BY_ID(IN p_idActividad INT)
 BEGIN
	SELECT
		A.idActividad 'id',CONCAT(A.nomActividad,' - ',C.nomCurso) 'actividad',
        CONCAT(DATE_FORMAT(A.fechaRealizacion,'%d-%m-%Y'),' ', TIME_FORMAT(A.horaInicio, '%h:%i %p')) 'fecha'
	FROM
		ACTIVIDADES A INNER JOIN CURSOS C ON A.idCurso = C.idCurso
	WHERE A.idActividad=p_idActividad;
END //
DELIMITER ;

-- CALL SP_ACTIVIDADES_SELECT_NOTIFICATION_BY_ID(16);



-- -------------------------------------------------------------
-- TABLA:					GRUPOACADEMICO
-- STORE PROCEDURE:			SP_GRUPOACADEMICO_SELECT_ALL()
-- DESCRIPCIÓN:				Listado de todos los GRUPOS ACADEMICOS
-- FECHA DE CREACIÓN:		2017-05-21
-- CREADO POR:				Palomino Rojas J. Abel
-- FECHA DE MODIFICACIÓN:
-- MODIFICADO POR:
-- --------------------------------------------------------------
-- DROP PROCEDURE SP_GRUPOACADEMICO_SELECT_ALL;
DELIMITER //
CREATE PROCEDURE SP_GRUPOACADEMICO_SELECT_ALL()
BEGIN
SELECT
	codGrupoAcademico, idGrado, codSeccion, anio, estadoRegistro
FROM
	GRUPOACADEMICO;
END
//
DELIMITER ;

-- CALL SP_GRUPOACADEMICO_SELECT_ALL();


-- -------------------------------------------------------------
-- TABLA:					GRUPOACADEMICO
-- STORE PROCEDURE:			SP_GRUPOACADEMICO_SELECT_BY_ID(?)
-- DESCRIPCIÓN:				Obtiene un grupo academico por codigo
-- FECHA DE CREACIÓN:		2017-05-21
-- CREADO POR:				Palomino Rojas J. Abel
-- FECHA DE MODIFICACIÓN:
-- MODIFICADO POR:
-- --------------------------------------------------------------
-- DROP PROCEDURE SP_GRUPOACADEMICO_SELECT_BY_ID;
DELIMITER //
CREATE PROCEDURE SP_GRUPOACADEMICO_SELECT_BY_ID(IN p_codGrupoAcademico CHAR(6))
BEGIN
SELECT
	codGrupoAcademico, idGrado, codSeccion, anio, estadoRegistro
FROM
	GRUPOACADEMICO
WHERE codGrupoAcademico=p_codGrupoAcademico;
END
//
DELIMITER ;


-- -------------------------------------------------------------
-- TABLA:					Lista de alumnos por apoderado
-- STORE PROCEDURE:			SP_ALUMNOS_SELECT_BY_IDApoderado()
-- DESCRIPCIÓN:				Obtiene la lista de los alumnos por apoderado(id)
-- FECHA DE CREACIÓN:		2017-06-14
-- CREADO POR:				Aruhanca Vilca Jhonatan
-- FECHA DE MODIFICACIÓN:
-- MODIFICADO POR:
-- --------------------------------------------------------------

-- DROP PROCEDURE SP_ALUMNOS_SELECT_BY_IDApoderado();

-- USE bd_sgmev3;

DELIMITER //
CREATE PROCEDURE SP_ALUMNOS_SELECT_BY_IDApoderado(IN p_idApoderado INT)

 BEGIN

	CREATE TEMPORARY TABLE temp_listAlumByApod as
	(select  n.idAlumno, MAX(n.idPeriodo) as peridoFinal
     from   notas n
    INNER JOIN alumnos_apoderados a
    on n.idAlumno = a.idAlumno where a.idApoderado = p_idApoderado
    group by n.idAlumno);

	select a.idAlumno, a.nombresAlumno,
			a.apPaternoAlumno, a.apMaternoAlumno, p.trimestre,
            p.anio, GA.idGrado, GA.codSeccion,
            COALESCE(ac.CantAC,0) AS CantAC, totalPromedio = 20
	from alumnos a
	inner join alumnos_apoderados ap
	on a.idAlumno = ap.idAlumno
    INNER JOIN alumnos_grupoacademico AG
		ON AG.idAlumno = a.idAlumno
        AND AG.estadoRegistro = 1 -- UltimoGrado
	INNER JOIN grupoacademico GA
		ON GA.codGrupoAcademico = AG.codGrupoAcademico
	LEFT JOIN temp_listAlumByApod t
    on a.idAlumno = t.idAlumno
    INNER JOIN periodos p
    on
    p.idPeriodo = t.peridoFinal
    LEFT JOIN(SELECT codGrupoAcademico,COUNT(1) AS CantAC FROM actividades
     GROUP BY codGrupoAcademico) ac
     on ac.codGrupoAcademico = AG.codGrupoAcademico
	where idApoderado = p_idApoderado;

    drop table temp_listAlumByApod;
END //
DELIMITER ;


-- CALL SP_ALUMNOS_SELECT_BY_IDApoderado(2)
